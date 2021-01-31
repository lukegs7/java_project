package me.lukegs7.service;

import me.lukegs7.dao.entity.User;
import me.lukegs7.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto findById(Integer id);

    UserDto save(User user);

    void deleteById(Integer id);

    List<UserDto> findAll();

    UserDto findByUsername(String username);
}
