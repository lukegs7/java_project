package me.lukegs7.config;

import me.lukegs7.filter.TokenAuthenticationFilter;
import me.lukegs7.filter.TokenLoginFilter;
import me.lukegs7.security.DefaultPassworEncoder;
import me.lukegs7.security.TokenLogoutHandler;
import me.lukegs7.security.TokenManager;
import me.lukegs7.security.UnAuthEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
public class TokenWebSecurityConfig extends WebSecurityConfigurerAdapter {
    private TokenManager tokenManager;
    private RedisTemplate redisTemplate;
    private DefaultPassworEncoder defaultPassworEncoder;
    private UserDetailsService userDetailsService;

    @Autowired
    public TokenWebSecurityConfig(UserDetailsService userDetailsService, DefaultPassworEncoder defaultPassworEncoder, TokenManager tokenManager,
                                  RedisTemplate redisTemplate) {
        this.tokenManager = tokenManager;
        this.redisTemplate = redisTemplate;
        this.defaultPassworEncoder = defaultPassworEncoder;
        this.userDetailsService = userDetailsService;
    }

    /**
     * 配置设置
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.exceptionHandling()
                // 没有权限访问
                .authenticationEntryPoint(new UnAuthEntryPoint())
                // 关闭csrf
                .and().csrf().disable()
                .authorizeRequests()
                // 设置退出路径
                .anyRequest().authenticated().and().logout().logoutUrl("/admin/acl/index/logout")
                // 退出时执行logout逻辑
                .addLogoutHandler(new TokenLogoutHandler(tokenManager, redisTemplate))
                // 添加自定义的认证过滤器
                .and().addFilter(new TokenLoginFilter(tokenManager, redisTemplate, authenticationManager()))
                // 添加自定义的授权过滤器
                .addFilter(new TokenAuthenticationFilter(tokenManager, redisTemplate, authenticationManager())).httpBasic();
    }

    //调用userDetailsService和密码处理
    @Override
    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(defaultPassworEncoder);
    }

    // 不进行认证的路径可以直接访问
    @Override
    public void configure(WebSecurity webSecurity) {
        webSecurity.ignoring().antMatchers("/api/**");
    }


}