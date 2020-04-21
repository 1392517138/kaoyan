package edu.cqupt.kaoyan.sys.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * VIEW
 * </p>
 *
 * @author Aaron
 * @since 2020-04-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class AdminCheck implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 分享文件名称
     */
    private String shareName;

    /**
     * 文件类型
     */
    private String shareType;

    /**
     * 分享地址
     */
    private String shareStream;

    /**
     * 0为未通过，1为通过
     */
    private Integer checked;

    private Long shareId;

    /**
     * 课程id
     */
    private String courseId;

    /**
     * 学生id
     */
    private Long stuId;

    private String stuEmail;

    private String stuName;

    private Integer stuSex;

    private String stuHead;


}
