package com.unievents.service.strategy.impl;

import com.unievents.core.RepeatExecuteLimitConstants;
import com.unievents.dto.ProgramOrderCreateDto;
import com.unievents.enums.CompositeCheckType;
import com.unievents.enums.ProgramOrderVersion;
import com.unievents.initialize.base.AbstractApplicationCommandLineRunnerHandler;
import com.unievents.initialize.impl.composite.CompositeContainer;
import com.unievents.repeatexecutelimit.annotion.RepeatExecuteLimit;
import com.unievents.service.ProgramOrderService;
import com.unievents.service.strategy.ProgramOrderContext;
import com.unievents.service.strategy.ProgramOrderStrategy;
import com.unievents.servicelock.annotion.ServiceLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import static com.unievents.core.DistributedLockConstants.PROGRAM_ORDER_CREATE_V1;

/**
 * @program: 极度真实还原大麦网高并发实战项目。 添加 阿星不是程序员 微信，添加时备注 大麦 来获取项目的完整资料 
 * @description: 节目订单v1
 * @author: 阿星不是程序员
 **/
@Component
public class ProgramOrderV1Strategy extends AbstractApplicationCommandLineRunnerHandler implements ProgramOrderStrategy {
    
    @Autowired
    private ProgramOrderService programOrderService;
    
    @Autowired
    private CompositeContainer compositeContainer;
    
    
    @RepeatExecuteLimit(
            name = RepeatExecuteLimitConstants.CREATE_PROGRAM_ORDER,
            keys = {"#programOrderCreateDto.userId","#programOrderCreateDto.programId"})
    @ServiceLock(name = PROGRAM_ORDER_CREATE_V1,keys = {"#programOrderCreateDto.programId"})
    @Override
    public String createOrder(final ProgramOrderCreateDto programOrderCreateDto) {
        compositeContainer.execute(CompositeCheckType.PROGRAM_ORDER_CREATE_CHECK.getValue(),programOrderCreateDto);
        return programOrderService.create(programOrderCreateDto);
    }
    
    @Override
    public Integer executeOrder() {
        return 1;
    }
    
    @Override
    public void executeInit(final ConfigurableApplicationContext context) {
        ProgramOrderContext.add(ProgramOrderVersion.V1_VERSION.getVersion(),this);
    }
}
