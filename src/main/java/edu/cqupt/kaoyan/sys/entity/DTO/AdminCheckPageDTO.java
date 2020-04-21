package edu.cqupt.kaoyan.sys.entity.DTO;

import edu.cqupt.kaoyan.sys.entity.AdminCheck;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Aaron
 * @description
 * @date 2020/4/21 5:07 PM
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminCheckPageDTO {
    private List<AdminCheck> adminCheckList;
    private Long pagesNum;
    private Long size;
    private Long total;
}
