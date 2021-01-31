package me.lukegs7.service.impl;

import me.lukegs7.dao.entity.User;
import me.lukegs7.dao.repository.UserRepository;
import me.lukegs7.dto.UserDto;
import me.lukegs7.mapper.UserMapper;
import me.lukegs7.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserDto findById(Integer id) {
        Optional<User> u = userRepository.findById(id);
        return u.map(userMapper::toDto).orElse(null);
    }

    @Override
    public UserDto save(User user) {
        return userMapper.toDto(userRepository.save(user));
    }

    @Override
    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<UserDto> findAll() {
        return userMapper.toDto(userRepository.findAll());
    }

    @Override
    public UserDto findByUsername(String username) {
        return userMapper.toDto(userRepository.findByUsername(username));
    }
}
