package com.example.demo.Controller;

import com.example.demo.Entity.StudentEntity;
import com.example.demo.Service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<StudentEntity> createStudent(@RequestBody StudentEntity student){
        System.out.println("Entering Controller");
        StudentEntity studentObj = studentService.createStudent(student);

        System.out.println("Exiting Controller");
        return ResponseEntity.status(HttpStatus.OK).body(studentObj);
    }

    @GetMapping("/{i}")
    public ResponseEntity<StudentEntity> getStudent(@PathVariable Long id){
        StudentEntity studentServiceobj = studentService.getStudent(id);

        return ResponseEntity.status(HttpStatus.OK).body(studentServiceobj);
    }

    @GetMapping
    public ResponseEntity< List<StudentEntity>> getAllStudent(){
        System.out.println("Entering Controller");
        List<StudentEntity> studentObj = studentService.getAlltudent();

        System.out.println("Exiting Controller");
        return ResponseEntity.status(HttpStatus.OK).body(studentObj);
    }

    @PutMapping
    public ResponseEntity<StudentEntity> updateStudent(@RequestParam Long id,@RequestBody StudentEntity student){
        StudentEntity studentServiceobj = studentService.updateStudent(id,student);

        return ResponseEntity.status(HttpStatus.OK).body(studentServiceobj);
    }


}
