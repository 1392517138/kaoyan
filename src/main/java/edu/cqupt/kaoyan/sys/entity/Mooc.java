package edu.cqupt.kaoyan.sys.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author Aaron
 * @since 2020-04-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Mooc implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 课程名称
     */
    private String name;

    /**
     * 课程图片
     */

    private String bigPhoto;

    /**
     * 老师名称
     */

    private String teacherName;

    /**
     * 学校名称
     */

    private String schoolName;

    /**
     * 课程的id号
     */
    private String courseId;


}
