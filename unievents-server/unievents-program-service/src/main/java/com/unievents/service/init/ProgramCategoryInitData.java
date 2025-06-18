package com.unievents.service.init;

import com.unievents.BusinessThreadPool;
import com.unievents.initialize.base.AbstractApplicationPostConstructHandler;
import com.unievents.service.ProgramCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;
/**
 * @program: 极度真实还原大麦网高并发实战项目。 添加 阿星不是程序员 微信，添加时备注 大麦 来获取项目的完整资料 
 * @description: 节目种类缓存
 * @author: 阿星不是程序员
 **/
@Component
public class ProgramCategoryInitData extends AbstractApplicationPostConstructHandler {
    
    @Autowired
    private ProgramCategoryService programCategoryService;
    
    
    @Override
    public Integer executeOrder() {
        return 1;
    }
    
    @Override
    public void executeInit(final ConfigurableApplicationContext context) {
        BusinessThreadPool.execute(() -> {
            programCategoryService.programCategoryRedisDataInit();
        });
    }
}
