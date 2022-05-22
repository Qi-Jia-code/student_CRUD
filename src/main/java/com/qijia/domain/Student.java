package com.qijia.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("student")
@ApiModel(value = "学生类型")
public class Student {
    //学号作为ID,每次新建需带上学号
    @TableId(type = IdType.INPUT)
    @ApiModelProperty(name = "`id`", value = "学号", required = true)
    private String id;
    @TableField("`name`")
    @ApiModelProperty(name = "name", value = "姓名", required = true)
    private String username;
    @TableField("`sex`")
    @ApiModelProperty(name = "sex", value = "性别", required = true)
    private String sex;
    @TableField("`sex`")
    @ApiModelProperty(name = "major", value = "专业", required = true)
    private String major;
    @TableField("`sex`")
    @ApiModelProperty(name = "phone", value = "联系电话", required = true)
    private String phone;
}
