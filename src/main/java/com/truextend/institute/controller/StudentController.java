package com.truextend.institute.controller;

import com.truextend.institute.entity.Student;
import com.truextend.institute.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping
    public ResponseEntity<List<Student>> getAll() {
        List<Student> students = studentService.getAll();
        if (students.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(students);
    }

    @GetMapping("classesBy/{studentId}")
    public ResponseEntity<List<Student>> getClassesByStudent(@PathVariable("studentId") long studentId) {
        List<Student> students = studentService.getClassesByStudent(studentId);
        if (students.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(students);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getUser(@PathVariable("id") long id) {
        Student student = studentService.getById(id);
        if (student == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(student);
    }

    @PostMapping
    public ResponseEntity<Student> save(@RequestBody Student student) {
        Student studentNew = studentService.save(student);
        return ResponseEntity.ok(studentNew);
    }
}
