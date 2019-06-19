package com.cai.springkafkarun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@ComponentScan("com.*****")
@SpringBootApplication
@EnableScheduling
@EnableAsync
public class SpringKafkaRunApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringKafkaRunApplication.class, args);
	}

}
