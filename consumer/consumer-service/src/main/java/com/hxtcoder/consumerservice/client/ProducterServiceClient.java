package com.hxtcoder.consumerservice.client;

import com.hxtcoder.consumerservice.client.fallback.ProducterServiceFallbackFactory;
import com.hxtcoder.consumerservice.config.FeignConfig;
import com.hxtcoder.producterinterface.controller.ProducterServiceEndpoint;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author xiaotian.huang
 */
@FeignClient(name = "producter-service",
        configuration = FeignConfig.class,
        decode404 = true,
        fallbackFactory = ProducterServiceFallbackFactory.class)
public interface ProducterServiceClient extends ProducterServiceEndpoint {
}
