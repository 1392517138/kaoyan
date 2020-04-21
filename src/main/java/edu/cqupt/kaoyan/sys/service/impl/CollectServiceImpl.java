package edu.cqupt.kaoyan.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.cqupt.kaoyan.sys.common.system.result.Result;
import edu.cqupt.kaoyan.sys.common.system.result.ResultCode;
import edu.cqupt.kaoyan.sys.entity.Collect;
import edu.cqupt.kaoyan.sys.entity.CollectResource;
import edu.cqupt.kaoyan.sys.mapper.CollectMapper;
import edu.cqupt.kaoyan.sys.service.ICollectResourceService;
import edu.cqupt.kaoyan.sys.service.ICollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Aaron
 * @since 2020-04-16
 */
@Service
public class CollectServiceImpl extends ServiceImpl<CollectMapper, Collect> implements ICollectService {

    @Autowired
    ICollectResourceService iCollectResourceService;

    @Override
    public Result addeCollect(Integer resourceId, Long stuId) {
        Collect collect = new Collect(stuId, resourceId);
        LambdaQueryWrapper<Collect> eq = Wrappers.<Collect>lambdaQuery().eq(Collect::getStuId, stuId).eq(Collect::getResourceId, resourceId);
        Collect one = getOne(eq);
        Result result = null;
        //如果不存在
        if (one == null) {
            collect.setFlag(0);
            save(collect);
            result = new Result(ResultCode.ADDCOLLECTSUCESS);
        } else {
            if (one.getFlag() == 1) {
                one.setFlag(0);
                result = new Result(ResultCode.ADDCOLLECTSUCESS);
            } else {
                one.setFlag(1);
                result = new Result(ResultCode.DELCOLLECTSUCCESS);
            }
            update(one, eq);
        }
        return result;
    }


    @Override
    public List<CollectResource> viewAddCollect(Long stuId) {
        return iCollectResourceService.getBaseMapper().selectList(Wrappers.<CollectResource>lambdaQuery().eq(CollectResource::getStuId, stuId));
    }
}
