package edu.cqupt.kaoyan.sys.service;

import edu.cqupt.kaoyan.sys.common.system.result.Result;
import edu.cqupt.kaoyan.sys.entity.Teacher;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author Aaron
 * @since 2020-05-28
 */
public interface ITeacherService extends IService<Teacher> {

    /**
     * 根据学院名称获取老师
     *
     * @param xymc
     * @return
     */
    Result getTeacherByXymc(String xymc);

}
