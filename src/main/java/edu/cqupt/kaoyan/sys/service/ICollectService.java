package edu.cqupt.kaoyan.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import edu.cqupt.kaoyan.sys.common.system.result.Result;
import edu.cqupt.kaoyan.sys.entity.Collect;
import edu.cqupt.kaoyan.sys.entity.CollectResource;
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
 * @since 2020-04-16
 */
@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public interface ICollectService extends IService<Collect> {


    /**
     * 添加、取消 自己收藏的资源
     *
     * @param resourceId
     * @param stuId
     */
    Result addeCollect(Integer resourceId, Long stuId);

    /**
     * 查看自己收藏的资源
     *
     * @param stuId
     * @return
     */
    List<CollectResource> viewAddCollect(Long stuId);


}
