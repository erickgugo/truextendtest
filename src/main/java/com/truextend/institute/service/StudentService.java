package com.truextend.institute.service;

import com.truextend.institute.entity.Class;
import com.truextend.institute.entity.Student;
import com.truextend.institute.repository.ClassRepository;
import com.truextend.institute.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    public List<Student> getClassesByStudent(Long student_id) {
        return studentRepository.getClassesByStudent(student_id);
    }

    public Student getById(Long student_id) {
        return studentRepository.findById(student_id).get();
    }

    public Student save(Student student) {
        return studentRepository.save(student);
    }

    public boolean delete(Student student) {
        try {
            studentRepository.delete(student);
            return true;
        } catch (Exception e) {
            //** TODO, ADD LOGGER
        }
        return false;
    }
}
