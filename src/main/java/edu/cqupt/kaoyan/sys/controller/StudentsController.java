package edu.cqupt.kaoyan.sys.controller;


import edu.cqupt.kaoyan.sys.common.controller.BaseController;
import edu.cqupt.kaoyan.sys.common.system.Result;
import edu.cqupt.kaoyan.sys.common.system.ResultCode;
import edu.cqupt.kaoyan.sys.common.utils.JwtUtils;
import edu.cqupt.kaoyan.sys.entity.Students;
import edu.cqupt.kaoyan.sys.service.IStudentsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;


/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Aaron
 * @since 2020-04-07
 */
@RestController
@RequestMapping("/sys/students")
@Slf4j
public class StudentsController extends BaseController {
    @Autowired
    JwtUtils jwtUtils;
    @Autowired
    IStudentsService iStudentsService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result login(@RequestBody Map<String, String> loginMap) {
        String stuEmail = loginMap.get("stuEmail");
        String password = loginMap.get("password");
        Students students = iStudentsService.getByStuEmail(stuEmail);
        if (students == null || !students.getStuPwd().equals(password)) {
            return new Result(ResultCode.EMAILORPASSWORDERROR);
        } else {


            Map<String, Object> map = new HashMap<>();
            map.put("stuEmail", students.getStuEmail());
            String token = jwtUtils.createJwt(students.getStuId().toString(), students.getStuName(), map);
            return new Result(ResultCode.SUCCESS, token);
        }
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public Result Profile(HttpServletRequest request) throws Exception {
        String userid = claims.getId();
        Students one = iStudentsService.getById(userid);
        return new Result(ResultCode.SUCCESS, one);
    }


}
