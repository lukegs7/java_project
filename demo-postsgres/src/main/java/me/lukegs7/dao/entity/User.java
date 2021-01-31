package me.lukegs7.dao.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * <p>
 * 用户实体
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2018-11-29 11:31
 */
@Data
@Entity
@Table(name = "user", schema = "demo")
@ApiModel(value = "用户", description = "User Entity")
public class User implements Serializable {
    private static final long serialVersionUID = 5057954049311281252L;

    /**
     * 主键
     */
    @Id
    @SequenceGenerator(sequenceName = "user_id_seq", name = "user_id", schema = "demo", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id")
    @Column(name = "id")
    @ApiModelProperty(value = "主键id", required = true)
    private Integer id;
    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名", required = true)
    private String username;

    @ApiModelProperty(value = "密码", required = true)
    private String password;

    /**
     * 工作岗位
     */
    @ApiModelProperty(value = "工作岗位", required = true)
    private String job;
}
