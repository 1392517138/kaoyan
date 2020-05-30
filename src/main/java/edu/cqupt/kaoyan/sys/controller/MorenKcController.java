package edu.cqupt.kaoyan.sys.controller;


import edu.cqupt.kaoyan.sys.common.annotation.LandingCheck;
import edu.cqupt.kaoyan.sys.common.system.result.Result;
import edu.cqupt.kaoyan.sys.common.system.result.ResultCode;
import edu.cqupt.kaoyan.sys.service.*;
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
 * @since 2020-05-28
 */
@Api(tags = "学校课程API")
@RestController
@RequestMapping("/sys/moren-kc")
@LandingCheck
public class MorenKcController {
    @Autowired
    IMorenKcService iMorenKcService;
    @Autowired
    IXyService iXyService;
    @Autowired
    IZyService iZyService;
    @Autowired
    ITeacherService iTeacherService;
    @Autowired
    IKcTeacherService iKcTeacherService;
    @Autowired
    IXyZyService iXyZyService;

    @ApiOperation("获得学院名称列表")
    @RequestMapping(value = "/getXy", method = RequestMethod.GET, headers = "Authorization")
    public Result getXy() {
        return iXyService.getXy();
    }

    @ApiOperation("获得专业列表")
    @RequestMapping(value = "/getZy", method = RequestMethod.GET, headers = "Authorization")
    public Result getZy() {
        return iZyService.getZy();
    }

    @ApiOperation("获得学院、专业列表集合")
    @RequestMapping(value = "/getXyZy", method = RequestMethod.GET, headers = "Authorization")
    public Result getXyZy() {
        return iXyZyService.getXyZy();
    }

    @ApiOperation("获取学院名称,有一些乱七糟八的学院，财务处等等、跟上面做区分")
    @RequestMapping(value = "/getUnknowXy", method = RequestMethod.GET, headers = "Authorization")
    public Result getUnknowXy() {
        return iMorenKcService.getUnknowXy();
    }

    @ApiOperation("根据学院名称,获取老师")
    @RequestMapping(value = "/getTeacherByXymc", method = RequestMethod.GET, headers = "Authorization")
    public Result getTeacherByXymc(@RequestParam String xm) {
        return iTeacherService.getTeacherByXymc(xm);
    }

    @ApiOperation("根据老师id,查看其教的课程")
    @RequestMapping(value = "/getKcByTeacherid", method = RequestMethod.GET, headers = "Authorization")
    public Result getKcByTeacherid(@RequestParam String teacherId) {
        return iKcTeacherService.getKcByTeacherid(Long.parseLong(teacherId));
    }

    @ApiOperation("根据课程id获取教学资源。教学大纲、考试大纲、知识点体系、导学方案,分别为type=(jxdg,ksdg,zsdtx,dxfa)")
    @RequestMapping(value = "/getResourceByKcbh", method = RequestMethod.GET, headers = "Authorization")
    public Result getResourceByKcbh(@RequestParam String kcbh, @RequestParam String type) {
        return iMorenKcService.getResource(kcbh, type);
    }


    @ApiOperation("根据课程id查看课程信息")
    @RequestMapping(value = "/getKcByKcbh", method = RequestMethod.GET, headers = "Authorization")
    public Result getKcByKcbh(@RequestParam String kcbh) {
        return iMorenKcService.getKcByKcbh(kcbh);
    }

    @ApiOperation("根据开课学院名称获得默认课程")
    @RequestMapping(value = "/getKcByXymc", method = RequestMethod.GET, headers = "Authorization")
    public Result getKcByXymc(@RequestParam String xymc) {
        return new Result(ResultCode.SUCCESS, iMorenKcService.getKcByXymc(xymc));
    }

    @ApiOperation("根据课程名字搜索课程")
    @RequestMapping(value = "/searchByKcmc", method = RequestMethod.GET, headers = "Authorization")
    public Result searchByKcmc(@RequestParam String kcmc) {
        return new Result(ResultCode.SUCCESS, iMorenKcService.searchByKcmc(kcmc));
    }

    @ApiOperation("根据专业号查看合适的课程")
    @RequestMapping(value = "/searchByZyh", method = RequestMethod.GET, headers = "Authorization")
    public Result searchByZyh(@RequestParam String zyh) {
        return iMorenKcService.searchByZyh(zyh);
    }

    @ApiOperation("搜索老师，模糊搜索名称")
    @RequestMapping(value = "/searchByXm", method = RequestMethod.GET, headers = "Authorization")
    public Result searchByXm(@RequestParam String xm) {
        return iKcTeacherService.searchByXm(xm);
    }


}
