package edu.cqupt.kaoyan.sys.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.cqupt.kaoyan.sys.entity.ReplyList;
import edu.cqupt.kaoyan.sys.mapper.ReplyListMapper;
import edu.cqupt.kaoyan.sys.service.IReplyListService;
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
public class ReplyListServiceImpl extends ServiceImpl<ReplyListMapper, ReplyList> implements IReplyListService {

    @Override
    public List<ReplyList> getReplyList(Long quesId) {
        return list(Wrappers.<ReplyList>lambdaQuery().eq(ReplyList::getQuesId, quesId));
    }
}
