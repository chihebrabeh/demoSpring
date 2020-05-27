package com.example.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor
public class Student {
    @Id
    @SequenceGenerator(name = "s_student")
    private  Integer studentId;
    private  String studentName;
}
