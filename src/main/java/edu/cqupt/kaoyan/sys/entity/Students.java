package edu.cqupt.kaoyan.sys.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;


/**
 * <p>
 *
 * </p>
 *
 * @author Aaron
 * @since 2020-04-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Students {

    private static final long serialVersionUID = 1L;

    @TableId(value = "stu_id")
    private Long stuId;

    private String stuEmail;

    private String stuPwd;

    private String stuName;

    private Integer stuSex;

    private String stuHead;

    private Integer stuGrade;

    private Integer stuMajor;

    @Version
    private Integer version;

    @TableLogic
    @TableField(select = false)
    private transient Byte deleted;

    @TableField(fill = FieldFill.INSERT, select = false)
    private transient LocalDateTime createTime;

    @TableField(fill = FieldFill.UPDATE, select = false)
    private transient LocalDateTime updateTime;


}
