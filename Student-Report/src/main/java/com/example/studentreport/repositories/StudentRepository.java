package com.example.studentreport.repositories;

import com.example.studentreport.model.Student;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.JpaRepository;

@Scope("singleton")
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
