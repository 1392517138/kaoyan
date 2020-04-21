package edu.cqupt.kaoyan.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import edu.cqupt.kaoyan.sys.entity.QrImgAttachment;
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
public interface IQrImgAttachmentService extends IService<QrImgAttachment> {
    /**
     * 获得附件url
     *
     * @param quesId
     * @return
     */
    List<String> getByParent(Long quesId);
}
