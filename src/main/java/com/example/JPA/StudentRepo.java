package com.example.JPA;

import model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.util.List;

//JpaRepo extends crud operations so we have crud operations in JpaRepo
@Component
public interface StudentRepo extends JpaRepository<Student,Integer> {
//
    @Query("select s from Student as s where s.name = ?1")  // jpql query user to search by properties of an object it takes a class name and its property to search
    List<Student> findByName (String name);
}
