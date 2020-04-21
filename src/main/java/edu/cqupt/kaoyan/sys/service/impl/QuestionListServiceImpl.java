package edu.cqupt.kaoyan.sys.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.cqupt.kaoyan.sys.entity.QuestionList;
import edu.cqupt.kaoyan.sys.mapper.QuestionListMapper;
import edu.cqupt.kaoyan.sys.service.IQuestionListService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * VIEW 服务实现类
 * </p>
 *
 * @author Aaron
 * @since 2020-04-16
 */
@Service
public class QuestionListServiceImpl extends ServiceImpl<QuestionListMapper, QuestionList> implements IQuestionListService {

    /**
     * 获得问题列表
     *
     * @param stuId
     * @return
     */
    @Override
    public List<QuestionList> getQuestionList(Long stuId) {
        return list(Wrappers.<QuestionList>lambdaQuery().eq(QuestionList::getStuId, stuId));
    }
}
