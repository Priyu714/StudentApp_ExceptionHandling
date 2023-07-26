package com.example.studentapp.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {

  @Id
  private Integer id;
  private String firstname;
  private String lastname;
  private Double age;
  private Double marks;

}
