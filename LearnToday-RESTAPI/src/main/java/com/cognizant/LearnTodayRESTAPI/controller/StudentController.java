package com.cognizant.LearnTodayRESTAPI.controller;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.LearnTodayRESTAPI.exception.StudentNotFoundException;
import com.cognizant.LearnTodayRESTAPI.model.Course;
import com.cognizant.LearnTodayRESTAPI.model.Student;
import com.cognizant.LearnTodayRESTAPI.service.CourseService;
import com.cognizant.LearnTodayRESTAPI.service.StudentService;

@RestController
@RequestMapping("/api/Student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@Autowired
	CourseService courseService;

	@GetMapping
	public ResponseEntity<Object> getAllCourses() {
		List<Course> courses = courseService.getAllCoursesSortByStartDate();
		if (!courses.isEmpty()) {
			return new ResponseEntity(courses, HttpStatus.OK);
		} else {
			return new ResponseEntity("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping
	public ResponseEntity<Object> postStudent(@RequestBody Student student) {

		boolean studentAdded = studentService.saveStudent(student);

		if (studentAdded) {
			return new ResponseEntity(student, HttpStatus.CREATED);
		} else {
			Map<String, Object> body = new LinkedHashMap<>();
			body.put("timestamp", new Date());
			body.put("Message", "Something went wrong");
			return new ResponseEntity(body, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteStudentEnrollment(@PathVariable("id") int id) throws StudentNotFoundException {

		boolean studentDeleted = studentService.deleteStudent(id);

		if (studentDeleted) {
			return new ResponseEntity("Student deletion done", HttpStatus.OK);
		} else {
			Map<String, Object> body = new LinkedHashMap<>();
			body.put("timestamp", new Date());
			body.put("Message", "Something went wrong");
			return new ResponseEntity(body, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
