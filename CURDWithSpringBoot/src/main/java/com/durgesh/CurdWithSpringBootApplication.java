package com.durgesh;

import java.applet.AppletContext;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.durgesh.dao.UserRepository;
import com.durgesh.entities.Student;

@SpringBootApplication
public class CurdWithSpringBootApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(CurdWithSpringBootApplication.class, args);

		UserRepository userRepository = context.getBean(UserRepository.class);

		Student s1 = new Student(1, "Durgesh", "MCA", "Patna");
		Student s2 = new Student(2, "Prince", "B.tech", "Bangalore");
		Student s3 = new Student(3, "Nandani", "MCA", "UP");
		Student s4 = new Student(4, "Ayush", "B.Tech", "Delhi");

		// saving single user
		// userRepository.save(s1);

		// Saving multiple user
		List<Student> list = List.of(s1, s2, s3, s4);
		 userRepository.saveAll(list);

//		System.out.println("_____________________Fetch value By Id__________________________");
//		Optional<Student> s = userRepository.findById(1);
//		System.out.println(s);

//		System.out.println("_____________________Fetch All Details __________________________");
//		Iterable<Student> studentValue = userRepository.findAll();
//		for (Student s5 : studentValue) {
//			System.out.println(s5);
//		}

		// delete by id
//		userRepository.deleteById(3);

		// Delete All Delete
//		userRepository.deleteAll();

		// Update Value By id
//		Optional<Student> s = userRepository.findById(2);
//		Student updateValue=s.get();
//		updateValue.setName("Divesh");
//		userRepository.save(updateValue);

		System.out.println("_____________________Fetch All Details 2nd Way__________________________");
		Iterable<Student> studentValue2 = userRepository.findAll();
		studentValue2.forEach(value -> System.out.println(value));

	}

}
