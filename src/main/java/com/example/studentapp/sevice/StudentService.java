package com.example.studentapp.sevice;

import com.example.studentapp.Entity.Student;
import com.example.studentapp.Repo.StudentRepo;
import java.util.List;
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
    return studentRepo.findById(id).get();
  }

  public Student createStudent(Student student){
    return studentRepo.save(student);
  }

  public Student updateStudentDetails( int id, Student student) {
    return studentRepo.save(student);
  }

  public String deleteById(int id){
    studentRepo.deleteById(id);
    return "Id deleted successfully.";
  }
}
