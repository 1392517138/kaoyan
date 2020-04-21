package edu.cqupt.kaoyan.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import edu.cqupt.kaoyan.sys.entity.ReplyList;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * VIEW 服务类
 * </p>
 *
 * @author Aaron
 * @since 2020-04-16
 */
@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public interface IReplyListService extends IService<ReplyList> {


    /**
     * 获得回复列表
     *
     * @param quesId
     * @return
     */
    List<ReplyList> getReplyList(Long quesId);
}
