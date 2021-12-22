package com.durgesh;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class TestClass
{
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.durgesh");
		context.refresh();
		
		Student s=context.getBean(Student.class);
		s.setUsn("1RV20MC015");
		s.setName("Prince");
		s.setCollege_name("RVCE");
		s.setDept("MCA");
		System.out.println(s);
		
	}

}
