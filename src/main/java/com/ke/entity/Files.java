package com.ke.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 *
 * </p>
 *
 * @author ke
 * @since 2022-02-13
 */
@Getter
@Setter
@TableName("sys_file")
@ApiModel(value = "File对象", description = "")
public class Files implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("文件名称")
    private String name;

    @ApiModelProperty("文件类型")
    private String type;

    @ApiModelProperty("文件大小(kb)")
    private Long size;

    @ApiModelProperty("所属订单编号")
    private Integer orderId;

    @ApiModelProperty("所属用户编号")
    private Integer userId;

    @ApiModelProperty("下载链接")
    private String url;

    @ApiModelProperty("文件md5")
    private String md5;

    @ApiModelProperty("逻辑删除")
    private Boolean deleted;

    @ApiModelProperty("是否禁用链接")
    private Boolean enable;


}
