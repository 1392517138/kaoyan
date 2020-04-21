package edu.cqupt.kaoyan.sys.config;

import edu.cqupt.kaoyan.sys.common.interceptor.JwtInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Aaron
 * @description
 * @date 2020/4/10 2:13 PM
 */
@Configuration
public class WebConfiguration implements WebMvcConfigurer {
    @Autowired
    JwtInterceptor jwtInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtInterceptor).addPathPatterns("/**")
                .excludePathPatterns(
                        "/sys/students/login",
                        "/sys/students/register",
                        "/sys/students/getByStuEmail2",
                        "/sys/admin/login",
                        //swagger
                        "/swagger-resources/**",
                        "/webjars/**",
                        "/v2/**",
                        "/swagger-ui.html/**");
    }

}
