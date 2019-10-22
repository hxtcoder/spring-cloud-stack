package com.hxtcoder.consumerservice.client.fallback;

import com.hxtcoder.consumerservice.client.ProducterServiceClient;
import feign.FeignException;
import feign.RetryableException;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author xiaotian.huang
 */
@Slf4j
@Component
public class ProducterServiceFallbackFactory implements FallbackFactory<ProducterServiceClient> {

    @Override
    public ProducterServiceClient create(Throwable throwable) {
        log.error("调用出现异常", throwable);
        if (throwable instanceof RetryableException) {
            return createForTimeout();
        } else if (throwable instanceof FeignException) {
            FeignException feignException = (FeignException)throwable;
            int status = feignException.status();
            log.warn("服务间调用，返回状态码：{}", status);
        }
        return createDefault();
    }

    private ProducterServiceClient createDefault() {

        return new ProducterServiceClient() {

            @Override
            public String hello() {
                return "内部异常";
            }

            @Override
            public String hello2() {
                return "内部异常";
            }

            @Override
            public String hello3(int millis) {
                return "内部异常";
            }

            @Override
            public String hello4(int status) {
//                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("内部异常");
                return "内部异常";
            }
        };
    }

    private ProducterServiceClient createForTimeout() {

        return new ProducterServiceClient() {

            @Override
            public String hello() {
                return "服务调用超时";
            }

            @Override
            public String hello2() {
                return "服务调用超时";
            }

            @Override
            public String hello3(int millis) {
                return "服务调用超时";
            }

            @Override
            public String hello4(int status) {
//                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("服务调用超时");
                return "服务调用超时";
            }
        };
    }
}
