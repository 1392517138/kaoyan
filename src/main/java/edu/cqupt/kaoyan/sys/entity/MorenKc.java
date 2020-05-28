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
 * @since 2020-05-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class MorenKc implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 课程编号
     */
    private String kcbh;

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

    /**
     * 学分
     */
    private String xf;

    private String jysmc;

    /**
     * 图片地址
     */
    private String tpurl;

    /**
     * 是否上线
     */
    @TableField("DQZT")
    private String dqzt;

    /**
     * 专业
     */
    private String major;


}
