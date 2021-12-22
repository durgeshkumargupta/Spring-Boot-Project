package com.durgesh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.durgesh.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
