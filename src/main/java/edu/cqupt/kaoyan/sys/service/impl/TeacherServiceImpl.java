package edu.cqupt.kaoyan.sys.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.cqupt.kaoyan.sys.common.system.result.Result;
import edu.cqupt.kaoyan.sys.common.system.result.ResultCode;
import edu.cqupt.kaoyan.sys.entity.Teacher;
import edu.cqupt.kaoyan.sys.mapper.TeacherMapper;
import edu.cqupt.kaoyan.sys.service.ITeacherService;
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
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements ITeacherService {

    @Override
    public Result getTeacherByXymc(String xymc) {
        List<Teacher> teachers = this.getBaseMapper().selectList(Wrappers.<Teacher>lambdaQuery().eq(Teacher::getXymc, xymc));
        return new Result(ResultCode.SUCCESS, teachers);
    }
}
