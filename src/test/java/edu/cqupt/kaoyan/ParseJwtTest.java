package edu.cqupt.kaoyan;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

/**
 * @author Aaron
 * @description
 * @date 2020/4/7 4:45 PM
 */
public class ParseJwtTest {
    public static void main(String[] args) {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI4OCIsInN1YiI6IuWwj-eZvSIsImlhdCI6MTU4NjI0OTA3Nn0.5UuamxxMhmrXRp1B_4WNjTRbtcOML9JrCyd_TbOGQHA";
        Claims claims = Jwts.parser().setSigningKey("aa").parseClaimsJws(token).getBody();
        claims.getId();
        System.out.println(claims.getSubject());
        System.out.println(claims.getIssuedAt());
        claims.get("companyId");
    }
}
