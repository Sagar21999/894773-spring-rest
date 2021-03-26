package com.cognizant.LearnTodayRESTAPI.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.cognizant.LearnTodayRESTAPI.exception.StudentNotFoundException;
import com.cognizant.LearnTodayRESTAPI.model.Student;

@Component
public class StudentDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public boolean saveStudent(Student s) {

		boolean added = false;

		try {
			int count = jdbcTemplate.update("insert into student values (?,?,?)", s.getEnrollmentId(),
					s.getStudentId(), s.getCourseId());

			if (count > 0) {
				added = true;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return added;
	}

	public boolean deleteStudent(int id) throws StudentNotFoundException {

		boolean deleted = false;

		try {
			int count = jdbcTemplate.update("delete from student where enrollmentId = ?", id);

			if (count > 0) {
				deleted = true;
			} else {
				throw new StudentNotFoundException();
			}
		} catch (StudentNotFoundException e) {
			throw new StudentNotFoundException();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return deleted;
	}
}