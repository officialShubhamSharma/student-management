package org.test.controller;

import jakarta.validation.Valid;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.test.model.Student;
import org.test.service.StudentService;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/v1/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/get-all")
    public ResponseEntity<List<Student>> getStudents(){
        return ResponseEntity.ok().body(studentService.getAllStudents());
    }

    @GetMapping("/get")
    public ResponseEntity<List<Student>> getStudentByName(@RequestParam String name){
        return ResponseEntity.ok().body(studentService.getAllStudentsByName(name));
    }

    @PutMapping("/update/{phoneNumber}")
    public ResponseEntity updateStudent(@RequestBody Student student, @PathVariable String phoneNumber){
        try{
            studentService.updateStudent(student,phoneNumber);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.status(OK).build();
    }

    @PostMapping("/add")
    public ResponseEntity addStudent(@Valid @RequestBody Student student){
        try{
            studentService.addStudent(student);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.status(CREATED).build();
    }

    @DeleteMapping("/delete/{phoneNumber}")
    public ResponseEntity removeStudent(@PathVariable String phoneNumber){
        try{
            studentService.deleteStudent(phoneNumber);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.status(OK).build();
    }

}
