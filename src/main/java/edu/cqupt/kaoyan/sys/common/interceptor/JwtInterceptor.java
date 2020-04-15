package edu.cqupt.kaoyan.sys.common.interceptor;


import edu.cqupt.kaoyan.sys.common.annotation.LandingCheck;
import edu.cqupt.kaoyan.sys.common.exception.CommonException;
import edu.cqupt.kaoyan.sys.common.system.result.ResultCode;
import edu.cqupt.kaoyan.sys.common.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @author Aaron
 * @description 通过拦截器获取token数据
 * @date 2020/4/8 3:58 PM
 */
@Component
@Slf4j
public class JwtInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    JwtUtils jwtUtils;

//    @Value("#{'${authorization.path}'.split(',')}")
//    public List<String> path;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //1.判断是否存在注解
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        //判断是否需要校验
        //获取接口上requestmapping注解
        HandlerMethod handerMethod = (HandlerMethod) handler;
        LandingCheck classCheck = handerMethod.getBeanType().getAnnotation(LandingCheck.class);
        Method method = handerMethod.getMethod();
        LandingCheck methodCheck = method.getAnnotation(LandingCheck.class);

        boolean require = false;
        //对发送邮箱单独处理
        if (request.getServletPath().endsWith("sendMessage")) {
            //对发送验证码->修改密码进行验证,hop为register值,若为hop跳过检验
            if (!request.getHeader("Authorization").equals("hop")) {
                require = true;
            }
        }

        if (classCheck != null) {
            require = classCheck.required();
        } else if (methodCheck != null) {
            require = methodCheck.required();
        }
        log.info("" + require);

        if (require) {
            //1。通过request获取token信息
            String authorization = request.getHeader("Authorization");
            //2.判断请求头信息是否为空，或者是否以Bearer开头
            if (!StringUtils.isEmpty(authorization) && authorization.startsWith("Bearer")) {
                //获取token数据
                String token = authorization.replace("Bearer ", "");
                //解析token获取clamis
                Claims claims = jwtUtils.parseJwt(token);
                if (claims != null) {
                    //通过clamis获取用户权限
                    //判断用户是否用于相应请求
                    request.setAttribute("students_clamis", claims);
                    log.info(claims.getId());
                    return true;
                }
            }
            throw new CommonException(ResultCode.UNAUTHORISE);
        }
        return true;

    }


}
