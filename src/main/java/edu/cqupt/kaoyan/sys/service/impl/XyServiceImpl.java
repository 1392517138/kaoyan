package edu.cqupt.kaoyan.sys.service.impl;

import edu.cqupt.kaoyan.sys.common.system.result.Result;
import edu.cqupt.kaoyan.sys.common.system.result.ResultCode;
import edu.cqupt.kaoyan.sys.entity.Xy;
import edu.cqupt.kaoyan.sys.mapper.XyMapper;
import edu.cqupt.kaoyan.sys.service.IXyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Aaron
 * @since 2020-05-28
 */
@Service
public class XyServiceImpl extends ServiceImpl<XyMapper, Xy> implements IXyService {

    @Override
    public Result getXy() {
        List<Xy> xies = this.getBaseMapper().selectList(null);
        return new Result(ResultCode.SUCCESS, xies);
    }
}
