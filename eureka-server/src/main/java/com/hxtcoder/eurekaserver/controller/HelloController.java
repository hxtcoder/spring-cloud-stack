package com.hxtcoder.eurekaserver.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${server.port}")
    private String port;

    @GetMapping(value = "hello")
    public String hello() {
        String url = String.format("http://localhost:%s", port);
        return "hello server! front url: " + url;
    }
}
