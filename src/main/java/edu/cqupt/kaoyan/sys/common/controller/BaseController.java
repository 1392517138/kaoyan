package edu.cqupt.kaoyan.sys.common.controller;

import io.jsonwebtoken.Claims;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Aaron
 * @description
 * @date 2020/4/8 12:34 PM
 */
public class BaseController {
    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected Long stuId;
    protected Claims claims;

    @ModelAttribute
    public void setResAnReq(HttpServletRequest request, HttpServletResponse respons) {
        this.request = request;
        this.response = respons;
        Object obj = request.getAttribute("students_clamis");
        if (obj != null) {
            this.claims = (Claims) obj;
            this.stuId = Long.parseLong(claims.getId());
        }

    }
}
