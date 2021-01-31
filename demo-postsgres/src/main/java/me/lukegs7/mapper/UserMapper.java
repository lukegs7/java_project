package me.lukegs7.mapper;


import me.lukegs7.dao.entity.User;
import me.lukegs7.dto.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends IEntityMapper<UserDto, User> {
}
