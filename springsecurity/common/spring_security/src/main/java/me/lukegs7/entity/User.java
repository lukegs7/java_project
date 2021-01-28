package me.lukegs7.entity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.annotation.sql.DataSourceDefinition;
import java.io.Serializable;

@Data
@ApiModel(description = "用户实体类")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value="微信ID")
    private String username;
    @ApiModelProperty(value="密码")
    private String password;
    private String nickName;
    private String salt;
    private String token;
}