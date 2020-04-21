package edu.cqupt.kaoyan.sys.entity;

import lombok.*;
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
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class QuestionList implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 问题id号
     */
    private Long quesId;
    /**
     * 用户id
     */
    private Long stuId;
    /**
     * 课程名
     */
    private String couName;

    /**
     * 学院名
     */
    private String collegeName;

    /**
     * 专业名
     */
    private String majorName;

    /**
     * 问题描述
     */
    private String quesDescr;

    /**
     * 问题创建时间
     */
    private LocalDateTime quesCreateAt;

    /**
     * 0为有新的回复，1为没有
     */
    private Integer isread;

    private String stuName;

    private String stuHead;


}
