package edu.cqupt.kaoyan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * @author piwenjing
 * @description
 * @date 2020/3/26 6:49 PM
 */
@SpringBootApplication
@MapperScan("edu.cqupt.kaoyan.mapper")
public class KaoyanApplication {
    public static void main(String[] args) {
        SpringApplication.run(KaoyanApplication.class, args);
    }
}
