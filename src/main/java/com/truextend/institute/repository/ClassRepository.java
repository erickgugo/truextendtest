package com.truextend.institute.repository;

import com.truextend.institute.entity.Class;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClassRepository extends JpaRepository<Class, Long> {

    @Query("SELECT a FROM Class a ")
    List<Class> getAllClasses();

    @Query("SELECT a FROM Class a JOIN FETCH a.students b WHERE a.code = ?1")
    List<Class> getStudentsByClass(Long code);

}
