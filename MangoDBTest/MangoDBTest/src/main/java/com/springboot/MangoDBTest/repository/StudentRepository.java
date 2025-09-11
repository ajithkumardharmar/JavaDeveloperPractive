package com.springboot.MangoDBTest.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.springboot.MangoDBTest.model.Student;

import java.util.List;

public interface StudentRepository extends MongoRepository<Student, String> {
    List<Student> findByName(String name);
}

