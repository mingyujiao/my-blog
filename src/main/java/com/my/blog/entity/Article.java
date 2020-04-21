package com.my.blog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 文章列表
 * </p>
 *
 * @author jiaomingyu5778@gmail.com
 * @since 2020-04-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Article对象", description="文章列表")
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键，自增")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "文章id")
    private Long articleId;

    @NotNull(message = "请填写作者")
    @ApiModelProperty(value = "作者")
    private String author;

    @NotNull(message = "文章标题不能为空")
    @ApiModelProperty(value = "文章标题")
    private String articleTitle;

    @NotNull(message = "文章类别不能为空")
    @ApiModelProperty(value = "类别")
    private String type;

    @ApiModelProperty(value = "摘要")
    private String summary;

    @NotNull(message = "分类信息不能为空")
    @ApiModelProperty(value = "分类")
    private String categories;

    @ApiModelProperty(value = "文章内容")
    private String content;

    @ApiModelProperty(value = "点赞数")
    private Integer likes;

    @ApiModelProperty(value = "上一篇文章id")
    private Long lastArticleId;

    @ApiModelProperty(value = "写一篇文章id")
    private Long nextArticleId;

    @ApiModelProperty(value = "时间轴")
    private String timeline;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "访问数")
    private Integer visits;


}
