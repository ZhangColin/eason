package com.eason.portal.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author colin
 */
public class JwtUtil {
    static final String SECRET = "youfanwuliuxitonghexiaoxixitong";

    public static String generateToken(String username,String password) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        //you can put any data in the map
        map.put("username", username);
        map.put("password", password);
        String jwt = Jwts.builder()
                .setClaims(map)
                .setExpiration(new Date(System.currentTimeMillis() + 3600*1000*1000l))// 1000 hour
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
        return "Bearer "+jwt; //jwt前面一般都会加Bearer
    }

    public static void validateToken(String token) throws Exception{
        // parse the token.
        Map<String, Object> body = Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token.replace("Bearer ",""))
                .getBody();
    }
}
