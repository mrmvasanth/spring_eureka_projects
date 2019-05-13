package com.student.student_microservice.Cotroller;

import com.student.student_microservice.Entity.Student;
import com.student.student_microservice.Repository.StudentRepository;
import com.student.student_microservice.model.StudentInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class StudentServiceController {

    @Autowired
    private StudentRepository studentRepository;

    private static Map<String, List<StudentInfo>> schooDB = new HashMap<String, List<StudentInfo>>();

    @GetMapping(value = "/getStudentDetailsForSchool/{schoolname}")
    public List<StudentInfo> getStudents(@PathVariable String schoolname) {
        return studentRepository.findAll();
    }


    @PostMapping("/addStudent")
    public StudentInfo createNote(@Valid @RequestBody StudentInfo studentInfo) {
        return studentRepository.save(studentInfo);
    }
}