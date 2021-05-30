package com.example.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example")
public class SpringDemoApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(SpringDemoApplication.class, args);
	}

}
