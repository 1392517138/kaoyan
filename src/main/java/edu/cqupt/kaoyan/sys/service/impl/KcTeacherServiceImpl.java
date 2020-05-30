package edu.cqupt.kaoyan.sys.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import edu.cqupt.kaoyan.sys.common.system.result.Result;
import edu.cqupt.kaoyan.sys.common.system.result.ResultCode;
import edu.cqupt.kaoyan.sys.entity.KcTeacher;
import edu.cqupt.kaoyan.sys.entity.Teacher;
import edu.cqupt.kaoyan.sys.mapper.KcTeacherMapper;
import edu.cqupt.kaoyan.sys.service.IKcTeacherService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.cqupt.kaoyan.sys.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * VIEW 服务实现类
 * </p>
 *
 * @author Aaron
 * @since 2020-05-28
 */
@Service
public class KcTeacherServiceImpl extends ServiceImpl<KcTeacherMapper, KcTeacher> implements IKcTeacherService {

    @Autowired
    ITeacherService iTeacherService;

    @Override
    public Result getKcByTeacherid(long teacherid) {
        List<KcTeacher> kcTeachers = this.getBaseMapper().selectList(Wrappers.<KcTeacher>lambdaQuery().eq(KcTeacher::getTeacherid, teacherid));
        return new Result(ResultCode.SUCCESS, kcTeachers);
    }

    @Override
    public Result searchByXm(String xm) {
        List<Teacher> teachers = iTeacherService.getBaseMapper().selectList(Wrappers.<Teacher>lambdaQuery().like(Teacher::getXm, xm));
        return new Result(ResultCode.SUCCESS, teachers);
    }
}
