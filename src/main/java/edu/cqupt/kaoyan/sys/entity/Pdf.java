package edu.cqupt.kaoyan.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

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
 * @since 2020-04-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Pdf implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "pdf_id", type = IdType.AUTO)
    private Integer pdfId;

    private Integer resourceId;

    private String pdfUrl;


}
