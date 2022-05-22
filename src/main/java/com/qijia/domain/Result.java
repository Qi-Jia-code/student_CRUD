package com.qijia.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "响应结果类型")
public class Result {
    @ApiModelProperty(name = "success", value = "是否成功", required = true)
    private Boolean success;
    @ApiModelProperty(name = "data", value = "返回数据", required = true)
    private Object data;
    @ApiModelProperty(name = "message", value = "提示信息", required = true)
    private String message;
}
