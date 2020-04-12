package com.my.blog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 日志
 * </p>
 *
 * @author jiaomingyu5778@gmail.com
 * @since 2020-04-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Log对象", description="日志")
@Builder
public class Log implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键，自增")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "ip地址")
    private String ip;

    @ApiModelProperty(value = "用户操作")
    private String operation;

    @ApiModelProperty(value = "处理方法名")
    private String method;

    @ApiModelProperty(value = "请求参数")
    private String params;

    @ApiModelProperty(value = "处理时间，单位毫秒")
    private Integer spendTime;

    @ApiModelProperty(value = "记录时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "返回信息")
    private String responseArgs;
}
