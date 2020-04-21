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
 * @since 2020-04-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Concern implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long stuId;

    private String courseId;

    /**
     * 是否删除,0不删除，1删除
     */
    private Integer flag;

    public Concern(Long stuId, String courseId) {
        this.stuId = stuId;
        this.courseId = courseId;
    }
}
