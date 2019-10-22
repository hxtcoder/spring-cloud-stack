package com.hxtcoder.producterservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiaotian.huang
 */
@RestController
public class Hello2Controller {

    @GetMapping("hello2")
    public String hello2() {
        System.out.println("hello2被调用");
        return "hello2成功响应";
    }
}
