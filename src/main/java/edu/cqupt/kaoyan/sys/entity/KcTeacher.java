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
 * @since 2020-05-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class KcTeacher implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long teacherid;

    private String kcbh;

    private String jslx;

    /**
     * 姓名
     */
    private String xm;

    /**
     * 学院名称
     */
    private String xymc;

    /**
     * 课程名称
     */
    private String kcmc;

    private String kcpf;

    /**
     * 课程介绍
     */
    private String kcjs;

    /**
     * 开课学院名称
     */
    private String kkxymc;

    /**
     * 学时
     */
    private String xs;


}
