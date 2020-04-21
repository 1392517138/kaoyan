package edu.cqupt.kaoyan.sys.controller;


import edu.cqupt.kaoyan.sys.common.annotation.LandingCheck;
import edu.cqupt.kaoyan.sys.common.system.result.Result;
import edu.cqupt.kaoyan.sys.common.system.result.ResultCode;
import edu.cqupt.kaoyan.sys.service.IMoocService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Aaron
 * @since 2020-04-17
 */
@RestController
@RequestMapping("/sys/mooc")
@Api(tags = "慕课相关接口")
@LandingCheck
public class MoocController {
    @Autowired
    private IMoocService iMoocService;

    @ApiOperation("查看课程列表")
    @RequestMapping(value = "/getMoocs", method = RequestMethod.GET, headers = "Authorization")
    public Result getMoocs(@ApiParam("页码") @RequestParam Integer page) {
        return new Result(ResultCode.SUCCESS, iMoocService.getMoocs(page));
    }

    @ApiOperation("按照课程名称搜索课程")
    @RequestMapping(value = "/searchMooc", method = RequestMethod.GET, headers = "Authorization")
    public Result searchMooc(@RequestParam String name) {
        return new Result(ResultCode.SUCCESS, iMoocService.searchMooc(name));
    }

    @ApiOperation("得到mooc该course下的资源,type=(mp4,pdf)")
    @RequestMapping(value = "/getMoocResources", method = RequestMethod.GET, headers = "Authorization")
    public Result getMoocResources(@RequestParam String type, @RequestParam String courseId) {
        return new Result(ResultCode.SUCCESS, iMoocService.getMoocResources(type, courseId));
    }


}
