package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@SpringBootApplication
@RestController
@EnableDiscoveryClient

public class StudentApp {
    Student stu = new Student();

    public static void main(String[] args) {
        SpringApplication.run(StudentApp.class, args);
    }

    @RequestMapping(value = "/v1/student/{id}")
    public Student get(@PathVariable int id){
        stu.setName("Gam"); stu.setId(id);
        return stu;
    }



}
