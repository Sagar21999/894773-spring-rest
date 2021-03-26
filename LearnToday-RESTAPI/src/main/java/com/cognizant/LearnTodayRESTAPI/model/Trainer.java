package com.cognizant.LearnTodayRESTAPI.model;

public class Trainer {
	
	private int trainerId;
	private String password;
	public int getTrainerId() {
		return trainerId;
	}
	public void setTrainerId(int trainerId) {
		this.trainerId = trainerId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Trainer(int trainerId, String password) {
		super();
		this.trainerId = trainerId;
		this.password = password;
	}
	public Trainer() {
		super();
		
	}

}

