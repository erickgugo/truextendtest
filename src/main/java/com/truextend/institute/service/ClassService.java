package com.truextend.institute.service;

import com.truextend.institute.entity.Class;
import com.truextend.institute.entity.Student;
import com.truextend.institute.repository.ClassRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ClassService {

    @Autowired
    private ClassRepository classRepository;

    public List<Class> getAll() {
        List<Class> classes = classRepository.getAllClasses();
        // TODO: review JPA SpringBoot problems with fetch LAZY, I'll fixit i promise
        classes.stream().forEach(a -> a.getStudents().clear());
        return classes;
    }

    public List<Class> getStudentsByClass(Long codeClass) {
        List<Class> list = classRepository.getStudentsByClass(codeClass);
        for (Class aClass : list) {
            for (Student student : aClass.getStudents()) {
                log.info("============== " + student );
            }
        }
        return list;
    }

    public Class getByCode(Long id) {
        return classRepository.findById(id).get();
    }

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
