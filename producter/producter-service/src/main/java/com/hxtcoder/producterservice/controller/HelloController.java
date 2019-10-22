package com.hxtcoder.producterservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * @author xiaotian.huang
 */
@RestController
public class HelloController {

    @GetMapping("hello")
    public String hello() throws InterruptedException {
        Random random = new Random();
        int time = 25 * (random.nextInt(80) + 1);
        System.out.println("sleepTime: " + time);
        Thread.sleep(time);
        return String.format("请求成功, 线程sleep时间: %d", time);
    }

    @GetMapping("hello3")
    public String hello3(@RequestParam("millis")int millis) throws InterruptedException {
        System.out.println("sleepTime: " + millis);
        Thread.sleep(millis);
        return String.format("请求成功, 线程sleep时间: %d", millis);
    }

    @GetMapping("hello4")
    public ResponseEntity<String> hello4(@RequestParam("status")int status) {
        System.out.println("hello4被调用");
        switch (status) {
            case 501: {
                return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(HttpStatus.NOT_IMPLEMENTED.getReasonPhrase());
            }
            case 404: {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(HttpStatus.NOT_FOUND.getReasonPhrase());
            }
            case 401: {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(HttpStatus.UNAUTHORIZED.getReasonPhrase());
            }
           case 301: {
                return ResponseEntity.status(HttpStatus.MOVED_PERMANENTLY).body(HttpStatus.MOVED_PERMANENTLY.getReasonPhrase());
            }
           case 201: {
                return ResponseEntity.status(HttpStatus.CREATED).body(HttpStatus.CREATED.getReasonPhrase());
            }
           case 101: {
                return ResponseEntity.status(HttpStatus.SWITCHING_PROTOCOLS).body(HttpStatus.SWITCHING_PROTOCOLS.getReasonPhrase());
            }
            default: {
                return ResponseEntity.status(HttpStatus.OK).body(HttpStatus.OK.getReasonPhrase());
            }
        }
    }
}
