package com.project.relife;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class RelifeApplication {

	public static void main(String[] args) {
		SpringApplication.run(RelifeApplication.class, args);
	}

}
