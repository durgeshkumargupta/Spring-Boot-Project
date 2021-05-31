package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.demo.dao.UserRepository;
import com.example.demo.entities.User;

@SpringBootApplication
public class SpringBootJpaExampleApplication {

	public static void main(String[] args) {
	ApplicationContext	context=SpringApplication.run(SpringBootJpaExampleApplication.class, args);
	
	UserRepository userRepository=context.getBean(UserRepository.class);
	
	User user=new User("Duresh Kumar","MCA");
	User usr=userRepository.save(user);
	System.out.println(usr);
	
	}

}
