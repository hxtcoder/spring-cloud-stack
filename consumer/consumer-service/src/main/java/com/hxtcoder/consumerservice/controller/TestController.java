package com.hxtcoder.consumerservice.controller;

import com.hxtcoder.consumerservice.client.ProducterServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiaotian.huang
 */
@RestController
public class TestController {

    @Autowired
    private ProducterServiceClient producterServiceClient;


    @GetMapping("test")
    public String test() {
        System.out.println("test被调用");
        return producterServiceClient.hello();
    }

    @GetMapping("test2")
    public String test2() {
        System.out.println("test2被调用");
        return producterServiceClient.hello2();
    }

   @GetMapping("test3")
    public String test3(@RequestParam("millis")int millis) {
        System.out.println("test3被调用");
        return producterServiceClient.hello3(millis);
    }

    @GetMapping("test4")
    public String test4(@RequestParam("status")int status) {
        System.out.println("test4被调用");
        return producterServiceClient.hello4(status);
    }
}
