package com.cognizant.LearnTodayRESTAPI.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.LearnTodayRESTAPI.dao.CourseDao;
import com.cognizant.LearnTodayRESTAPI.exception.CourseNotFoundException;
import com.cognizant.LearnTodayRESTAPI.model.Course;

@Service
public class CourseService {

	@Autowired
	private CourseDao courseDAO;

	public List<Course> getAllCourses() {
		return courseDAO.getAllCourses();
	}

	public List<Course> getAllCoursesSortByStartDate() {
		return courseDAO.getAllCoursesSortByStartDate();
	}

	public Course getCourseById(int courseId) throws CourseNotFoundException {
		return courseDAO.getCourseById(courseId);
	}

}