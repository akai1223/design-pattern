package com.zek.mongodbdemo;

import com.alibaba.fastjson.JSON;
import com.zek.mongodbdemo.service.MongoDbServiceDemo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MongodbDemoApplicationTests {

	@Autowired
	private MongoDbServiceDemo mongoDbServiceDemo;

	@Test
	public void contextLoads() {

		System.out.println(JSON.toJSONString(mongoDbServiceDemo.findAll()));
	}

}
