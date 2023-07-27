package com.example.studentapp.controller;

import com.example.studentapp.Entity.Student;
import com.example.studentapp.exception.StudentNotFoundException;
import com.example.studentapp.sevice.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("studentApp")
public class StudentController {

  @Autowired
  StudentService studentService;

  @PostMapping
  public ResponseEntity<Student> createStudent(@Valid @RequestBody Student student) {
      Student createdStudent = studentService.createStudent(student);

    return new ResponseEntity<Student>(createdStudent, HttpStatus.CREATED);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Student> getStudentById(@PathVariable int id) {
    Student student =studentService.getStudentById(id);
    return ResponseEntity.ok(student);
  }

  @GetMapping
  public ResponseEntity<List<Student>> getAllstudentDetails(){
    List<Student> students = studentService.getAllStudent();
    return ResponseEntity.ok(students);
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> updateStudent(@PathVariable int id, @RequestBody Student student) {
    Student updatedStudent= studentService.updateStudentDetails(id,student);
    return ResponseEntity.ok(updatedStudent);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteStudent(@PathVariable int id) {
    String message = studentService.deleteById(id);
    return ResponseEntity.ok(message);
  }

  @ExceptionHandler(StudentNotFoundException.class)
  public ResponseEntity<String> handleStudentNotFound(StudentNotFoundException e){
    return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
  }

}
