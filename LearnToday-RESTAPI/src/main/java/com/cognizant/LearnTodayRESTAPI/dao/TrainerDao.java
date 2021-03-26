package com.cognizant.LearnTodayRESTAPI.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.cognizant.LearnTodayRESTAPI.exception.TrainerNotFoundException;
import com.cognizant.LearnTodayRESTAPI.model.Trainer;

@Component
public class TrainerDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public boolean trainerSignUp(Trainer trainer) {

		boolean added = false;

		try {
			int count = jdbcTemplate.update("insert into Trainer values (?,?) ", trainer.getTrainerId(),trainer.getPassword());
			
			if (count > 0) {
				added = true;
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return added;
	}

	public boolean updatePassword(int id, Trainer trainer) throws TrainerNotFoundException {
		
		boolean updated = false;
		
		try {
			int count = jdbcTemplate.update("update trainer set password = ? where trainerId = ?",trainer.getPassword(), id);

			if (count > 0) {
				updated = true;
			} else {
				throw new TrainerNotFoundException();
			}
			
		} catch (TrainerNotFoundException e) {
			throw new TrainerNotFoundException();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return updated;
	}

}