package com.my.blog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 用户
 * </p>
 *
 * @author jiaomingyu5778@gmail.com
 * @since 2020-04-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="User对象", description="用户")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键，自增")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "用户名")
    @NotBlank(message = "用户名必输！")
    private String username;

    @NotBlank(message = "密码必输！")
    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "电话号码")
    private String phone;

    @ApiModelProperty(value = "性别")
    private String gender;

    @ApiModelProperty(value = "邮箱")
    @NotBlank(message = "邮箱必输！")
    @Email(message = "邮箱格式不正确！")
    private String email;

    @ApiModelProperty(value = "头像url")
    private String avatarUrl;

    @ApiModelProperty(value = "个人简介")
    private String personalProfile;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "上次登录时间")
    private LocalDateTime lastLoginTime;


}
