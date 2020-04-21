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
 * @since 2020-04-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class MoocPdf implements Serializable {

    private static final long serialVersionUID = 1L;

    private String courseId;
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

    private String resourceType;

    private String resourceName;

    private String pdfUrl;


}
