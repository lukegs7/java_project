package me.lukegs7.springsecurity.securitydemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import me.lukegs7.springsecurity.securitydemo.entity.Users;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<Users> {

}
