package com.example.studentreport;

import com.example.studentreport.model.Student;
import com.example.studentreport.model.StudentData;
import com.example.studentreport.repositories.StudentDataRepository;
import com.example.studentreport.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentReportApplication implements CommandLineRunner{

    public static void main(String[] args) {
        SpringApplication.run(StudentReportApplication.class, args);
    }

    @Autowired
    private StudentRepository studentRepository;

	@Autowired
	private StudentDataRepository studentDataRepository;

    @Override
    public void run(String... args) throws Exception {
		Student student = new Student();
		student.setId(1);
		student.setFirstName("Ramesh");
		student.setLastName("Fadatare");
		student.setEmailId("ramesh@gmail.com");
		studentRepository.save(student);

		StudentData data1 = new StudentData(1, 1, 20, 30 ,40);
		StudentData data2 = new StudentData(1,2,40,50,60);

		studentDataRepository.save(data1);
		studentDataRepository.save(data2);

		Student student1 = new Student();
		student1.setId(2);
		student1.setFirstName("John");
		student1.setLastName("Cena");
		student1.setEmailId("cena@gmail.com");
		studentRepository.save(student1);

		StudentData data3 = new StudentData(2, 1, 70, 30 ,40);
		StudentData data4 = new StudentData(2,2,80,50,60);

		studentDataRepository.save(data3);
		studentDataRepository.save(data4);
    }

}
