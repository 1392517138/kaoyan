package edu.cqupt.kaoyan.sys.entity.DTO;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Aaron
 * @description
 * @date 2020/4/10 3:12 PM
 */
@Getter
@Setter
@ApiModel("登陆实体")
public class LoginDTO {
    private String stuEmail;
    private String stuPwd;

}
