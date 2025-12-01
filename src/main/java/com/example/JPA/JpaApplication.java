package com.example.JPA;

import model.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Optional;

@SpringBootApplication
@EntityScan(basePackages = "model")
@ComponentScan(basePackages = {"com.example.JPA", "model"})
@EnableJpaRepositories(basePackages = "com.example.JPA")
public class JpaApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(JpaApplication.class, args);

        StudentRepo repo = context.getBean(StudentRepo.class);

        Student s1 = context.getBean(Student.class);
        Student s2 = context.getBean(Student.class);
        Student s3 = context.getBean(Student.class);

//        s1.setName("Shiva");
//        s1.setRollNo(1);
//        s1.setMarks(99);
//
//        s2.setName("OM BABA");
//        s2.setRollNo(2);
//        s2.setMarks(98);

        s3.setName("Sai");
        s3.setRollNo(3);
//        s3.setMarks(90); // stored as 90 in db
        s3.setMarks(100); // changed to 100 then use repo.save(s3); to update the value


/*
         repo.save(s1);              // hibernate automatically creates tables cz of applicationProps
         repo.save(s2);              // save -> insert data into table
         repo.save(s3);
 */

/*      Fetch all data
        System.out.println(repo.findAll());   //prints all the data in console
*/
//        Optional <Student> s = repo.findById(3);  // finds the row by id
//        System.out.println(s.orElse(new Student()));

        //System.out.println("FIND BY PROPERTIES - " + repo.findByName("sai"));

        repo.save(s3); // updating s3 after changing from 90 to 100

        repo.delete(s3); // delete data

    }
}
