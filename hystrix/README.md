#### 断路器

@EnableHystrix 激活

```java
package com.zek.hystrix.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class HystrixDemoController {


    /**
     * 超时100ms，调用errorContent()替代
     *
     * @return
     * @throws Exception
     */
    @GetMapping("/hello-world1")
    @HystrixCommand(fallbackMethod = "errorContent", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "100")})
    public String hello() throws Exception {

        return helloWorld();
    }

    public String helloWorld() throws InterruptedException {

        Random random = new Random();
        int value = random.nextInt(200);

        System.out.println("hello world costs " + value + "ms");
        Thread.sleep(value);

        return "hello world";
    }

    public String errorContent(){
        return "fail";
    }
}

```