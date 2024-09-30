package com.example.demosimple.service;

import com.example.demosimple.dto.StudentDto;
import com.example.demosimple.entity.Book;
import com.example.demosimple.entity.Student;
import com.example.demosimple.reposotory.BookRepo;
import com.example.demosimple.reposotory.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private BookRepo bookRepo;

    public Student createStudent(StudentDto dto) {
        Student student = new Student();
        List<Book> allById = bookRepo.findAllById(dto.getItem().getBookId());

        student.setName(dto.getName());
        student.setBook(allById);
        studentRepo.save(student);
        return student;
    }

    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    public Student getStudentById(Long id) {
        return studentRepo.findById(id).orElse(null);
    }

    public Student updateStudent(StudentDto studentDto, Long id) {
        Student result = studentRepo.findById(id).orElse(null);
        result.setName(studentDto.getName());
        return studentRepo.save(result);
    }

    public void deleteById(Long id) {
        studentRepo.deleteById(id);
    }

    public void deleteAll() {
        studentRepo.deleteAll();
    }
}
