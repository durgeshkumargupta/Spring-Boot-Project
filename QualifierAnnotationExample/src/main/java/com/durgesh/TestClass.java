package com.durgesh;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestClass {

	public static void main(String[] args) {
	
		
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.durgesh");
		context.refresh();
		ServiceClass service=context.getBean(ServiceClass.class);
		
		service.display();
	}
}
