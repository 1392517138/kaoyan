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
 * @since 2020-04-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Share implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "share_id")
    private Long shareId;

    /**
     * 文件类型
     */
    private String shareType;

    /**
     * 分享地址
     */
    private String shareStream;

    /**
     * 课程id
     */
    private String courseId;

    /**
     * 学生id
     */
    private Long stuId;

    /**
     * 文件名称
     */
    private String shareName;

    public Share(String shareType, String shareStream, String courseId, Long stuId, String shareName) {
        this.shareType = shareType;
        this.shareStream = shareStream;
        this.courseId = courseId;
        this.stuId = stuId;
        this.shareName = shareName;
    }
}
