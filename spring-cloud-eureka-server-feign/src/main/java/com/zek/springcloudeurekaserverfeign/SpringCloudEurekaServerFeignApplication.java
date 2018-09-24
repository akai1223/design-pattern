package com.zek.springcloudeurekaserverfeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringCloudEurekaServerFeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudEurekaServerFeignApplication.class, args);
	}
}
