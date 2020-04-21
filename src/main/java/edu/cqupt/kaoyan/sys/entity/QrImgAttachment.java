package edu.cqupt.kaoyan.sys.entity;

import com.baomidou.mybatisplus.annotation.TableField;
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
public class QrImgAttachment implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField(select = false)
    @TableId
    private Long qrImgId;

    private String imgUrl;

    @TableField(select = false)
    private Long parent;

    public QrImgAttachment(String imgUrl, Long parent) {
        this.imgUrl = imgUrl;
        this.parent = parent;
    }
}
