package com.skillstorm.dtos;

import java.util.Date;
import java.util.Objects;


public class GoalDto {

	
	private int goalId;
	private String userId;
	private String goalName;
	private String description;
	private Date targetDate;
	private double targetAmount;
	private double savedamount;
	private String GoalImageUrl;
	
	public GoalDto(){
		
	}
	
	public GoalDto(int goalId, String userId, String goalName, String description, Date targetDate, double targetAmount,
			double savedamount, String goalImageUrl) {
		super();
		this.goalId = goalId;
		this.userId = userId;
		this.goalName = goalName;
		this.description = description;
		this.targetDate = targetDate;
		this.targetAmount = targetAmount;
		this.savedamount = savedamount;
		GoalImageUrl = goalImageUrl;
	}

	public int getGoalId() {
		return goalId;
	}

	public void setGoalId(int goalId) {
		this.goalId = goalId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getGoalName() {
		return goalName;
	}

	public void setGoalName(String goalName) {
		this.goalName = goalName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}

	public double getTargetAmount() {
		return targetAmount;
	}

	public void setTargetAmount(double targetAmount) {
		this.targetAmount = targetAmount;
	}

	public double getSavedamount() {
		return savedamount;
	}

	public void setSavedamount(double savedamount) {
		this.savedamount = savedamount;
	}

	public String getGoalImageUrl() {
		return GoalImageUrl;
	}

	public void setGoalImageUrl(String goalImageUrl) {
		GoalImageUrl = goalImageUrl;
	}

	@Override
	public int hashCode() {
		return Objects.hash(goalId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GoalDto other = (GoalDto) obj;
		return goalId == other.goalId;
	}

	@Override
	public String toString() {
		return "GoalDto [goalId=" + goalId + ", userId=" + userId + ", goalName=" + goalName + ", description="
				+ description + ", targetDate=" + targetDate + ", targetAmount=" + targetAmount + ", savedamount="
				+ savedamount + ", GoalImageUrl=" + GoalImageUrl + "]";
	}
	
	
	
	
	
}
