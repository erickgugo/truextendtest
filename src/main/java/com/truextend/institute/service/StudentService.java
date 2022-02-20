package com.truextend.institute.service;

import com.truextend.institute.entity.Student;
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

    public Student getById(Long id) {
        return studentRepository.findById(id).get();
    }

    /**
     * Method used to save and merge Students
     * @param student
     * @return Student
     */
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
