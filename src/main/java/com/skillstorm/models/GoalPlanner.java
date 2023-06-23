package com.skillstorm.models;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.skillstorm.dtos.GoalDto;

@Entity
@Table(name="goals")
public class GoalPlanner {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="goal_id")
	private int goalId;
	@Column(name="user_id")
	private int userId;
	@Column(name="goal_name")
	private String goalName;
	@Column(name="description")
	private String description;
	@Column(name="target_date")
	private Date targetDate;
	@Column(name="target_amount")
	private double targetAmount;
	@Column(name="saved_amount")
	private double savedamount;
	@Column(name="goal_imageurl")
	private String GoalImageUrl;
	
	public GoalPlanner() {
		
	}
		
	public GoalPlanner(int goalId, int userId, String goalName, String description, Date targetDate,
			double targetAmount, double savedamount, String goalImageUrl) {
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
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
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

	public GoalDto toDto() {
		return new GoalDto(goalId, userId, goalName, description, targetDate, targetAmount, savedamount, GoalImageUrl);
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
		GoalPlanner other = (GoalPlanner) obj;
		return goalId == other.goalId;
	}

	@Override
	public String toString() {
		return "GoalPlanner [goalId=" + goalId + ", userId=" + userId + ", goalName=" + goalName + ", description="
				+ description + ", targetDate=" + targetDate + ", targetAmount=" + targetAmount + ", savedamount="
				+ savedamount + ", GoalImageUrl=" + GoalImageUrl + "]";
	}
	
	
}
