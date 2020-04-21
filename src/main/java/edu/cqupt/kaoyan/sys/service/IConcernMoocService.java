package edu.cqupt.kaoyan.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import edu.cqupt.kaoyan.sys.entity.ConcernMooc;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * VIEW 服务类
 * </p>
 *
 * @author Aaron
 * @since 2020-04-19
 */
@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public interface IConcernMoocService extends IService<ConcernMooc> {

}
