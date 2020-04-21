package edu.cqupt.kaoyan.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import edu.cqupt.kaoyan.sys.entity.DTO.AReplyDTO;
import edu.cqupt.kaoyan.sys.entity.DTO.ReplyListDTO;
import edu.cqupt.kaoyan.sys.entity.Reply;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author Aaron
 * @since 2020-04-15
 */
@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public interface IReplyService extends IService<Reply> {

    /**
     * 发布回复
     *
     * @param files
     * @param aReplyDTO
     */
    void publishReply(MultipartFile[] files, AReplyDTO aReplyDTO, Long stuId);

    /**
     * 针对问题查看回复
     *
     * @param quesId
     * @return
     */
    List<ReplyListDTO> viewReply(Long quesId);
}
