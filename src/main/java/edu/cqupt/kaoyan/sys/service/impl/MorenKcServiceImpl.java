package edu.cqupt.kaoyan.sys.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.cqupt.kaoyan.sys.common.system.result.Result;
import edu.cqupt.kaoyan.sys.common.system.result.ResultCode;
import edu.cqupt.kaoyan.sys.entity.DTO.MrkcResourceDTO;
import edu.cqupt.kaoyan.sys.entity.DTO.PDF;
import edu.cqupt.kaoyan.sys.entity.MorenKc;
import edu.cqupt.kaoyan.sys.entity.MrkcPdf;
import edu.cqupt.kaoyan.sys.mapper.MorenKcMapper;
import edu.cqupt.kaoyan.sys.mapper.XyZyMapper;
import edu.cqupt.kaoyan.sys.service.IMorenKcService;
import edu.cqupt.kaoyan.sys.service.IMrkcPdfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Aaron
 * @since 2020-05-28
 */
@Service
public class MorenKcServiceImpl extends ServiceImpl<MorenKcMapper, MorenKc> implements IMorenKcService {
    @Autowired
    MorenKcMapper morenKcMapper;
    @Autowired
    IMrkcPdfService iMrkcPdfService;
    @Autowired
    XyZyMapper xyZyMapper;


    private Result setMrkcResourceDTO(String kcbh, String type, List<String> resourceId) {
        List<MrkcPdf> mrkcPdfs = new LinkedList<>();
        MrkcResourceDTO mrkcResourceDTO;
        List<PDF> pdfs;
        for (String s : resourceId) {
            mrkcPdfs = iMrkcPdfService.getBaseMapper().selectList(Wrappers.<MrkcPdf>lambdaQuery().eq(MrkcPdf::getResourceId, s));
        }
        mrkcResourceDTO = new MrkcResourceDTO();
        mrkcResourceDTO.setKcbh(kcbh);
        mrkcResourceDTO.setResourceType(type);
        pdfs = new LinkedList<>();
        for (MrkcPdf mrkcPdf : mrkcPdfs) {
            pdfs.add(new PDF(mrkcPdf.getResourceName(), mrkcPdf.getPdfUrl()));
        }
        mrkcResourceDTO.setPdfs(pdfs);
        return new Result(ResultCode.SUCCESS, mrkcResourceDTO);
    }

    @Override
    public Result getResource(String kcbh, String type) {
        /**
         * type=(dxfa,jxdg,ksdg,zsdtx)
         */

        if ("dxfa".equals(type)) {
            List<String> resourceId = morenKcMapper.getDxfaId(kcbh);
            return setMrkcResourceDTO(kcbh, type, resourceId);
        } else if ("jxdg".equals(type)) {
            List<String> resourceId = morenKcMapper.getJxdgId(kcbh);
            return setMrkcResourceDTO(kcbh, type, resourceId);
        } else if ("ksdg".equals(type)) {
            List<String> resourceId = morenKcMapper.getKsdgId(kcbh);
            return setMrkcResourceDTO(kcbh, type, resourceId);
        } else if ("zsdtx".equals(type)) {
            List<String> resourceId = morenKcMapper.getZsdtxId(kcbh);
            return setMrkcResourceDTO(kcbh, type, resourceId);
        } else {
            return new Result(ResultCode.ARGSERROR);
        }
    }

    @Override
    public Result getKcByKcbh(String kcbh) {
        MorenKc one = this.getOne(Wrappers.<MorenKc>lambdaQuery().eq(MorenKc::getKcbh, kcbh));
        return new Result(ResultCode.SUCCESS, one);
    }

    @Override
    public List<MorenKc> getKcByXymc(String xymc) {
        List<MorenKc> morenKcs = this.getBaseMapper().selectList(Wrappers.<MorenKc>lambdaQuery().eq(MorenKc::getKkxymc, xymc));
        return morenKcs;
    }

    @Override
    public List<MorenKc> searchByKcmc(String kcmc) {
        List<MorenKc> morenKcs = this.getBaseMapper().selectList(Wrappers.<MorenKc>lambdaQuery().like(MorenKc::getKcmc, kcmc));
        return morenKcs;
    }

    @Override
    public Result searchByZyhAndXyh(String zyh, String xyh) {
        List<String> kcbhs = morenKcMapper.selectKcbhByZyhAndXyh(zyh, xyh);
        List<MorenKc> lists = new LinkedList<>();
        for (String kcbh : kcbhs) {
            MorenKc morenKcById = morenKcMapper.getMorenKcById(kcbh);
            lists.add(morenKcById);
        }
        return new Result(ResultCode.SUCCESS, lists);
    }


    @Override
    public Result getUnknowXy() {
        List<MorenKc> morenKcs = this.getBaseMapper().selectList(Wrappers.<MorenKc>lambdaQuery().select(MorenKc::getKkxymc));
        List<String> collect = morenKcs.stream().map(MorenKc::getKkxymc).distinct().collect(Collectors.toList());
        return new Result(ResultCode.SUCCESS, collect);
    }


}
