package com.example.demo.controller;

import com.example.demo.entities.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.function.Supplier;
import java.util.stream.Stream;


@RestController
@RequestMapping("api/v1/students")
public class StudentController {

    Supplier< Stream<Student>> STUDENTS = () -> Stream.of(
            new Student(1, "James Bond"),
            new Student(2, "Maria Jones"),
            new Student(3, "Anna Smith"),
            new Student(4, "Adam Smith") );


    @GetMapping(path = "{studentId}")
    public Student getStudent(@PathVariable("studentId") Integer studentId) {
        return STUDENTS.get().filter(x-> x.getStudentId().equals(studentId)).findFirst()
                .orElseThrow(()-> new IllegalStateException("Student" + studentId + "does not exists"));
    }

}
