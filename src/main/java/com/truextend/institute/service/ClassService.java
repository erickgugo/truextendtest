package com.truextend.institute.service;

import com.truextend.institute.entity.Class;
import com.truextend.institute.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassService {

    @Autowired
    private ClassRepository classRepository;

    public List<Class> getAll() {
        return classRepository.findAll();
    }

    public Class getById(Long id) {
        return classRepository.findById(id).get();
    }

    /**
     * Method used to save and merge Students
     * @param newClass
     * @return class
     */
    public Class save(Class newClass) {
        return classRepository.save(newClass);
    }

    public boolean delete(Class delClass) {
        try {
            classRepository.delete(delClass);
            return true;
        } catch (Exception e) {
            //** TODO, ADD LOGGER
        }
        return false;
    }
}
