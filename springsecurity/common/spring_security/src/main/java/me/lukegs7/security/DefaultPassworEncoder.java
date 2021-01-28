package me.lukegs7.security;

import me.lukegs7.utils.MD5;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DefaultPassworEncoder implements PasswordEncoder {
    public DefaultPassworEncoder() {
        this(-1);
    }
    public DefaultPassworEncoder(Integer strength) {
    }
    /**
     * 加密方法
     * @param rawPassword
     * @return
     */
    @Override
    public String encode(CharSequence rawPassword) {
        return MD5.encrypt(rawPassword.toString());
    }
    /**
     * 进行密码比对
     *
     * @param rawPassword 原始密码，前端传回的未加密的密码
     * @param encodedPassword 加密后的密码，存储在数据库中的密码
     * @return
     */
    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return encodedPassword.equals(MD5.encrypt(rawPassword.toString()));
    }
}
