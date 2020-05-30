package edu.cqupt.kaoyan.sys.entity.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Aaron
 * @description
 * @date 2020/5/29 8:49 PM
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PDF {
    private String resourceName;
    private String pdfUrl;
}
