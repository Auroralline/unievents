package com.unievents.config;

import com.unievents.constant.LockInfoType;
import com.unievents.handle.RedissonDataHandle;
import com.unievents.locallock.LocalLockCache;
import com.unievents.lockinfo.LockInfoHandle;
import com.unievents.lockinfo.factory.LockInfoHandleFactory;
import com.unievents.lockinfo.impl.RepeatExecuteLimitLockInfoHandle;
import com.unievents.repeatexecutelimit.aspect.RepeatExecuteLimitAspect;
import com.unievents.servicelock.factory.ServiceLockFactory;
import org.springframework.context.annotation.Bean;

/**
 * @program: 极度真实还原大麦网高并发实战项目。 添加 阿星不是程序员 微信，添加时备注 大麦 来获取项目的完整资料 
 * @description: 防重复幂等配置
 * @author: 阿星不是程序员
 **/
public class RepeatExecuteLimitAutoConfiguration {
    
    @Bean(LockInfoType.REPEAT_EXECUTE_LIMIT)
    public LockInfoHandle repeatExecuteLimitHandle(){
        return new RepeatExecuteLimitLockInfoHandle();
    }
    
    @Bean
    public RepeatExecuteLimitAspect repeatExecuteLimitAspect(LocalLockCache localLockCache,
                                                             LockInfoHandleFactory lockInfoHandleFactory,
                                                             ServiceLockFactory serviceLockFactory,
                                                             RedissonDataHandle redissonDataHandle){
        return new RepeatExecuteLimitAspect(localLockCache, lockInfoHandleFactory,serviceLockFactory,redissonDataHandle);
    }
}
    