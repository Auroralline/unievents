package com.unievents.controller;

import com.unievents.common.ApiResponse;
import com.unievents.dto.RuleDto;
import com.unievents.dto.RuleGetDto;
import com.unievents.dto.RuleStatusDto;
import com.unievents.dto.RuleUpdateDto;
import com.unievents.service.RuleService;
import com.unievents.vo.RuleVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: 极度真实还原大麦网高并发实战项目。 添加 阿星不是程序员 微信，添加时备注 大麦 来获取项目的完整资料 
 * @description: 普通规则 控制层
 * @author: 阿星不是程序员
 **/
@RestController
@RequestMapping("/rule")
@Tag(name = "rule", description = "规则")
public class RuleController {

    @Autowired
    private RuleService ruleService;
    
    @Operation(summary  = "添加普通规则")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ApiResponse<Void> add(@Valid @RequestBody RuleDto ruleDto) {
        ruleService.ruleAdd(ruleDto);
        return ApiResponse.ok();
    }
    
    @Operation(summary  = "修改普通规则")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ApiResponse<Void> update(@Valid @RequestBody RuleUpdateDto ruleUpdateDto) {
        ruleService.ruleUpdate(ruleUpdateDto);
        return ApiResponse.ok();
    }
    
    @Operation(summary  = "修改普通规则状态")
    @RequestMapping(value = "/updateStatus", method = RequestMethod.POST)
    public ApiResponse<Void> updateStatus(@Valid @RequestBody RuleStatusDto ruleStatusDto){
        ruleService.ruleUpdateStatus(ruleStatusDto);
        return ApiResponse.ok();
    }
    
    @Operation(summary  = "查询普通规则")
    @RequestMapping(value = "/get", method = RequestMethod.POST)
    public ApiResponse<RuleVo> get(@Valid @RequestBody RuleGetDto ruleGetDto){
        return ApiResponse.ok(ruleService.get(ruleGetDto));
    }
}
