package com.unievents.service.lua;

import com.alibaba.fastjson.JSON;
import com.unievents.redis.RedisCache;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.scripting.support.ResourceScriptSource;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @program: 极度真实还原大麦网高并发实战项目。 添加 阿星不是程序员 微信，添加时备注 大麦 来获取项目的完整资料 
 * @description: 节目订单 缓存
 * @author: 阿星不是程序员
 **/
@Slf4j
@Component
public class ProgramCacheCreateOrderResolutionOperate {
    
    @Autowired
    private RedisCache redisCache;
    
    private DefaultRedisScript<String> redisScript;
    
    @PostConstruct
    public void init(){
        try {
            redisScript = new DefaultRedisScript<>();
            redisScript.setScriptSource(new ResourceScriptSource(new ClassPathResource("lua/programDataCreateOrderResolution.lua")));
            redisScript.setResultType(String.class);
        } catch (Exception e) {
            log.error("redisScript init lua error",e);
        }
    }
    
    public ProgramCacheCreateOrderData programCacheOperate(List<String> keys, String[] args){
        Object object = redisCache.getInstance().execute(redisScript, keys, args);
        return JSON.parseObject((String)object, ProgramCacheCreateOrderData.class);
    }
}
