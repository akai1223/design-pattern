package com.zek.hystrix.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HystrixDemo1Controller {

    /**
     * 方法调用失败或超时，errorContent替代
     *
     * @return
     */
    @GetMapping("/hello-world")
    @HystrixCommand(fallbackMethod = "errorContent")
    public String helloWorld() {
        return "hello world";
    }

    public String errorContent() {
        return "fault";
    }
}
