package edu.cqupt.kaoyan.sys.controller;


import edu.cqupt.kaoyan.sys.common.annotation.LandingCheck;
import edu.cqupt.kaoyan.sys.common.controller.BaseController;
import edu.cqupt.kaoyan.sys.common.system.result.Result;
import edu.cqupt.kaoyan.sys.common.system.result.ResultCode;
import edu.cqupt.kaoyan.sys.service.IConcernService;
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
 * @since 2020-04-19
 */
@RestController
@RequestMapping("/sys/concern")
@Api(tags = "收藏课程【Mooc】相关接口")
@LandingCheck
public class ConcernController extends BaseController {
    @Autowired
    IConcernService iConcernService;

    @ApiOperation("添加/取消 收藏的课程,点击即取消/收藏")
    @RequestMapping(value = "/addeCourse", method = RequestMethod.POST, headers = "Authorization")
    public Result addeCourse(@RequestParam String courseId) {
        return iConcernService.addeCourse(courseId, stuId);
    }

    @ApiOperation("查看自己添加的")
    @RequestMapping(value = "/viewAddCourse", method = RequestMethod.GET, headers = "Authorization")
    public Result viewAddCourse() {
        return new Result(ResultCode.SUCCESS, iConcernService.viewAddCourse(stuId));
    }
}
