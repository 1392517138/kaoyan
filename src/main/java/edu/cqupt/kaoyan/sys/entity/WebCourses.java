package edu.cqupt.kaoyan.sys.entity;

import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author Aaron
 * @since 2020-06-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class WebCourses implements Serializable {

    private static final long serialVersionUID = 1L;

    private String category;

    private String name;

    private String site;

    @TableField("imgUrl")
    private String imgUrl;

    private String resource;


}
