package com.cloudfly.springboot.crud.config;

import com.cloudfly.springboot.crud.utils.IdWorker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author CloudFly
 */
@Configuration
public class Config {
	@Bean
	public IdWorker idWorker() {
		return new IdWorker();
	}
}
