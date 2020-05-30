package edu.cqupt.kaoyan.sys.entity.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * @author Aaron
 * @description
 * @date 2020/5/29 11:36 AM
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MrkcResourceDTO {
    private String kcbh;
    private String resourceType;
    private List<PDF> pdfs;
}
