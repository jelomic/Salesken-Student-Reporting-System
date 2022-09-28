package com.example.studentreport.services;

import com.example.studentreport.model.*;
import com.example.studentreport.repositories.StudentDataRepository;
import com.example.studentreport.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.util.*;

@Scope("singleton")
@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentDataRepository studentDataRepository;

    public Student saveStudent(Student student){
        return studentRepository.save(student);
    }

    public StudentData saveStudentData(StudentData studentmarks){
        return studentDataRepository.save(studentmarks);
    }
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public List<StudentData> getAllData(){
        return studentDataRepository.findAll();
    }

    public Student getStudentById(Integer id){
        return studentRepository.findById(id).orElseThrow();
    }

    public void deleteAllStudents(){
        studentRepository.deleteAll();
    }

    public StudentAverageResponse getStudentDataById(Integer id) {
        List<StudentData> studentDataForAllSems = studentDataRepository.findStudentDataByStudentId(id);
        Student studentDetails = getStudentById(id);
        Integer mathTotal = 0;
        Integer scienceTotal = 0;
        Integer englishTotal = 0;
        Integer totalSems = studentDataForAllSems.size();

        for (StudentData semData:studentDataForAllSems){
            mathTotal += semData.getMaths();
            scienceTotal += semData.getScience();
            englishTotal += semData.getEnglish();
        }
        return new StudentAverageResponse(studentDetails.getFirstName(), studentDetails.getLastName(), mathTotal/totalSems, scienceTotal/totalSems, englishTotal/totalSems);
    }

    public SemesterAverageResponse getSemesterDataById(Integer semId) {
        List<StudentData> semData = studentDataRepository.findSemesterDataBySemId(semId);
        Integer mathTotal = 0;
        Integer scienceTotal = 0;
        Integer englishTotal = 0;
        Integer students = semData.size();

        for (StudentData studentData:semData){
            mathTotal += studentData.getMaths();
            scienceTotal += studentData.getScience();
            englishTotal += studentData.getEnglish();
        }
        return new SemesterAverageResponse(semId, mathTotal/students, scienceTotal/students, englishTotal/students);
    }

    public TopTwoStudentsResponse getTopTwoStudentsForSemester(Integer semId){
        List<StudentData> semData = studentDataRepository.findSemesterDataBySemId(semId);
        List<Pair<Integer, Integer>> studentAverageList = new ArrayList<>();

        semData.forEach(studentData -> studentAverageList.add(Pair.of(studentData.getId(),
                (studentData.getMaths() + studentData.getEnglish() + studentData.getScience())/3)));

        studentAverageList.sort(Comparator.comparing(p -> -p.getSecond()));

        Student topper = getStudentById(studentAverageList.get(0).getFirst());
        Integer topperAvg = studentAverageList.get(0).getSecond();
        Student runnerUp = getStudentById(studentAverageList.get(1).getFirst());
        Integer runnerUpAvg = studentAverageList.get(1).getSecond();

        return new TopTwoStudentsResponse(semId, topper.getFirstName()+" "+topper.getLastName(), topperAvg, runnerUp.getFirstName()+" "+runnerUp.getLastName(), runnerUpAvg);
    }
}
