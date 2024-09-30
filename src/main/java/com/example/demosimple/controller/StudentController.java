package com.example.demosimple.controller;

import com.example.demosimple.dto.StudentDto;
import com.example.demosimple.entity.Student;
import com.example.demosimple.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/create")
    public ResponseEntity<Student> addStudent(@RequestBody StudentDto dto) {
        Student student = studentService.createStudent(dto);
        return ResponseEntity.ok(student);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        Student student = studentService.getStudentById(id);
        return ResponseEntity.ok(student);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Student> update(@RequestBody StudentDto student, @PathVariable("id") Long id) {
        Student result = studentService.updateStudent(student, id);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteId(@PathVariable Long id) {
        studentService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/deleteAll")
    // atay ? oldm
    public ResponseEntity<?> deleteAllStudents() {
        studentService.deleteAll();
        return ResponseEntity.ok().build();
    }
}
