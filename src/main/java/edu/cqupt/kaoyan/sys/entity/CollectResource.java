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
public class CollectResource implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long stuId;

    private Integer resourceId;

    /**
     * 是否删除,0未删除，1删除
     */
    private Integer flag;

    private String resourceType;

    private String resourceName;

    private String url;


}
