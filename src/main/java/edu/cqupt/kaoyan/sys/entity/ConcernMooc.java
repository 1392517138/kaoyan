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
 * @since 2020-04-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ConcernMooc implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long stuId;

    private String courseId;

    /**
     * 是否删除,0不删除，1删除
     */
    private Integer flag;

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


}
