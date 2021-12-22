package com.durgesh;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestClass {

	public static void main(String[] args) {
	
		
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.durgesh");
		context.refresh();
		Service service=context.getBean(Service.class);
		
		service.display();
	}
}
