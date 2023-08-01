package net.javaguides.springboot.controller;

import net.javaguides.springboot.model.Courses;
import net.javaguides.springboot.service.CoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/courses")
public class CoursesController {

    @Autowired
    private CoursesService coursesService;

    @GetMapping
    public ResponseEntity<List<Courses>> getAllCourses(){
        return ResponseEntity.ok(coursesService.getAllCourses());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Courses>> getCourseById(@PathVariable Long id) {
        return ResponseEntity.ok(coursesService.getCourseById(id));
    }
}
