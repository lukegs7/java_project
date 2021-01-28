package me.lukegs7.security;

import me.lukegs7.utils.R;
import me.lukegs7.utils.ResponseUtil;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TokenLogoutHandler implements LogoutHandler {
    //需要token解密
    private TokenManager tokenManager;
    // 需要从redis中删除token
    private RedisTemplate redisTemplate;

    public TokenLogoutHandler(TokenManager tokenManager, RedisTemplate redisTemplate) {
        this.tokenManager = tokenManager;
        this.redisTemplate = redisTemplate;
    }

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        // 1.从header中获取token
        String token = request.getHeader("token");
        // 2.值不为空，则移除token，从redis删除token
        if (token != null) {
            // 移除token
            tokenManager.removeToken(token);
            String usernameInfoFromToken = tokenManager.getUsernameInfoFromToken(token);
            redisTemplate.delete(usernameInfoFromToken);
        }
        ResponseUtil.out(response, R.ok());
    }
}
