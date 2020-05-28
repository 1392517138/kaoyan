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
public class MrkcResource implements Serializable {

    private static final long serialVersionUID = 1L;

    private String kcbh;

    private String resourceType;

    private String resourceName;

    private String pdfUrl;


}
