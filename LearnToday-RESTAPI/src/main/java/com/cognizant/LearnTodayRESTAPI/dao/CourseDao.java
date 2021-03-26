package com.cognizant.LearnTodayRESTAPI.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import com.cognizant.LearnTodayRESTAPI.exception.CourseNotFoundException;
import com.cognizant.LearnTodayRESTAPI.model.Course;

@Component
public class CourseDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Course> getAllCourses() {
		List<Course> courseList = new ArrayList<Course>();
		try {
			courseList = jdbcTemplate.query("SELECT * FROM Course", new CourseListExtractor());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return courseList;
	}

	public List<Course> getAllCoursesSortByStartDate() {
		List<Course> courseList = new ArrayList<Course>();
		try {
			courseList = jdbcTemplate.query("SELECT * FROM Course ORDER BY Start_Date", new CourseListExtractor());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return courseList;
	}

	public Course getCourseById(int courseId) throws CourseNotFoundException {
		Course course = new Course();
		try {
			Course fechtedCourse = jdbcTemplate.query("SELECT * FROM Course where CourseId = ?", new CourseExtractor(),courseId);

			course = fechtedCourse;

			if (course == null) {
				throw new CourseNotFoundException();
			}

		} catch (CourseNotFoundException e) {
			throw new CourseNotFoundException();
		} catch (Exception e) {
			System.out.println(e.getClass());
			System.out.println(e.getMessage());
		}
		return course;
	}

}

class CourseListExtractor implements ResultSetExtractor<List<Course>> {

	@Override
	public List<Course> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<Course> list = new ArrayList<Course>();
		while (rs.next()) {
			Course course = new Course(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getString(4), rs.getString(5),
					rs.getDate(6));
			list.add(course);
		}
		return list;
	}
}

class CourseExtractor implements ResultSetExtractor<Course> {

	@Override
	public Course extractData(ResultSet rs) throws SQLException, DataAccessException {
		if (rs.next())
			return new Course(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getString(4), rs.getString(5),
					rs.getDate(6));
		return null;
	}

}
