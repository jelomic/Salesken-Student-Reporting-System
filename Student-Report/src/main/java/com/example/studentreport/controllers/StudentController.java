package com.example.studentreport.controllers;

import com.example.studentreport.model.*;
import com.example.studentreport.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentService service;

    @GetMapping("/index")
    public List<StudentData> index(){
        return service.getAllData();
    }

    @GetMapping("/student/all")
    public List<Student> getAllStudents(){
        return service.getAllStudents();
    }

    @GetMapping("/students")
    public String listStudents(Model model){
        model.addAttribute("students", service.getAllStudents());
        return "students";
    }
    @GetMapping("/students/marks")
    public String listStudentsData(Model model){
        model.addAttribute("studentsMarks", service.getAllData());
        return "studentsMarks";
    }

    @GetMapping("/students/reports")
    public String listReports(Model model){
        //model.addAttribute("studentsMarks", service.getAllData());
        return "reports";
    }

   
    @GetMapping("/students/new")
    public String createStudentForm(Model model){
        // creating empty student object to hold student form data
        Student student = new Student();
        model.addAttribute("student",student);
        return "create_student";
    }

    @GetMapping("/students/marks/new")
    public String createStudentMarksForm(Model model){
        // creating empty student object to hold student form data
        StudentData studentmarks = new StudentData();
        model.addAttribute("studentmarks",studentmarks);
        return "input-marks";
    }

    @PostMapping("/students/marks")
    public String saveStudentData(@ModelAttribute("studentmarks") StudentData studentmarks){
        service.saveStudentData(studentmarks);
        return "redirect:/students/marks";
    }

    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student){
        service.saveStudent(student);
        return "redirect:/students";
    }


    @GetMapping("/student")
    public Student getStudent(@RequestParam Integer id){
        return service.getStudentById(id);
    }

    @GetMapping("/student/{id}")
    public StudentAverageResponse getStudentData(@PathVariable Integer id){
        return service.getStudentDataById(id);
    }

    @GetMapping("/semester/{id}")
    public SemesterAverageResponse getSemesterData(@PathVariable Integer id){
        return service.getSemesterDataById(id);
    }
@GetMapping("/semester/top/{id}")
public TopTwoStudentsResponse getTopTwoStudentsForSemester(@PathVariable Integer id){
    return service.getTopTwoStudentsForSemester(id);
}

    @GetMapping("/student/delete-all")
    public void deleteAll(){
        service.deleteAllStudents();
    }
}


