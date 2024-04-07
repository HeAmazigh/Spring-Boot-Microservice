package com.amazigh.school.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {
  private String firstname;
  private String lastname;
  private String email;
  private Integer schoolId;
}
