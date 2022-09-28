package com.example.studentreport.repositories;

import com.example.studentreport.model.CompositeKey;
import com.example.studentreport.model.StudentData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentDataRepository extends JpaRepository<StudentData, CompositeKey>, JpaSpecificationExecutor<StudentData> {

    @Query(value = "SELECT * FROM data WHERE id = :id", nativeQuery = true)
    List<StudentData> findStudentDataByStudentId(@Param("id") Integer id);

    @Query(value = "SELECT * FROM data WHERE semester = :semester", nativeQuery = true)
    List<StudentData> findSemesterDataBySemId(@Param("semester") Integer semester);





}