package com.unievents.service.composite;

import com.unievents.dto.ProgramOrderCreateDto;
import com.unievents.enums.CompositeCheckType;
import com.unievents.initialize.impl.composite.AbstractComposite;

/**
 * @program: 极度真实还原大麦网高并发实战项目。 添加 阿星不是程序员 微信，添加时备注 大麦 来获取项目的完整资料 
 * @description: 生成节目订单验证基类，生成节目订单的相关验证逻辑继承此类
 * @author: 阿星不是程序员
 **/
public abstract class AbstractProgramCheckHandler extends AbstractComposite<ProgramOrderCreateDto> {
    
    @Override
    public String type() {
        return CompositeCheckType.PROGRAM_ORDER_CREATE_CHECK.getValue();
    }
}
