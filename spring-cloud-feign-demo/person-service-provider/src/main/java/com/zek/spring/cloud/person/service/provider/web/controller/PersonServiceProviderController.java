package com.zek.spring.cloud.person.service.provider.web.controller;

import com.zek.spring.cloud.feign.api.domain.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description
 * @Auther zhangkai
 * @DateTime 2018/9/24 下午7:46
 */
@RestController
public class PersonServiceProviderController {

    private Map<Long, Person> persons = new ConcurrentHashMap<>();

    @PostMapping(value = "/person/save")
    public boolean save(@RequestBody Person person){
        return persons.put(person.getId(), person) == null;
    }


    @GetMapping(value = "/person/find/all")
    public Collection<Person> findAll(){
        return persons.values();
    }

}
