package com.sms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.entity.Student;
import com.sms.exceptionhandler.ResourceNotFoundException;
import com.sms.repo.DaoRepo;

@Service
public class StudentService implements IStudentService {

	@Autowired
	DaoRepo daoRepo;

	@Override
	public Integer saveStudent(Student student) {
		Student saveStudent = daoRepo.save(student);
		return saveStudent.getId();
	}

	@Override
	public List<Student> getAllStudents() {
		return daoRepo.findAll();
	}

	@Override
	public Optional<Student> getStudent(Integer id) {
		return daoRepo.findById(id);
	}

	@Override
	public Student updateStudent(Student student, Integer id) {
		// first we will check if the student exists by the given id or not 
		Student existingStudent = daoRepo.findById(id).orElseThrow(
				()-> new ResourceNotFoundException("Student", "id", id));
		//
		//
		//
		//
		// we will update with the new values that we have 
		daoRepo.save(existingEmployee);
		return existingEmployee;
	}

	@Override
	public void deleteStudent(Integer id) {
		daoRepo.deleteById(id);
	}
	
	

}
