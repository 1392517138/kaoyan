package edu.cqupt.kaoyan.sys;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * @author Aaron
 * @description
 * @date 2020/4/7 4:21 PM
 */

public class CreateJwtTest {
    public static void main(String[] args) {
        JwtBuilder jwtBuilder = Jwts.builder().setId("88").setSubject("小白")
                .setIssuedAt(new Date())
                .claim("companyId", "123456")
                .claim("companyName", "船只博客")
                .signWith(SignatureAlgorithm.HS256, "piwenjing");
        String token = jwtBuilder.compact();
        System.out.println(token);
    }
}
