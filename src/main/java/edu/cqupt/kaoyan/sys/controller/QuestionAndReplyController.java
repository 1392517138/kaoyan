package edu.cqupt.kaoyan.sys.controller;


import edu.cqupt.kaoyan.sys.common.annotation.LandingCheck;
import edu.cqupt.kaoyan.sys.common.controller.BaseController;
import edu.cqupt.kaoyan.sys.common.system.result.Result;
import edu.cqupt.kaoyan.sys.common.system.result.ResultCode;
import edu.cqupt.kaoyan.sys.entity.DTO.AQuestionDTO;
import edu.cqupt.kaoyan.sys.entity.DTO.AReplyDTO;
import edu.cqupt.kaoyan.sys.service.IQuestionService;
import edu.cqupt.kaoyan.sys.service.IReplyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Aaron
 * @since 2020-04-15
 */
@RestController
@RequestMapping("/sys/question")
@Api(tags = "问题和回复接口")
@LandingCheck
public class QuestionAndReplyController extends BaseController {
    @Autowired
    IQuestionService iQuestionService;
    @Autowired
    IReplyService iReplyService;

    @ApiOperation("发表问题,用postman测试，content-type=multipart/form-data; boundary=<calculated when request is sent>,body=form-data,qQuestionDTO的content-type为application/json")
    @RequestMapping(value = "/publishQuestion", method = RequestMethod.POST, headers = "Authorization")
    public Result publishQuestion(@RequestPart MultipartFile[] files, @RequestPart AQuestionDTO aQuestionDTO) {
        iQuestionService.publishQuestion(files, aQuestionDTO, stuId);
        return new Result(ResultCode.SUCCESS);
    }

    @ApiOperation("查看自己发表的问题")
    @RequestMapping(value = "/viewYourQuestions", method = RequestMethod.GET, headers = "Authorization")
    public Result publishQuestion() {
        return new Result(ResultCode.SUCCESS, iQuestionService.viewYourQuestions(stuId));
    }

    @ApiOperation("发表回复")
    @RequestMapping(value = "/publishReply", method = RequestMethod.POST, headers = "Authorization")
    public Result publishReply(@RequestPart MultipartFile[] files, @RequestPart AReplyDTO aReplyDTO) {
        iReplyService.publishReply(files, aReplyDTO, stuId);
        return new Result(ResultCode.SUCCESS);
    }

    @ApiOperation("根据问题id查看回复")
    @ApiImplicitParam(name = "quesID", value = "问题id", required = true, dataType = "Long", paramType = "path")
    @RequestMapping(value = "/viewReply", method = RequestMethod.GET, headers = "Authorization")
    public Result viewReply(@RequestParam Long quesId) {
        return new Result(ResultCode.SUCCESS, iReplyService.viewReply(quesId));
    }

    @ApiOperation("查看问题")
    @RequestMapping(value = "/viewQuestions", method = RequestMethod.GET, headers = "Authorization")
    public Result viewQuestions(@RequestParam String quesId) {
        return new Result(ResultCode.SUCCESS, iQuestionService.viewQuestions(Long.parseLong(quesId)));
    }

}
