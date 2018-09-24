package com.zek.spring.cloud.feign.client.web;

import com.zek.spring.cloud.feign.api.domain.Person;
import com.zek.spring.cloud.feign.api.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * @Description
 * @Auther zhangkai
 * @DateTime 2018/9/24 下午7:35
 */
@RestController
public class PersonClientController implements PersonService{

    private final PersonService personService;

    @Autowired
    public PersonClientController(PersonService personService){
        this.personService = personService;
    }

    @Override
    public boolean save(Person person) {
        return personService.save(person);
    }

    @Override
    public Collection<Person> findAll() {
        return personService.findAll();
    }
}
