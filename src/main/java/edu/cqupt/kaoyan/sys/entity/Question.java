package edu.cqupt.kaoyan.sys.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 *
 * @author Aaron
 * @since 2020-04-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Question implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 问题id号
     */
    @TableId
    private Long quesId;

    /**
     * 问题描述
     */
    private String quesDescr;

    /**
     * 问题创建时间
     */
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
//    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime quesCreateAt;

    /**
     * 课程id号
     */
    private Long courseId;

    /**
     * 学生id号
     */
    private Long stuId;

    /**
     * 0为有新的回复，1为没有
     */
    private Integer isread;


}
