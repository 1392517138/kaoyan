package edu.cqupt.kaoyan.sys.controller;


import edu.cqupt.kaoyan.sys.common.annotation.LandingCheck;
import edu.cqupt.kaoyan.sys.common.controller.BaseController;
import edu.cqupt.kaoyan.sys.common.system.result.Result;
import edu.cqupt.kaoyan.sys.common.system.result.ResultCode;
import edu.cqupt.kaoyan.sys.service.ICollectService;
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
 * @since 2020-04-16
 */
@RestController
@RequestMapping("/sys/collect")
@Api(tags = "收藏资源类接口")
@LandingCheck
public class CollectController extends BaseController {
    @Autowired
    ICollectService iCollectService;

    @ApiOperation("添加/取消 收藏的资源,点击即取消/收藏")
    @RequestMapping(value = "/addeResource", method = RequestMethod.POST, headers = "Authorization")
    public Result addeResource(@RequestParam Integer resourceId) {
        return iCollectService.addeCollect(resourceId, stuId);
    }

    @ApiOperation("查看自己添加的")
    @RequestMapping(value = "/viewAddResource", method = RequestMethod.GET, headers = "Authorization")
    public Result viewAddResource() {
        return new Result(ResultCode.SUCCESS, iCollectService.viewAddCollect(stuId));
    }
}
