package com.zek.spring.cloud.feign.client.web;

import com.zek.spring.cloud.feign.api.domain.Person;
import com.zek.spring.cloud.feign.api.service.PersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Collection;

/**
 * @Description
 * @Auther zhangkai
 * @DateTime 2018/9/24 下午7:35
 */
@RestController
@RequestMapping("/person")
public class PersonClientController {

    @Resource
    private PersonService personService;

    @PostMapping("/save")
    public boolean save(@RequestBody Person person) {
        return personService.save(person);
    }

    @GetMapping("/find/all")
    public Collection<Person> findAll() {
        return personService.findAll();
    }
}
