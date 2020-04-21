package edu.cqupt.kaoyan.sys.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.cqupt.kaoyan.sys.entity.DTO.MoocPageDTO;
import edu.cqupt.kaoyan.sys.entity.Mooc;
import edu.cqupt.kaoyan.sys.entity.MoocMp4;
import edu.cqupt.kaoyan.sys.entity.MoocPdf;
import edu.cqupt.kaoyan.sys.mapper.MoocMapper;
import edu.cqupt.kaoyan.sys.service.IMoocMp4Service;
import edu.cqupt.kaoyan.sys.service.IMoocPdfService;
import edu.cqupt.kaoyan.sys.service.IMoocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Aaron
 * @since 2020-04-17
 */
@Service
public class MoocServiceImpl extends ServiceImpl<MoocMapper, Mooc> implements IMoocService {

    @Autowired
    IMoocMp4Service iMoocMp4Service;
    @Autowired
    IMoocPdfService iMoocPdfService;

    @Value("${mybatis-plus.pageInfo.size}")
    private Integer size;

    @Override
    public MoocPageDTO getMoocs(Integer page) {
        Page<Mooc> pageInfo = new Page<>(page, size);
        IPage<Mooc> moocPage = this.baseMapper.selectPage(pageInfo, null);
        return new MoocPageDTO(moocPage.getRecords(), moocPage.getPages(), moocPage.getSize(), moocPage.getTotal());

    }

    @Override
    public List<Mooc> searchMooc(String name) {
        return list(Wrappers.<Mooc>lambdaQuery().select().like(Mooc::getName, name));
    }

    @Override
    public List getMoocResources(String type, String courseId) {
        List list = new LinkedList();
        if ("mp4".equals(type)) {
            list.addAll(iMoocMp4Service.list(Wrappers.<MoocMp4>lambdaQuery().eq(MoocMp4::getCourseId, courseId)));
        } else if ("pdf".equals(type)) {
            list.addAll(iMoocPdfService.list(Wrappers.<MoocPdf>lambdaQuery().eq(MoocPdf::getCourseId, courseId)));
        }
        return list;
    }
}
