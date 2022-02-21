package com.truextend.institute.repository;

import com.truextend.institute.entity.Class;
import com.truextend.institute.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("SELECT a FROM Student a JOIN FETCH a.classes b WHERE a.student_id = ?1")
    List<Student> getClassesByStudent(Long student_id);
}
