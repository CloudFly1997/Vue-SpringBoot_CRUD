package com.cloudfly.springboot.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
public class SpringbootCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootCrudApplication.class, args);
	}

}
