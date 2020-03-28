package edu.cqupt.kaoyan.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.ibatis.annotations.Select;

import java.util.Date;

/**
 * (User)实体类
 *
 * @author makejava
 * @since 2020-03-26 18:48:54
 */
@ApiModel("用户实体")
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "user")
public class User {

    @TableId(type = IdType.AUTO)
    @ApiModelProperty("用户id")
    private Integer userid;

    @ApiModelProperty("学号")
    private String useridcard;
    @ApiModelProperty("用户昵称")
    private String username;
    @ApiModelProperty("用户邮箱")
    private String eamil;

    @TableField(select = false)
    @ApiModelProperty("用户密码")
    private String password;

    /**
     * 默认角色：学生-3
     * 默认专业：您还未选择专业-999
     * 默认学校：您还未选择学校-999
     */
    @ApiModelProperty("用户角色id")
    private Integer roleid;
    @ApiModelProperty("用户专业id")
    private Integer majorid;
    @ApiModelProperty("用户学院id")
    private Integer collegeid;


}