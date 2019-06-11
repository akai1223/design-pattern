package com.zek.hystrix.controller;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@Slf4j
@RestController
public class HystrixDemo2Controller {

    @GetMapping("/hello-world2")
    public String helloWorld() {

        return new CustomerHystrixCommand(HystrixCommandGroupKey.Factory.asKey("helloWorld"),
                100).execute();
    }

    public class CustomerHystrixCommand extends HystrixCommand<String> {
        public CustomerHystrixCommand(HystrixCommandGroupKey group, int executionIsolationThreadTimeoutInMilliseconds) {
            super(group, executionIsolationThreadTimeoutInMilliseconds);
        }

        @Override
        protected String run() throws Exception {
            Random random = new Random();
            int value = random.nextInt(200);

            System.out.println("hello world costs " + value + "ms");
            Thread.sleep(value);

            return "hello world";
        }

        @Override
        protected String getFallback() {
            return HystrixDemo2Controller.this.errorContent();
        }

    }

    public String errorContent() {
        return "fault";
    }

}
