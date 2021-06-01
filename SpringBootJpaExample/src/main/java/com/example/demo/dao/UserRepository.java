package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.User;

public interface UserRepository extends CrudRepository<User, Integer>
{
	//Custom find method for fetch the data
	//https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#reference
	List<User> findByName(String name);
	List<User> findByCourse(String course);
	List<User> findByUsn(Integer usn);
	
	List<User> findByNameStartingWith(String prefix);
	List<User> findByNameEndingWith(String suffix);
	List<User> findByNameLike(String likePattern);
	List<User> findByNameOrderByName(String name);
	
	
	//Now we are going to use JPQL Queries.

	//@Query("from User")
	//or
	@Query("select u from User u")
	List<User> getAllUser();
	
	@Query("select u from User u where u.name=:n")
	List<User> getUserByName(@Param("n")String name);
	
	@Query("select u from User u where u.name=:n and u.course=:c")
	List<User> getUserByNameWithCourse(@Param("n")String name,@Param("c") String city);
	
	//Now we are going to use Native or SQL Queries.
	@Query(value="select * from student_info",nativeQuery=true) //where student_info is a table name
	List<User> getUser();
}

