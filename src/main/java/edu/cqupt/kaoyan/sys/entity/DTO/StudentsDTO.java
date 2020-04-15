package edu.cqupt.kaoyan.sys.entity.DTO;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Aaron
 * @description
 * @date 2020/4/10 10:57 PM
 */
@Getter
@Setter
@ApiModel("用户传输实体")
public class StudentsDTO {


    private String stuName;

    private Integer stuSex;

    private String stuHead;

    private Integer stuGrade;

    private Integer stuMajor;

    private Integer version;
}
