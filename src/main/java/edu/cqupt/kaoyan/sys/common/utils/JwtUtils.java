package edu.cqupt.kaoyan.sys.common.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Date;

/**
 * @author Aaron
 * @description
 * @date 2020/4/7 4:58 PM
 */
@Getter
@Setter
@ConfigurationProperties("jwt.config")
public class JwtUtils {
    //签名私钥
    private String key;
    //签名失效时间
    private Long ttl;

    /**
     * 设置认证token
     * id:登陆用户id
     * subject:登陆用户名
     */
    public String createJwt(Long id) {
        //1.设置失效时间
        long now = System.currentTimeMillis(); //当前毫秒
        long exp = now + ttl;
        //2.创建jwtBuilder
        JwtBuilder jwtBuilder = Jwts.builder().setId(id.toString())
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, key);

//        //3.根据map设置claims
//        map.forEach((k, v) -> {
//            jwtBuilder.claim(k, v);
//        });
        jwtBuilder.setExpiration(new Date(exp));
        //4.创建token
        String token = jwtBuilder.compact();
        return token;
    }

    /**
     * 解析token字符串获得clamis
     */
    public Claims parseJwt(String token) {
        Claims claims = Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
        return claims;
    }
}

