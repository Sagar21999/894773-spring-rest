package com.cognizant.LearnTodayRESTAPI.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.LearnTodayRESTAPI.dao.TrainerDao;
import com.cognizant.LearnTodayRESTAPI.exception.TrainerNotFoundException;
import com.cognizant.LearnTodayRESTAPI.model.Trainer;

@Service
public class TrainerService {

	@Autowired
	private TrainerDao trainerDAO;

	public boolean trainerSignUp(Trainer trainer) {
		return trainerDAO.trainerSignUp(trainer);
	}

	public boolean updatePassword(int id, Trainer trainer) throws TrainerNotFoundException {
		return trainerDAO.updatePassword(id, trainer);
	}

}
