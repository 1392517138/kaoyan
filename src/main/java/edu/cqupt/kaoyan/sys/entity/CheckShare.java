package edu.cqupt.kaoyan.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.*;
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
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CheckShare implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "check_id")
    private Long checkId;

    private Long shareId;

    private Integer resourceId;

    /**
     * 0为未通过，1为通过
     */
    private Integer checked;

    public CheckShare(Long shareId) {
        this.shareId = shareId;
    }
}
