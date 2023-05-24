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
  @TableName("t_doctor")
@ApiModel(value = "Doctor对象", description = "")
public class Doctor implements Serializable {

    private static final long serialVersionUID = 1L;

      @ApiModelProperty("id")
        @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

      @ApiModelProperty("用户编号")
      private Integer userId;

      @ApiModelProperty("性别")
      private String gender;

      @ApiModelProperty("年龄")
      private String age;

      @ApiModelProperty("真实姓名")
      private String doctorName;

      @ApiModelProperty("医生执业证")
      private String licence;

      @ApiModelProperty("医院")
      private String hospital;

      @ApiModelProperty("部门")
      private String department;

      @ApiModelProperty("职务")
      private String position;

      @ApiModelProperty("逻辑删除")
      private Integer deleted;


}
