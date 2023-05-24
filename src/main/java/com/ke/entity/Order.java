package com.ke.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

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
 * @since 2022-04-21
 */
@Getter
@Setter
@TableName("t_order")
@ApiModel(value = "Order对象", description = "")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("患者id")
    private Integer patientId;

    @ApiModelProperty("患者姓名")
    private String patientName;

    @ApiModelProperty("医生id")
    private Integer doctorId;

    @ApiModelProperty("医生姓名")
    private String doctorName;

    @ApiModelProperty("期望时间")
    private LocalDateTime planTime;

    @ApiModelProperty("实际时间")
    private LocalDateTime actualTime;

    @ApiModelProperty("费用")
    private BigDecimal cost;

    @ApiModelProperty("状态")
    private String state;

    @ApiModelProperty("转诊类型")
    private String decision;

    @ApiModelProperty("会诊结果")
    private String conclusion;


    @ApiModelProperty("逻辑删除")
    private Integer deleted;


}
