package com.durgesh.dao;

import org.springframework.data.repository.CrudRepository;

import com.durgesh.entities.Student;

public interface UserRepository extends CrudRepository<Student, Integer> {

}
