package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.demo.dao.UserRepository;
import com.example.demo.entities.User;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class SpringBootJpaExampleApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBootJpaExampleApplication.class, args);

		UserRepository userRepository = context.getBean(UserRepository.class);

		// Single user Data Save
		
		/*
		 * User usr1=new User("Duresh Kumar","MCA"); User usr=userRepository.save(usr1);
		System.out.println(usr);
		*/
		
		/*
		 * //Multiple user Save Data /* User user1=new User(); User user2=new User();
		 * User user3=new User();
		 * 
		 * user1.setName("Adity Kumar"); user1.setCourse("BCA");
		 * 
		 * user2.setName("Mohan Kumar"); user2.setCourse("Bsc.It");
		 * 
		 * user3.setName("Sonu Kumar"); user3.setCourse("Prince");
		 * 
		 * List<User> users=List.of(user1,user2,user3);//
		 * 
		 * //Save multiple object Iterable<User> result=userRepository.saveAll(users);
		 * result.forEach(user->{ System.out.println(user); });
		 * System.out.println("Done");
		 */

		// Update Data
		/*try {
			Optional<User> opt = userRepository.findById(4);// where 4 is a User Id on your databases
			User usr = opt.get();
			usr.setName("Ramesh");
			User usr2 = userRepository.save(usr);
			System.out.println("Data Update" + usr2);
		} catch (Exception e) {
			System.out.println("Sorry Data is not there on your Database");
		}
		*/
		
		//Get All Data from the database
//		Iterable<User> itr=userRepository.findAll();
//		itr.forEach(user->{System.out.println(user);});
		
		//Delete the data form the Databases
	/*	try {
		userRepository.deleteById(6);
		System.out.println("Delete Data Successfully");
		}catch (Exception e) {
			System.out.println("Sorry Data is not there on your Database ");
		}
		*/
		
		//fetch all the data with the help of name
//		List<User> usr=userRepository.findByName("Durgesh");
//		usr.forEach(user->System.out.println(user));
		
		//fetch all data those are belong to BCA background
//		List<User> usr=userRepository.findByCourse("BCA");
//		usr.forEach(user->System.out.println(user));
		
		//Get All Data
//		List<User> allUser=userRepository.getAllUser();
//		allUser.forEach(e->System.out.println(e));
		
//		List<User> user=userRepository.getUserByName("durgesh");
//		user.forEach(e->System.out.println(e));
		
//		List<User> user=userRepository.getUserByNameWithCourse("Durgesh","BCA");
//		user.forEach(e->System.out.println(e));
		
		List<User> user=userRepository.getUser();
		user.forEach(e->System.out.println(e));
	}

}
