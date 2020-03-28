package edu.cqupt.kaoyan.controller;

import edu.cqupt.kaoyan.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author piwenjing
 * @description
 * @date 2020/3/27 4:56 PM
 */
@Controller
@Api(tags = "不是接口，用于Models说明")
public class ModelSet {
    @PostMapping("/user")
    public void User(@RequestBody()User user){

    }
}
