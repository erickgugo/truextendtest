package com.truextend.institute.controller;

import com.truextend.institute.entity.Class;
import com.truextend.institute.entity.Student;
import com.truextend.institute.service.ClassService;
import com.truextend.institute.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/class")
public class ClassController {

    @Autowired
    ClassService classService;

    @Autowired
    StudentService studentService;

    @GetMapping
    public ResponseEntity<List<Class>> getAll() {
        List<Class> classes = classService.getAll();
        if (classes.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(classes);
    }

    @GetMapping("/studentsBy/{code}")
    public ResponseEntity<List<Class>> getClassesByStudent(@PathVariable("code") long code) {
        List<Class> classes = classService.getStudentsByClass(code);
        if (classes.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(classes);
    }

    @GetMapping("/{code}")
    public ResponseEntity<Class> getClass(@PathVariable("code") long code) {
        Class oneClass = classService.getByCode(code);
        if (oneClass == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(oneClass);
    }

    @PostMapping
    public ResponseEntity<Class> save(@RequestBody Class newClass) {
        Class oneClass = classService.save(newClass);
        return ResponseEntity.ok(oneClass);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Class> delete(@PathVariable("id") long id) {
        Class delClass = classService.getByCode(id);
        boolean ok = classService.delete(delClass);
        if (delClass != null && ok)
            return ResponseEntity.ok(delClass);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{code}/student/{studentId}")
    public ResponseEntity<Class> enrollStudent(@PathVariable("code") Long code, @PathVariable("studentId") Long studentId) {
        Class oneClass = classService.getByCode(code);
        Student oneStudent = studentService.getById(studentId);

        oneClass.enrollStudent(oneStudent);
        Class enrolled = classService.save(oneClass);

        return ResponseEntity.ok(enrolled);
    }
}
