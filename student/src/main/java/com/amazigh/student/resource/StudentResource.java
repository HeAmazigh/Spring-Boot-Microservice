package com.amazigh.student.resource;

import com.amazigh.student.domain.Student;
import com.amazigh.student.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/students")
@RequiredArgsConstructor
public class StudentResource {

  private final StudentService studentService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public void save(@RequestBody Student student) {
    studentService.saveStudent(student);
  }

  @GetMapping
  public ResponseEntity<List<Student>> findAllStudents() {
    return ResponseEntity.ok(studentService.findAllStudents());
  }

  @GetMapping("/school/{schoolId}")
  public ResponseEntity<List<Student>> findAllStudents(@PathVariable Integer schoolId) {
    return ResponseEntity.ok(studentService.findAllStudentsBySchool(schoolId));
  }
}
