package edu.cqupt.kaoyan.sys.service;

import edu.cqupt.kaoyan.sys.common.system.result.Result;
import edu.cqupt.kaoyan.sys.entity.KcTeacher;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * VIEW 服务类
 * </p>
 *
 * @author Aaron
 * @since 2020-05-28
 */
public interface IKcTeacherService extends IService<KcTeacher> {

    /**
     * 根据老师id查看其所教的课程
     *
     * @param teacherid
     * @return
     */
    Result getKcByTeacherid(long teacherid);

    /**
     * 根据老师名称查看其教授的课程
     *
     * @param xm
     * @return
     */
    Result searchByXm(String xm);
}
