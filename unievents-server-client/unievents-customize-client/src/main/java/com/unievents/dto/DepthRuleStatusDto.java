package com.unievents.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * @program: 极度真实还原大麦网高并发实战项目。 添加 阿星不是程序员 微信，添加时备注 大麦 来获取项目的完整资料 
 * @description: 深度规则状态修改 dto
 * @author: 阿星不是程序员
 **/
@Data
@Schema(title="DepthRuleStatusDto", description ="深度规则状态修改")
public class DepthRuleStatusDto {
    
    @Schema(name ="id", type ="String", description ="深度规则id", requiredMode= RequiredMode.REQUIRED)
    @NotNull
    private Long id;
    
    @Schema(name ="status", type ="Integer", description ="状态 1生效 0禁用", requiredMode= RequiredMode.REQUIRED)
    @NotNull
    private Integer status;
}
