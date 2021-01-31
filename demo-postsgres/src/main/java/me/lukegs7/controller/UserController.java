package me.lukegs7.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import me.lukegs7.common.DataType;
import me.lukegs7.common.ParamType;
import me.lukegs7.dao.entity.User;
import me.lukegs7.dto.UserDto;
import me.lukegs7.mapper.UserMapper;
import me.lukegs7.service.UserService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * User Controller
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2018-11-29 11:30
 */
@RestController
@RequestMapping("/user")
@Api(value = "用户管理")
@Slf4j
public class UserController {
    @Resource
    UserService userService;

    @GetMapping
    @ApiOperation(value = "按用户名查询")
    @ApiImplicitParams({@ApiImplicitParam(name = "username", value = "用户名", dataType = DataType.STRING, paramType = ParamType.QUERY)})
    public UserDto getByUserName(String username) {
        return userService.findByUsername(username);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "按id查询")
    @ApiImplicitParams({@ApiImplicitParam(name = "id", value = "用户编号", dataType = DataType.INT, paramType = ParamType.PATH)})
    public UserDto get(@PathVariable Integer id) {
        return userService.findById(id);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除用户")
    @ApiImplicitParam(name = "id", value = "用户编号", dataType = DataType.INT, paramType = ParamType.PATH)
    public void delete(@PathVariable Integer id) {
        userService.deleteById(id);
    }

    @PostMapping
    @ApiOperation(value = "添加用户")
    public UserDto post(@RequestBody User user) {
        return userService.save(user);
    }

    @PutMapping
    @ApiOperation(value = "修改用户")
    public void put(@RequestBody User user) {
        userService.save(user);
    }
}
