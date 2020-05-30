package edu.cqupt.kaoyan.sys.service.impl;

import edu.cqupt.kaoyan.sys.common.system.result.Result;
import edu.cqupt.kaoyan.sys.common.system.result.ResultCode;
import edu.cqupt.kaoyan.sys.entity.Zy;
import edu.cqupt.kaoyan.sys.mapper.ZyMapper;
import edu.cqupt.kaoyan.sys.service.IZyService;
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
public class ZyServiceImpl extends ServiceImpl<ZyMapper, Zy> implements IZyService {

    @Override
    public Result getZy() {
        List<Zy> zies = this.getBaseMapper().selectList(null);
        return new Result(ResultCode.SUCCESS, zies);
    }
}
