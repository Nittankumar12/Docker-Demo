package com.Railworld.DockerDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentRepository studentRepository;
    @GetMapping("/getStudents")
    public List<Student> getStudents(){
        return studentRepository.findAll();
    }
}

