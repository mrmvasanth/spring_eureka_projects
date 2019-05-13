package com.student.student_microservice.Repository;

import com.student.student_microservice.Entity.Student;
import com.student.student_microservice.model.StudentInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentInfo,Long> {
}
