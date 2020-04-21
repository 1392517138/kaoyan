package edu.cqupt.kaoyan.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.cqupt.kaoyan.sys.common.utils.DozerUtil;
import edu.cqupt.kaoyan.sys.common.utils.UploadUtils;
import edu.cqupt.kaoyan.sys.entity.DTO.AReplyDTO;
import edu.cqupt.kaoyan.sys.entity.DTO.ReplyListDTO;
import edu.cqupt.kaoyan.sys.entity.QrImgAttachment;
import edu.cqupt.kaoyan.sys.entity.Reply;
import edu.cqupt.kaoyan.sys.entity.ReplyList;
import edu.cqupt.kaoyan.sys.mapper.ReplyMapper;
import edu.cqupt.kaoyan.sys.service.IQrImgAttachmentService;
import edu.cqupt.kaoyan.sys.service.IReplyService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Aaron
 * @since 2020-04-15
 */
@Service
public class ReplyServiceImpl extends ServiceImpl<ReplyMapper, Reply> implements IReplyService {
    @Autowired
    private Mapper dozerMapper;
    @Autowired
    private IQrImgAttachmentService iQrImgAttachmentService;
    @Autowired
    private ReplyListServiceImpl replyListService;

    @Override
    public void publishReply(MultipartFile[] files, AReplyDTO aReplyDTO, Long stuId) {
        Reply reply = dozerMapper.map(aReplyDTO, Reply.class);
        reply.setStuId(stuId);
        //1.reply
        save(reply);
        //2.设置附件
        if (files != null) {
            Arrays.stream(files).forEach(f -> {
                String url = UploadUtils.uploadImage(f);
                iQrImgAttachmentService.save(new QrImgAttachment(url, reply.getQuesId()));
            });
        }
    }

    @Override
    public List<ReplyListDTO> viewReply(Long quesId) {
        List<ReplyList> replyLists = replyListService.getReplyList(quesId);
        List<ReplyListDTO> replyListDTOS = DozerUtil.mapList(replyLists, ReplyListDTO.class);
        //添加附件地址
        replyListDTOS.forEach(r -> {
            r.getUrl().addAll(iQrImgAttachmentService.getByParent(r.getQuesId()));
        });
        return replyListDTOS;
    }
}
