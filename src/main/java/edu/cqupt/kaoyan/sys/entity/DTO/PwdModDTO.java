package edu.cqupt.kaoyan.sys.entity.DTO;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Aaron
 * @description
 * @date 2020/4/15 3:56 PM
 */
@Getter
@Setter
@ApiModel("修改密码实体")
public class PwdModDTO {
    private String stuPwd;
    private String shortMessage;
}
