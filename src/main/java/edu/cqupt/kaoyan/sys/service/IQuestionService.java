package edu.cqupt.kaoyan.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import edu.cqupt.kaoyan.sys.entity.DTO.AQuestionDTO;
import edu.cqupt.kaoyan.sys.entity.DTO.QuestionListDTO;
import edu.cqupt.kaoyan.sys.entity.Question;
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
public interface IQuestionService extends IService<Question> {

    /**
     * 发布问题
     *
     * @param files
     * @param aQuestionDTO
     */
    void publishQuestion(MultipartFile[] files, AQuestionDTO aQuestionDTO, Long stuId);

    /**
     * 查看自己发布的问题
     *
     * @param stuId
     * @return
     */
    List<QuestionListDTO> viewYourQuestions(Long stuId);


    /**
     * 根据quesId查看问题
     *
     * @return
     */
    QuestionListDTO viewQuestions(Long quesId);
}
