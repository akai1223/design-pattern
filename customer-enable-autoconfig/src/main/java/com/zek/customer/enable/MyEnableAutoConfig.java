package com.zek.customer.enable;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description
 * @Auther zhangkai
 * @DateTime 2018/11/27 10:10 PM
 */
@Configuration
@EnableConfigurationProperties(MyCustomerProperties.class)
@ConditionalOnClass(User.class)
@Slf4j
public class MyEnableAutoConfig {

    @Autowired
    private MyCustomerProperties myCustomerProperties;

    @Bean
    @ConditionalOnMissingBean(User.class)
    public User user(){
        log.info("init " + myCustomerProperties.getName() + " | " + myCustomerProperties.getAge());
        return new User(myCustomerProperties);
    }

}
