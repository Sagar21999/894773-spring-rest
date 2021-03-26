package com.cognizant.LearnTodayRESTAPI.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.LearnTodayRESTAPI.exception.CourseNotFoundException;
import com.cognizant.LearnTodayRESTAPI.model.Course;
import com.cognizant.LearnTodayRESTAPI.service.CourseService;

@RestController
@RequestMapping("/api/Admin")
public class AdminController {

	@Autowired
	private CourseService courseService;

	@GetMapping
	public ResponseEntity<Object> getAllCourses() {
		List<Course> courses = courseService.getAllCourses();
		if (!courses.isEmpty()) {
			return new ResponseEntity(courses, HttpStatus.OK);
		} else {
			return new ResponseEntity("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/{CourseId}")
	public ResponseEntity<Object> getCourseById(@PathVariable("CourseId") int CourseId) throws CourseNotFoundException {
		Course course = courseService.getCourseById(CourseId);
		return new ResponseEntity(course, HttpStatus.OK);
	}

}