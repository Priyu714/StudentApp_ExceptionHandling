package com.example.studentapp.sevice;

import com.example.studentapp.Entity.Student;
import com.example.studentapp.Repo.StudentRepo;
import java.util.List;
import java.util.Optional;

import com.example.studentapp.exception.StudentNotFoundException;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class StudentService {

  @Autowired
  StudentRepo studentRepo;

  public List<Student> getAllStudent(){
    return studentRepo.findAll();
  }

  public Student getStudentById(int id ){
    return studentRepo.findById(id).
            orElseThrow(() -> new StudentNotFoundException("Student with id " + id + " not found"));
  }

  public Student createStudent(Student student){
    return studentRepo.save(student);
  }

  public Student updateStudentDetails( int id, Student student) {
    Optional<Student> existStudent = studentRepo.findById(id);
    if(!existStudent.isPresent()){
      throw new StudentNotFoundException("Student with id " +id + " not found.");
    }
    Student updateStudent = existStudent.get();
    updateStudent.setFirstname(student.getFirstname());
    updateStudent.setLastname(student.getLastname());
    updateStudent.setAge(student.getAge());
    updateStudent.setMarks(student.getMarks());
    return studentRepo.save(student);
  }

  public String deleteById(int id){
    if(!studentRepo.existsById(id)){
      throw new StudentNotFoundException("Student with id " +id + " not found.");
    }
    studentRepo.deleteById(id);
    return "Student id deleted successfully.";
  }
}
