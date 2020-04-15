package edu.cqupt.kaoyan.sys.entity.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Aaron
 * @description
 * @date 2020/4/11 10:10 AM
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDTO {
    private String stuEmail;
    private String stuPwd;
    private String shortMessage;
}
