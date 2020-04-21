package edu.cqupt.kaoyan.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.cqupt.kaoyan.sys.common.utils.DozerUtil;
import edu.cqupt.kaoyan.sys.common.utils.UploadUtils;
import edu.cqupt.kaoyan.sys.entity.DTO.AQuestionDTO;
import edu.cqupt.kaoyan.sys.entity.DTO.QuestionListDTO;
import edu.cqupt.kaoyan.sys.entity.QrImgAttachment;
import edu.cqupt.kaoyan.sys.entity.Question;
import edu.cqupt.kaoyan.sys.entity.QuestionList;
import edu.cqupt.kaoyan.sys.mapper.QuestionMapper;
import edu.cqupt.kaoyan.sys.service.IQrImgAttachmentService;
import edu.cqupt.kaoyan.sys.service.IQuestionListService;
import edu.cqupt.kaoyan.sys.service.IQuestionService;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class QuestionServiceImpl extends ServiceImpl<QuestionMapper, Question> implements IQuestionService {
    @Autowired
    private Mapper dozerMapper;
    @Autowired
    private IQrImgAttachmentService iQrImgAttachmentService;
    @Autowired
    private IQuestionListService iQuestionListService;

    @Override
    public void publishQuestion(MultipartFile[] files, AQuestionDTO aQuestionDTO, Long stuId) {
        Question question = dozerMapper.map(aQuestionDTO, Question.class);
        question.setStuId(stuId);
        //1.保存question
        save(question);
        //2.设置附件
        if (files != null) {
            Arrays.stream(files).forEach(f -> {
                String url = UploadUtils.uploadImage(f);
                iQrImgAttachmentService.save(new QrImgAttachment(url, question.getQuesId()));
            });
        }

    }

    @Override
    public List<QuestionListDTO> viewYourQuestions(Long stuId) {
        List<QuestionList> questionList = iQuestionListService.getQuestionList(stuId);
        log.info(stuId.toString());
        List<QuestionListDTO> questionListDTOS = DozerUtil.mapList(questionList, QuestionListDTO.class);
        //添加附件地址
        questionListDTOS.forEach(System.out::println);
        questionListDTOS.forEach(d -> {
            d.getUrl().addAll(iQrImgAttachmentService.getByParent(d.getQuesId()));
        });
        return questionListDTOS;
    }

    @Override
    public QuestionListDTO viewQuestions(Long quesId) {
        QuestionList questionList = iQuestionListService.getById(quesId);
        QuestionListDTO questionListDTO = dozerMapper.map(questionList, QuestionListDTO.class);
        questionListDTO.getUrl().addAll(iQrImgAttachmentService.getByParent(quesId));
        return questionListDTO;
    }

}
