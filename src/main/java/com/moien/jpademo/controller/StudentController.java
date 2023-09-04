package com.moien.jpademo.controller;

import com.moien.jpademo.model.Student;
import com.moien.jpademo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public ResponseEntity<List<Student>> listCourses(Model model) {
        List<Student> students = studentService.getAllStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @PostMapping("/students/create")
    public ResponseEntity<Void> createStudent(@RequestBody Student student) {
        studentService.createStudent(student);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<Void> updateStudent(@RequestBody Student student, @PathVariable Long id) {
        studentService.updateStudent(id,student);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}