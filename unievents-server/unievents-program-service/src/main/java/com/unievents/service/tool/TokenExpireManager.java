package com.unievents.service.tool;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @program: 极度真实还原大麦网高并发实战项目。 添加 阿星不是程序员 微信，添加时备注 大麦 来获取项目的完整资料 
 * @description: token失效时间管理
 * @author: 阿星不是程序员
 **/
@Data
@Component
public class TokenExpireManager {
    
    @Value("${token.expire.time:40}")
    private Long tokenExpireTime;
}
