package com.hxtcoder.producterinterface.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author xiaotian.huang
 */
public interface ProducterServiceEndpoint {

    /**
     * hello
     *
     * @return
     */
    @GetMapping("hello")
    String hello();


    /**
     * hello2
     *
     * @return
     */
    @GetMapping("hello2")
    String hello2();

    /**
     * hello3
     * @param millis
     * @return
     */
    @GetMapping("hello3")
    String hello3(@RequestParam("millis")int millis);

    /**
     * hello4
     * @param status
     * @return
     */
    @GetMapping("hello4")
    String hello4(@RequestParam("status")int status);
}
