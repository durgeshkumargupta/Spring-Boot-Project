package com.durgesh;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class Config {
	
	@Bean
	public Student durgeshStudent()
	{
		return new Student("Durgesh","MCA");
	}
	
	@Bean
	@Primary
	public Student princeStudent()
	{
		return new Student("Prince","MCA");
	}

}
