package com.zek.mongodbdemo;

import com.alibaba.fastjson.JSON;
import com.zek.mongodbdemo.domain.User;
import com.zek.mongodbdemo.service.MongoDbServiceDemo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MongodbDemoApplicationTests {

	@Autowired
	private MongoDbServiceDemo mongoDbServiceDemo;

	@Before
	public void contextLoads() {

		System.out.println("before contextLoads ------------");

	}

	@Test
	public void test1() {
		System.out.println(JSON.toJSONString(mongoDbServiceDemo.findAll()));
	}

	@Test
	public void testInsert() {
		User user = new User();
		user.setName("test2");
		user.setAge(20);
		mongoDbServiceDemo.save(user);

	}

	@Test
	public void testQuery() {
		System.out.println(JSON.toJSONString(mongoDbServiceDemo.query("test2")));
	}

	@Test
	public void testUpdate() {

		List<User> userList = mongoDbServiceDemo.query("test2");
		userList.stream().forEach((user) -> {
			user.setAge(22);
			mongoDbServiceDemo.update(user);
		});

	}

	@Test
	public void testDelete() {
		List<User> userList = mongoDbServiceDemo.query("test2");
		userList.stream().forEach((user) -> mongoDbServiceDemo.delete(user.getName()));
	}

}
