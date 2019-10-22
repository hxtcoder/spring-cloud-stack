package com.hxtcoder.producterservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author xiaotian.huang
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ProducterServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProducterServiceApplication.class, args);
    }

}
