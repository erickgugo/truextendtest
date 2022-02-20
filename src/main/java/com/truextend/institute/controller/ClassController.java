package com.truextend.institute.controller;

import com.truextend.institute.entity.Class;
import com.truextend.institute.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/class")
public class ClassController {

    @Autowired
    ClassService classService;

    @GetMapping
    public ResponseEntity<List<Class>> getAll() {
        List<Class> classes = classService.getAll();
        if (classes.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(classes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Class> getUser(@PathVariable("id") long id) {
        Class oneClass = classService.getById(id);
        if (oneClass == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(oneClass);
    }

    @PostMapping
    public ResponseEntity<Class> save(@RequestBody Class newClass) {
        Class oneClass = classService.save(newClass);
        return ResponseEntity.ok(oneClass);
    }
}
