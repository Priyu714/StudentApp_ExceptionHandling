package com.example.studentapp.controller;

import com.example.studentapp.Entity.Student;
import com.example.studentapp.sevice.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("studentApp")
public class StudentController {

  @Autowired
  StudentService studentService;

  @PostMapping
  public Student createStudent(@RequestBody Student student) {
    return studentService.createStudent(student);
  }

  @GetMapping("/{id}")
  public Student getStudentById(@PathVariable int id) {
    return studentService.getStudentById(id);
  }

  @PutMapping("/{id}")
  public Student updateStudent(@PathVariable int id, @RequestBody Student student) {
    return studentService.updateStudentDetails(id,student);
  }

  @DeleteMapping("/{id}")
  public void deleteStudent(@PathVariable int id) {
    studentService.deleteById(id);
  }

}
