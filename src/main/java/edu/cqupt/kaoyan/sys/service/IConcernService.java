package edu.cqupt.kaoyan.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import edu.cqupt.kaoyan.sys.common.system.result.Result;
import edu.cqupt.kaoyan.sys.entity.Concern;
import edu.cqupt.kaoyan.sys.entity.ConcernMooc;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author Aaron
 * @since 2020-04-19
 */
@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public interface IConcernService extends IService<Concern> {


    /**
     * 添加或取消 收藏课程
     *
     * @param courseId
     * @param stuId
     */
    Result addeCourse(String courseId, Long stuId);

    /**
     * 查看收藏的课程
     *
     * @param stuId
     */
    List<ConcernMooc> viewAddCourse(Long stuId);
}
