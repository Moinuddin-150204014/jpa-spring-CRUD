package com.moien.jpademo.controller;

import com.moien.jpademo.model.Course;
import com.moien.jpademo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping("/courses")
    public ResponseEntity<List<Course>> getAllCourses(Model model) {
        List<Course> courses = courseService.getAllCourses();
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    @PostMapping("/courses/create")
    public ResponseEntity<Void> createCourse(@RequestBody Course course) {
        courseService.createCourse(course);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @PutMapping("/courses/{id}")
    public ResponseEntity<Void> updateCourse(@RequestBody Course course, @PathVariable Long id) {
        courseService.updateCourse(id,course);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @DeleteMapping("/courses/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

}