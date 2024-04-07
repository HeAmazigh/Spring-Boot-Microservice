package com.amazigh.school.service;

import com.amazigh.school.DTO.FullSchoolResponse;
import com.amazigh.school.domain.School;
import com.amazigh.school.feignClient.StudentClient;
import com.amazigh.school.repository.SchoolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolService {
  private final SchoolRepository schoolRepository;
  private final StudentClient client;

  public void saveSchool(School school) {
    schoolRepository.save(school);
  }

  public List<School> findAllSchools() {
    return schoolRepository.findAll();
  }

  public FullSchoolResponse findSchoolsWithStudents(Integer schoolId) {
    School school = schoolRepository.findById(schoolId).orElse(
        School.builder()
            .name("NOT_FOUND")
            .email("NOT_FOUND")
            .build()
    );
    var students = client.findAllStudentsBySchool(schoolId);
    return FullSchoolResponse.builder()
        .name(school.getName())
        .email(school.getEmail())
        .students(students)
        .build();
  }
}
