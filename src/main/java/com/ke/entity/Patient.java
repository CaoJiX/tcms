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
 * @since 2022-02-18
 */
@Getter
@Setter
@TableName("t_patient")
@ApiModel(value = "Patient对象", description = "")
public class Patient implements Serializable {

    private static final long serialVersionUID = 1L;

      @ApiModelProperty("id")
      @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

      @ApiModelProperty("用户编号")
      private Integer userId;

      @ApiModelProperty("患者姓名")
      private String patientName;

      @ApiModelProperty("身份证号")
      private String idCard;

      @ApiModelProperty("性别")
      private String gender;

      @ApiModelProperty("简介")
      private String detail;

      @ApiModelProperty("年龄")
      private Integer age;

      @ApiModelProperty("逻辑删除")
      private Integer deleted;


}
