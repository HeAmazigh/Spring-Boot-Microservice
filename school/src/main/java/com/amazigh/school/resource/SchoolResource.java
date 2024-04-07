package com.amazigh.school.resource;

import com.amazigh.school.DTO.FullSchoolResponse;
import com.amazigh.school.domain.School;
import com.amazigh.school.service.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/schools")
@RequiredArgsConstructor
public class SchoolResource {
  private final SchoolService schoolService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public void save(@RequestBody School school) {
    schoolService.saveSchool(school);
  }

  @GetMapping
  public ResponseEntity<List<School>> findAllSchools() {
    return ResponseEntity.ok(schoolService.findAllSchools());
  }

  @GetMapping("/with-students/{schoolId}")
  public ResponseEntity<FullSchoolResponse> findAllStudentsBySchoolId(@PathVariable Integer schoolId) {
    return ResponseEntity.ok(schoolService.findSchoolsWithStudents(schoolId));
  }
}
