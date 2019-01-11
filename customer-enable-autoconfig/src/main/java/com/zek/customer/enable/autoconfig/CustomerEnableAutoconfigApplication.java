package com.zek.customer.enable.autoconfig;

import com.zek.customer.enable.MyEnable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MyEnable
public class CustomerEnableAutoconfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerEnableAutoconfigApplication.class, args);
    }
}
