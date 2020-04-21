package edu.cqupt.kaoyan.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.cqupt.kaoyan.sys.common.system.result.Result;
import edu.cqupt.kaoyan.sys.common.system.result.ResultCode;
import edu.cqupt.kaoyan.sys.entity.Concern;
import edu.cqupt.kaoyan.sys.entity.ConcernMooc;
import edu.cqupt.kaoyan.sys.mapper.ConcernMapper;
import edu.cqupt.kaoyan.sys.service.IConcernMoocService;
import edu.cqupt.kaoyan.sys.service.IConcernService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Aaron
 * @since 2020-04-19
 */
@Service
public class ConcernServiceImpl extends ServiceImpl<ConcernMapper, Concern> implements IConcernService {

    @Autowired
    private IConcernMoocService iConcernMoocService;

    @Override
    public Result addeCourse(String courseId, Long stuId) {
        Concern concern = new Concern(stuId, courseId);
        LambdaQueryWrapper<Concern> eq = Wrappers.<Concern>lambdaQuery().eq(Concern::getStuId, stuId).eq(Concern::getCourseId, concern.getCourseId());
        Concern one = getOne(eq);
        Result result = null;
        //如果不存在
        if (one == null) {
            concern.setFlag(0);
            save(concern);
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
    public List<ConcernMooc> viewAddCourse(Long stuId) {
        return iConcernMoocService.getBaseMapper().selectList(Wrappers.<ConcernMooc>lambdaQuery().eq(ConcernMooc::getStuId, stuId));
    }
}
