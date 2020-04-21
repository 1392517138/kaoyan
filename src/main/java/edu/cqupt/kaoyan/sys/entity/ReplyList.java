package edu.cqupt.kaoyan.sys.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * VIEW
 * </p>
 *
 * @author Aaron
 * @since 2020-04-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ReplyList implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long quesId;
    /**
     * 回复内容
     */
    private String replyDescr;

    /**
     * 回复时间
     */
    private LocalDateTime replyCreateAt;

    private String stuName;

    private String stuHead;


}
