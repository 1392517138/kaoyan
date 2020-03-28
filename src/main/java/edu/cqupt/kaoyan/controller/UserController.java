package edu.cqupt.kaoyan.controller;

import edu.cqupt.kaoyan.entity.User;
import edu.cqupt.kaoyan.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;


/**
 * (User)表控制层
 *
 * @author makejava
 * @since 2020-03-26 18:48:59
 */
@RestController
@Api(tags = "用户基本操作接口，注册[获取验证码/提交信息]，登陆，修改")
@RequestMapping("/user")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;


    /**
     * 登陆
     *
     * @return
     */

    @GetMapping("/login")
    @ApiOperation("用户登陆")
    public String login(@ApiParam("学号") @RequestParam("useridcard") String useridcard, @ApiParam("用户密码") @RequestParam("password") String password, HttpSession session) {
        return userService.login(useridcard, password, session);
    }

    /**
     * 注册
     *
     * @return
     */
    @GetMapping("/register/sendCode")
    @ApiOperation("发送验证码")
    public String sendCode(@ApiParam("邮箱") @RequestParam("email") String email) {
        return userService.sendCode(email);
    }

    @GetMapping("/register")
    @ApiOperation("注册提交信息")
    public String register(@ApiParam("学号") @RequestParam("useridcard") String useridcard, @ApiParam("密码") @RequestParam("password") String password, @ApiParam("邮箱") @RequestParam("email") String email, @ApiParam("发送的验证码") @RequestParam("checkCode") String checkCode) {
        return userService.register(useridcard, password, email, checkCode);
    }

    /**
     * 修改姓名、邮箱、密码、角色、(专业、学院)
     */
    @GetMapping("/modName")
    @ApiOperation("修改姓名")
    public String modName(@ApiParam @RequestParam("JSSESSIONID") String JSESSIONID, @ApiParam("用户昵称") @RequestParam("username") String username) {
        return userService.modName(JSESSIONID, username);
    }

    @GetMapping("/modPwd")
    @ApiOperation("修改密码")
    public String modPwd(@ApiParam @RequestParam("JSSESSIONID") String JSESSIONID, @ApiParam("密码") @RequestParam("password") String password) {
        return userService.modPwd(JSESSIONID, password);
    }

    @GetMapping("/modRole")
    @ApiOperation("修改角色")
    public String modRole(@ApiParam @RequestParam("JSSESSIONID") String JSESSIONID, @ApiParam("角色Id") @RequestParam("roleid") Integer roleid) {
        return userService.modRole(JSESSIONID, roleid);
    }

    @GetMapping("/modFrom")
    @ApiOperation("修改专业，学院")
    public String modFrom(@ApiParam @RequestParam("JSSESSIONID") String JSESSIONID, @ApiParam("专业id") @RequestParam("majorid") Integer majorid, @ApiParam("学院Id") @RequestParam("collegeId") Integer collegeid) {
        return userService.modFrom(JSESSIONID, majorid, collegeid);
    }

}