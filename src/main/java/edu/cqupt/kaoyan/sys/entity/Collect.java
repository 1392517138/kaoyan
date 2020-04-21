package edu.cqupt.kaoyan.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
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
 * @since 2020-04-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Collect implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "stu_id")
    private Long stuId;

    private Integer resourceId;

    /**
     * 是否删除,0未删除，1删除
     */
    private Integer flag;

    public Collect(Long stuId, Integer resourceId) {
        this.stuId = stuId;
        this.resourceId = resourceId;
    }
}
