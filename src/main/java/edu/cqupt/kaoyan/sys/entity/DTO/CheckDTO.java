package edu.cqupt.kaoyan.sys.entity.DTO;

import lombok.Data;

/**
 * @author Aaron
 * @description
 * @date 2020/4/20 12:12 PM
 */
@Data
public class CheckDTO {
    private Long checkId;

    private Long shareId;

    private Integer resourceId;

    private Integer checked;
}
