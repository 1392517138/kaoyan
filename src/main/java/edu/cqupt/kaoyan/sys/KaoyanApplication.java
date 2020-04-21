package edu.cqupt.kaoyan.sys;


import edu.cqupt.kaoyan.sys.common.utils.JwtUtils;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author piwenjing
 * @description
 * @date 2020/3/26 6:49 PM
 */
@SpringBootApplication
@EnableCaching
@EnableTransactionManagement(proxyTargetClass = true)
@MapperScan("edu.cqupt.kaoyan.sys.mapper")
public class KaoyanApplication {
    public static void main(String[] args) {
        SpringApplication.run(KaoyanApplication.class, args);
    }

    @Bean
    public JwtUtils jwtUtils() {
        return new JwtUtils();
    }
}
