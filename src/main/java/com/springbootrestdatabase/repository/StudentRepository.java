package com.springbootrestdatabase.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootrestdatabase.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
