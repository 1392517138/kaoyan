package edu.cqupt.kaoyan.sys.entity;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * VIEW
 * </p>
 *
 * @author Aaron
 * @since 2020-05-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class XyZy implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 学院号码
     */
    private String xyh;

    /**
     * 学院名称
     */
    private String xymc;

    /**
     * 专业号码
     */
    private String zyh;

    /**
     * 专业名称
     */
    private String zymc;


}
