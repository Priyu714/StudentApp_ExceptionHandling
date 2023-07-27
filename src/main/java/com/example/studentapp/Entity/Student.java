package com.example.studentapp.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;
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

  @NotBlank(message = "First name should not be blank")
  private String firstname;

  @NotBlank(message = "Last name should not be blank")
  private String lastname;

  @Min(value = 18,message = "Age Should be greater than and equal to 18.")
  private Double age;
  private Double marks;

}
