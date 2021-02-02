package me.lukegs7.filter;

import me.lukegs7.security.TokenManager;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 授权过滤器
 */
public class TokenAuthenticationFilter extends BasicAuthenticationFilter {
    private TokenManager tokenManager;
    private RedisTemplate redisTemplate;

    public TokenAuthenticationFilter(TokenManager tokenManager, RedisTemplate redisTemplate, AuthenticationManager authenticationManager) {
        super(authenticationManager);
        this.tokenManager = tokenManager;
        this.redisTemplate = redisTemplate;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        //从当前header中获取token
        UsernamePasswordAuthenticationToken authenticationToken = getAuthentication(request);
        //判断是否有权限信息，放到权限上下文
        if (request != null) {
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }
        // 放行
        chain.doFilter(request, response);
    }

    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest httpServletRequest) {
        String token = httpServletRequest.getHeader("token");
        if (token != null) {
            String username = tokenManager.getUsernameInfoFromToken(token);
            // 从redis获取对应的权限列表
            List<String> permissionValueList = (List<String>) redisTemplate.opsForValue().get(username);
            Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
            for (String s : permissionValueList) {
                SimpleGrantedAuthority auth = new SimpleGrantedAuthority(s);
                grantedAuthorities.add(auth);
            }
            return new UsernamePasswordAuthenticationToken(username, token, grantedAuthorities);
        }
        return null;

    }
}
