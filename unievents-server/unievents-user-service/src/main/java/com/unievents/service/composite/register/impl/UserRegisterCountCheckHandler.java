package com.unievents.service.composite.register.impl;

import com.unievents.dto.UserRegisterDto;
import com.unievents.enums.BaseCode;
import com.unievents.exception.unieventsFrameException;
import com.unievents.service.composite.register.AbstractUserRegisterCheckHandler;
import com.unievents.service.tool.RequestCounter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @program: 极度真实还原大麦网高并发实战项目。 添加 阿星不是程序员 微信，添加时备注 大麦 来获取项目的完整资料 
 * @description: 用户注册请求数检查
 * @author: 阿星不是程序员
 **/
@Component
public class UserRegisterCountCheckHandler extends AbstractUserRegisterCheckHandler {
    
    @Autowired
    private RequestCounter requestCounter;
    
    @Override
    protected void execute(final UserRegisterDto param) {
        boolean result = requestCounter.onRequest();
        if (result) {
            throw new unieventsFrameException(BaseCode.USER_REGISTER_FREQUENCY);
        }
    }
    
    @Override
    public Integer executeParentOrder() {
        return 1;
    }
    
    @Override
    public Integer executeTier() {
        return 2;
    }
    
    @Override
    public Integer executeOrder() {
        return 1;
    }
}
