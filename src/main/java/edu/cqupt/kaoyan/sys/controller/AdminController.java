package edu.cqupt.kaoyan.sys.controller;


import edu.cqupt.kaoyan.sys.common.annotation.LandingCheck;
import edu.cqupt.kaoyan.sys.common.system.result.Result;
import edu.cqupt.kaoyan.sys.common.system.result.ResultCode;
import edu.cqupt.kaoyan.sys.entity.DTO.AdminLoginDTO;
import edu.cqupt.kaoyan.sys.entity.DTO.CheckDTO;
import edu.cqupt.kaoyan.sys.service.IAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Aaron
 * @since 2020-04-19
 */
@RestController
@RequestMapping("/sys/admin")
@Api(tags = "管理员接口")
@LandingCheck
public class AdminController {
    @Autowired
    IAdminService iAdminService;

    @ApiOperation("登陆")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result login(@RequestBody AdminLoginDTO adminLoginDTO) {
        return iAdminService.login(adminLoginDTO);
    }

    @ApiOperation("查看分享的资源列表")
    @LandingCheck
    @RequestMapping(value = "/viewShare", method = RequestMethod.GET, headers = "Authorization")
    public Result viewShare(@ApiParam("页码") @RequestParam Integer page) {
        return new Result(ResultCode.SUCCESS, iAdminService.viewShare(page));
    }

    @ApiOperation("设置是否通过审核,checked=(0,1)分别代表不通过，通过")
    @LandingCheck
    @RequestMapping(value = "/setCross", method = RequestMethod.POST, headers = "Authorization")
    public Result viewShare(@RequestBody CheckDTO CheckDTO) {
        iAdminService.setCross(CheckDTO);
        return new Result(ResultCode.SUCCESS);
    }

}
