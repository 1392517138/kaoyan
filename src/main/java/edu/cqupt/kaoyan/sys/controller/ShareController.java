package edu.cqupt.kaoyan.sys.controller;


import edu.cqupt.kaoyan.sys.common.annotation.LandingCheck;
import edu.cqupt.kaoyan.sys.common.controller.BaseController;
import edu.cqupt.kaoyan.sys.common.system.result.Result;
import edu.cqupt.kaoyan.sys.common.system.result.ResultCode;
import edu.cqupt.kaoyan.sys.service.ICheckShareService;
import edu.cqupt.kaoyan.sys.service.IShareService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Aaron
 * @since 2020-04-19
 */
@RestController
@RequestMapping("/sys/check-share")
@Api(tags = "share资源分享")
@LandingCheck
public class ShareController extends BaseController {

    @Autowired
    IShareService iShareService;

    @ApiOperation("上传分享资源")
    @LandingCheck
    @RequestMapping(value = "/uploadShare", method = RequestMethod.POST, headers = "Authorization")
    public Result uploadShare(MultipartFile file, @RequestParam String courseId) {
        iShareService.uploadShare(file, courseId, stuId);
        return new Result(ResultCode.SUCCESS);
    }
}
