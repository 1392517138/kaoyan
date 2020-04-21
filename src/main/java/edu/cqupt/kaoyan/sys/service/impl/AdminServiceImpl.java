package edu.cqupt.kaoyan.sys.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.cqupt.kaoyan.sys.common.system.result.Result;
import edu.cqupt.kaoyan.sys.common.system.result.ResultCode;
import edu.cqupt.kaoyan.sys.common.utils.JwtUtils;
import edu.cqupt.kaoyan.sys.entity.*;
import edu.cqupt.kaoyan.sys.entity.DTO.AdminCheckPageDTO;
import edu.cqupt.kaoyan.sys.entity.DTO.AdminLoginDTO;
import edu.cqupt.kaoyan.sys.entity.DTO.CheckDTO;
import edu.cqupt.kaoyan.sys.mapper.AdminMapper;
import edu.cqupt.kaoyan.sys.service.*;
import lombok.extern.slf4j.Slf4j;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Aaron
 * @since 2020-04-19
 */
@Service
@Slf4j
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminService {

    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private IAdminCheckService iAdminCheckService;
    @Autowired
    private Mapper dozerMapper;
    @Autowired
    private ICheckShareService iCheckShareService;
    @Autowired
    private IResourceService iResourceServicel;
    @Autowired
    private IMp4Service iMp4Service;
    @Autowired
    private IPdfService iPdfService;
    @Autowired
    private IOtherService iOtherService;

    @Value("${mybatis-plus.pageInfo.size}")
    private Integer size;

    @Override
    public Result login(AdminLoginDTO adminLoginDTO) {
        String adminName = adminLoginDTO.getAdminName();
        String adminPwd = adminLoginDTO.getAdminPwd();
        Admin admin = this.getOne(Wrappers.<Admin>lambdaQuery().eq(Admin::getAdminName, adminName));
        //如果失败
        if (admin == null || !admin.getAdminPwd().equals(adminPwd)) {
            return new Result(ResultCode.EMAILORPASSWORDERROR);
        } else {
            String token = jwtUtils.createJwt(admin.getAdminId());
            redisTemplate.opsForValue().set(admin.getAdminId().toString(), admin, 24, TimeUnit.HOURS);
            return new Result(ResultCode.SUCCESS, token);
        }
    }

    @Override
    public AdminCheckPageDTO viewShare(Integer page) {
        Page<AdminCheck> pageInfo = new Page<>(page, size);
        IPage<AdminCheck> adminCheckPage = iAdminCheckService.getBaseMapper().selectPage(pageInfo, null);
        return new AdminCheckPageDTO(adminCheckPage.getRecords(), adminCheckPage.getPages(), adminCheckPage.getSize(), adminCheckPage.getTotal());
    }

    @Override
    public void setCross(CheckDTO checkDTO) {
        CheckShare check = dozerMapper.map(checkDTO, CheckShare.class);

        //如果设置未通过
        log.info(checkDTO.toString());
        if (0 == check.getChecked()) {
            //进行物理删除
            iResourceServicel.removeById(check.getResourceId());
        } else if (1 == check.getChecked()) {
            //如果设置通过
            //插入resource表
            AdminCheck adminCheck = iAdminCheckService.getOne(Wrappers.<AdminCheck>lambdaQuery().eq(AdminCheck::getShareId, check.getShareId()));
            Resource resource = new Resource();
            resource.setCourseId(adminCheck.getCourseId());
            resource.setResourceType(adminCheck.getShareType());
            resource.setResourceName(adminCheck.getShareName());
            log.info(resource.toString());

            iResourceServicel.save(resource);
            //插入pdf或者mp4、other表
            //1.设置check_share中的resoureceId
            check.setResourceId(resource.getResourceId());
            inseretAttachment(adminCheck, resource);
        }

        //更新check_share表
        iCheckShareService.saveOrUpdate(check);

    }

    private void inseretAttachment(AdminCheck adminCheck, Resource resource) {
        if ("mp4".equals(adminCheck.getShareType())) {
            Mp4 mp4 = new Mp4();
            mp4.setMp4Url(adminCheck.getShareStream());
            mp4.setResourceId(resource.getResourceId());
            iMp4Service.save(mp4);
        } else if ("pdf".equals(adminCheck.getShareType())) {
            Pdf pdf = new Pdf();
            pdf.setPdfUrl(adminCheck.getShareStream());
            pdf.setResourceId(resource.getResourceId());
            iPdfService.save(pdf);
        } else {
            Other other = new Other();
            other.setOtherUrl(adminCheck.getShareStream());
            other.setResourceId(resource.getResourceId());
            iOtherService.save(other);
        }
    }
}
