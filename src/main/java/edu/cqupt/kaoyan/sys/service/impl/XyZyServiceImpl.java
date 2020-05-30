package edu.cqupt.kaoyan.sys.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import edu.cqupt.kaoyan.sys.common.system.result.Result;
import edu.cqupt.kaoyan.sys.common.system.result.ResultCode;
import edu.cqupt.kaoyan.sys.entity.XyZy;
import edu.cqupt.kaoyan.sys.mapper.XyZyMapper;
import edu.cqupt.kaoyan.sys.service.IXyZyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * VIEW 服务实现类
 * </p>
 *
 * @author Aaron
 * @since 2020-05-29
 */
@Service
public class XyZyServiceImpl extends ServiceImpl<XyZyMapper, XyZy> implements IXyZyService {

    @Override
    public Result getXyZy() {
        List<XyZy> xyZIES = this.getBaseMapper().selectList(null);
        return new Result(ResultCode.SUCCESS, xyZIES);
    }


}
