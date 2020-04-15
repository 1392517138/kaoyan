package edu.cqupt.kaoyan.sys.controller;


import edu.cqupt.kaoyan.sys.common.annotation.LandingCheck;
import edu.cqupt.kaoyan.sys.common.controller.BaseController;
import edu.cqupt.kaoyan.sys.common.exception.CommonException;
import edu.cqupt.kaoyan.sys.common.system.result.Result;
import edu.cqupt.kaoyan.sys.common.system.result.ResultCode;
import edu.cqupt.kaoyan.sys.common.utils.JwtUtils;
import edu.cqupt.kaoyan.sys.entity.DTO.LoginDTO;
import edu.cqupt.kaoyan.sys.entity.DTO.PwdModDTO;
import edu.cqupt.kaoyan.sys.entity.DTO.RegisterDTO;
import edu.cqupt.kaoyan.sys.entity.DTO.StudentsDTO;
import edu.cqupt.kaoyan.sys.service.IStudentsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Aaron
 * @since 2020-04-07
 */
@RestController
@Api(tags = "用户操作接口,若需要token则在headers中添加Authorization属性：[用Bearer加空格再加token进行请求]")
@RequestMapping("/sys/students")
@Slf4j
public class StudentsController extends BaseController {
    @Autowired
    JwtUtils jwtUtils;
    @Autowired
    IStudentsService iStudentsService;

    @ApiOperation("得到用户信息")
    @LandingCheck
    @RequestMapping(value = "/getStudents", method = RequestMethod.GET, headers = "Authorization")
    public Result getStudents() {
        log.info(stuId.toString());
        return new Result(ResultCode.SUCCESS, iStudentsService.getStudents(stuId));
    }

    @ApiOperation("登陆")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result login(@RequestBody LoginDTO loginDTO) {
        return iStudentsService.login(loginDTO);
    }

    @ApiOperation("获取验证码,type=(register,modPwd),若为modPwd填写请求头,register请求头值为hop")
    @RequestMapping(value = "/sendMessage", method = RequestMethod.GET, headers = "Authorization")
    public Result sendMessage(@RequestParam String stuEmail, @RequestParam String type) throws CommonException {
        iStudentsService.sendMessage(stuEmail, type);
        return new Result(ResultCode.SUCCESS);
    }


    @ApiOperation("注册")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Result register(@RequestBody RegisterDTO registerDTO) throws CommonException {
        iStudentsService.register(registerDTO);
        return new Result(ResultCode.SUCCESS);
    }

    @ApiOperation("修改用户信息")
    @LandingCheck
    @RequestMapping(value = "/updateStudents", method = RequestMethod.POST, headers = "Authorization")
    public Result updateStudents(@RequestBody StudentsDTO studentsDTO) {
        iStudentsService.updateStudents(studentsDTO, stuId);
        return new Result(ResultCode.SUCCESS);
    }

    @ApiOperation("修改用户头像")
    @LandingCheck
    @RequestMapping(value = "/modHead", method = RequestMethod.POST, headers = "Authorization")
    public Result modHead(MultipartFile multipartFile) {
        iStudentsService.modHead(multipartFile, stuId);
        return new Result(ResultCode.SUCCESS);
    }

    @ApiOperation("修改用户密码")
    @LandingCheck
    @RequestMapping(value = "/modPwd", method = RequestMethod.POST, headers = "Authorization")
    public Result modPwd(@RequestBody PwdModDTO pwdModDTO) throws CommonException {
        iStudentsService.modPwd(pwdModDTO, stuId);
        return new Result(ResultCode.SUCCESS);
    }
}



