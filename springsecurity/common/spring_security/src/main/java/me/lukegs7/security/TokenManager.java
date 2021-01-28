package me.lukegs7.security;

import io.jsonwebtoken.CompressionCodecs;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TokenManager {
    // token有效时长
    private long tokenExpiration = 24 * 60 * 60 * 1000;
    // 编码密钥
    private String tokenSignKey = "123456";

    //1. 根据用户名生成token
    public String createToken(String username) {
        String token = Jwts.builder().setSubject(username).setExpiration(new Date(System.currentTimeMillis() + tokenExpiration)).
                signWith(SignatureAlgorithm.HS512, tokenSignKey).compressWith(CompressionCodecs.GZIP).compact();
        return token;
    }

    //2.根据token字符串得到用户信息
    public String getUsernameInfoFromToken(String token) {
        return Jwts.parser().setSigningKey(tokenSignKey).parseClaimsJws(token).getBody().getSubject();
    }
    //3. 删除token
    public void removeToken(String token) {

    }
}
