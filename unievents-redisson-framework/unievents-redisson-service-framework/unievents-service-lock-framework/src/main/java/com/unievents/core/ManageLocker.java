package com.unievents.core;

import com.unievents.servicelock.LockType;
import com.unievents.servicelock.ServiceLocker;
import com.unievents.servicelock.impl.RedissonFairLocker;
import com.unievents.servicelock.impl.RedissonReadLocker;
import com.unievents.servicelock.impl.RedissonReentrantLocker;
import com.unievents.servicelock.impl.RedissonWriteLocker;
import org.redisson.api.RedissonClient;

import java.util.HashMap;
import java.util.Map;

import static com.unievents.servicelock.LockType.Fair;
import static com.unievents.servicelock.LockType.Read;
import static com.unievents.servicelock.LockType.Reentrant;
import static com.unievents.servicelock.LockType.Write;

/**
 * @program: 极度真实还原大麦网高并发实战项目。 添加 阿星不是程序员 微信，添加时备注 大麦 来获取项目的完整资料 
 * @description: 分布式锁 锁缓存
 * @author: 阿星不是程序员
 **/
public class ManageLocker {

    private final Map<LockType, ServiceLocker> cacheLocker = new HashMap<>();
    
    public ManageLocker(RedissonClient redissonClient){
        cacheLocker.put(Reentrant,new RedissonReentrantLocker(redissonClient));
        cacheLocker.put(Fair,new RedissonFairLocker(redissonClient));
        cacheLocker.put(Write,new RedissonWriteLocker(redissonClient));
        cacheLocker.put(Read,new RedissonReadLocker(redissonClient));
    }
    
    public ServiceLocker getReentrantLocker(){
        return cacheLocker.get(Reentrant);
    }
    
    public ServiceLocker getFairLocker(){
        return cacheLocker.get(Fair);
    }
    
    public ServiceLocker getWriteLocker(){
        return cacheLocker.get(Write);
    }
    
    public ServiceLocker getReadLocker(){
        return cacheLocker.get(Read);
    }
}
