package com.hxtcoder.consumerservice.config;

import feign.Logger;
import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xiaotian.huang
 */
@Configuration
public class FeignConfig {


    /**
     * 默认值
     *  period=100 发起当前请求的时间间隔，单位毫秒
     *  maxPeriod=1000 发起当前请求的最大时间间隔，单位毫秒
     *  maxAttempts=5 最多请求次数，包括第一次
     * @return
     */
//    @Bean
//    public Retryer feignRetryer() {
//        return new Retryer.Default();
//    }

    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }

}