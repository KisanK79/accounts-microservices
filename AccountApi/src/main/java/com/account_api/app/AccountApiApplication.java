package com.account_api.app;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class AccountApiApplication {
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	@Bean
	public ExecutorService getExecutorService() {
		return Executors.newFixedThreadPool(4);
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(AccountApiApplication.class, args);
	}

}
