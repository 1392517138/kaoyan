package edu.cqupt.kaoyan.sys.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.cqupt.kaoyan.sys.entity.QrImgAttachment;
import edu.cqupt.kaoyan.sys.mapper.QrImgAttachmentMapper;
import edu.cqupt.kaoyan.sys.service.IQrImgAttachmentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Aaron
 * @since 2020-04-16
 */
@Service
public class QrImgAttachmentServiceImpl extends ServiceImpl<QrImgAttachmentMapper, QrImgAttachment> implements IQrImgAttachmentService {

    /**
     * 获得附件url
     *
     * @param quesId
     * @return
     */
    @Override
    public List<String> getByParent(Long quesId) {
        List<QrImgAttachment> list = list(Wrappers.<QrImgAttachment>lambdaQuery().select(x -> x.isSelect()).eq(QrImgAttachment::getParent, quesId));
        return list.stream().map(QrImgAttachment::getImgUrl).collect(Collectors.toList());
    }
}
