package edu.cqupt.kaoyan.sys.common.system.response;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class StudentsResult implements Serializable {

    private Integer stuId;

    private String stuEmail;

    private String stuPwd;

    private String stuName;

    private Integer stuSex;

    private String stuHead;

    private Integer stuGrade;

    private Integer stuMajor;

    private Integer version;

}
