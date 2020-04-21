package edu.cqupt.kaoyan.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import edu.cqupt.kaoyan.sys.entity.DTO.MoocPageDTO;
import edu.cqupt.kaoyan.sys.entity.Mooc;
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
 * @since 2020-04-17
 */
@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public interface IMoocService extends IService<Mooc> {

    /**
     * 获得Mooc列表
     *
     * @return
     */
    MoocPageDTO getMoocs(Integer page);

    /**
     * 按照课程名字搜索
     *
     * @param name
     * @param name
     * @return
     */
    List<Mooc> searchMooc(String name);

    /**
     * 获得mooc下的资源,pdf或者Mp4
     *
     * @return
     */
    List getMoocResources(String type, String courseId);
}
