package me.lukegs7.springsecurity.securitydemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

@Configuration
public class CustomSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    // 注入数据源
    @Autowired
    private DataSource dataSource;

    // 配置对象
    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
        jdbcTokenRepository.setDataSource(dataSource);
        // jdbcTokenRepository.setCreateTableOnStartup();
        return jdbcTokenRepository;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(password());
    }

    // 需要创建PasswordEncoder接口对象
    @Bean
    PasswordEncoder password() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 配置没有访问权限跳转到自定义页面
        http.exceptionHandling().accessDeniedPage("/unauth.html");
        // 在配置类中添加退出映射地址
        http.logout().logoutUrl("/logout").logoutSuccessUrl("/test/hello").permitAll();
        http.formLogin()// 自定义登录页面
                .loginPage("/login.html")
                .loginProcessingUrl("/user/login") //登录访问路径，controller中的某个接口地址
                .defaultSuccessUrl("/success.html").permitAll()  //登录成功后要跳转到的路径
                .and().authorizeRequests() //哪些url方法需要认证，哪些不需要认证
                .antMatchers("/", "/test/hello", "/user/login").permitAll()//访问这些路径是不需要认证，直接访问
                // 1. 当前登录用户，只有admins权限才可以访问这个路径
                .antMatchers("/test/index").hasAuthority("admins")
                // 2. 当前登录用户，只有具备admins,manager权限才能访问这个路径
                // .antMatchers("/test/index").hasAnyAuthority("admins,manager")
                // 3. 当前登录用户，只有具备role角色才能访问路径
                // .antMatchers("/test/index").hasRole("sale")
                // 4. 当前登录用户，只有具备role角色才能访问路径
                // .antMatchers("/test/update").hasAnyRole("sale,role,admin")
                .anyRequest().authenticated()
                .and().rememberMe().tokenRepository(persistentTokenRepository())
                .tokenValiditySeconds(60)  // 设置有效时长
                .userDetailsService(userDetailsService)
                .and().csrf().disable(); //关闭csf防护
    }
}