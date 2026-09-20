package com.example.demo.Service;

import com.example.demo.Entity.StudentEntity;
import com.example.demo.Repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private StudentRepository repository;

    public StudentService(StudentRepository repository){
        this.repository = repository;
    }
    public StudentEntity createStudent(StudentEntity student){
        System.out.println("Entering Service");
        StudentEntity studentEntity = repository.save(student);
        System.out.println("Exiting Service");
        return studentEntity;
    }

    public StudentEntity getStudent(Long id){
        Optional<StudentEntity> foundstudent = repository.findById(id);
        return foundstudent.get();
    }

    public List<StudentEntity> getAlltudent(){
        System.out.println("Entering Service");
        List<StudentEntity>studentEntity = repository.findAll();
        System.out.println("Exiting Service");
        return studentEntity;
    }

    public StudentEntity updateStudent(Long id,StudentEntity student){
        Optional<StudentEntity> foundstudent = repository.findById(id);

        StudentEntity savestudent = foundstudent.get();
        savestudent.setName(student.getName());
        savestudent.setName(student.getName());
        savestudent.setName(student.getName());
        savestudent.setName(student.getName());

        return savestudent;

    }
}
