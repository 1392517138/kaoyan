package edu.cqupt.kaoyan.sys.entity;

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
 * @since 2020-05-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Zy implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 专业号码
     */
    private String zyh;

    /**
     * 专业名称
     */
    private String zymc;

    /**
     * 学院id
     */
    private Integer xyh;


}
