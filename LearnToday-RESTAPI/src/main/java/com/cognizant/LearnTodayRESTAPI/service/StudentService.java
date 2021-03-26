package com.cognizant.LearnTodayRESTAPI.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.LearnTodayRESTAPI.dao.StudentDao;
import com.cognizant.LearnTodayRESTAPI.exception.StudentNotFoundException;
import com.cognizant.LearnTodayRESTAPI.model.Student;

@Service
public class StudentService {

	@Autowired
	private StudentDao studentDAO;

	public boolean saveStudent(Student s) {
		return studentDAO.saveStudent(s);
	}

	public boolean deleteStudent(int id) throws StudentNotFoundException {
		return studentDAO.deleteStudent(id);
	}

}