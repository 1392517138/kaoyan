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
 * @since 2020-05-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Xy implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 学院号码
     */
    private String xyh;

    /**
     * 学院名称
     */
    private String xymc;


}
