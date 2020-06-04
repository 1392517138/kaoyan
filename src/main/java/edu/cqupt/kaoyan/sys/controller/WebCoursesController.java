package edu.cqupt.kaoyan.sys.controller;


import edu.cqupt.kaoyan.sys.common.annotation.LandingCheck;
import edu.cqupt.kaoyan.sys.common.system.result.Result;
import edu.cqupt.kaoyan.sys.common.system.result.ResultCode;
import edu.cqupt.kaoyan.sys.service.IWebCoursesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
 * @since 2020-06-04
 */
@RestController
@RequestMapping("/sys/web-courses")
@Api(tags = "其他平台API接口")
@LandingCheck
public class WebCoursesController {
    @Autowired
    IWebCoursesService iWebCoursesService;

    @ApiOperation("获得有哪些平台,resource字段意思是平台")
    @RequestMapping(value = "/getResource", method = RequestMethod.GET, headers = "Authorization")
    public Result getResource() {
        return new Result(ResultCode.SUCCESS, iWebCoursesService.getResource());
    }

    @ApiOperation("获取该平台下有哪些课程类别，如心理学等等")
    @RequestMapping(value = "/getCategory", method = RequestMethod.GET, headers = "Authorization")
    public Result getCategory(@RequestParam String resource) {
        return new Result(ResultCode.SUCCESS, iWebCoursesService.getCategory(resource));
    }

    @ApiOperation("获取该平台下有哪些课程类别，如心理学等等")
    @RequestMapping(value = "/getWebCourses", method = RequestMethod.GET, headers = "Authorization")
    public Result getWebCourses(@RequestParam String resource, @RequestParam String category, @RequestParam Integer page) {
        return new Result(ResultCode.SUCCESS, iWebCoursesService.getWebCourses(resource, category, page));
    }
}
