package com.zek.spring.cloud.feign.api.service;

import com.zek.spring.cloud.feign.api.domain.Person;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

/**
 * @Description 声明强类型接口
 * @Auther zhangkai
 * @DateTime 2018/9/24 下午7:25
 */
@FeignClient("person-service")
@RequestMapping("/provider")
public interface PersonService {

    @PostMapping(value = "/person/save")
    boolean save(@RequestBody Person person);


    @GetMapping(value = "/person/find/all")
    Collection<Person> findAll();
}
