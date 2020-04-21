package com.my.blog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 留言
 * </p>
 *
 * @author jiaomingyu5778@gmail.com
 * @since 2020-04-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="MessageBoard对象", description="留言")
public class MessageBoard implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键，自增")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @Length(message = "昵称太短，或太长", min = 1, max = 32)
    @NotEmpty(message = "昵称不能为空")
    @ApiModelProperty(value = "昵称")
    private String nickname;

    @Length(message = "留言过长", min = 1, max = 128)
    @NotEmpty(message = "留言不能为空")
    @ApiModelProperty(value = "留言")
    private String message;

    @ApiModelProperty(value = "记录时间")
    private LocalDateTime createTime;


}
