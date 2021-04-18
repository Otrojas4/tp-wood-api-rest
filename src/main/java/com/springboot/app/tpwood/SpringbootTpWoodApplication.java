package com.springboot.app.tpwood;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class SpringbootTpWoodApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootTpWoodApplication.class, args);
	}

}
