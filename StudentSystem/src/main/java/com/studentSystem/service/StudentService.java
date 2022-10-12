package com.studentSystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentSystem.entity.StudentEntity;
import com.studentSystem.repository.StudentReo;

@Service
public class StudentService {
	
	@Autowired
	private StudentReo repo;
	public void AddStudent (StudentEntity s) {
		
		repo.save(s);
	}
	public List<StudentEntity> getAllStudent(){
		
		
		return repo.findAll();
		
	}
	public  StudentEntity getStudentId(int id) {
		
		
	Optional<StudentEntity> s= repo.findById(id);
	if(s.isPresent()) {
		return s.get();
	}
	return null;
	}
	
	public void deleteStu(int id) {
		repo.deleteById(id);
		
	}

}
