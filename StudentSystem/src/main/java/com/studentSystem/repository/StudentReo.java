package com.studentSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studentSystem.entity.StudentEntity;

@Repository
public interface StudentReo extends JpaRepository<StudentEntity, Integer> {

}
