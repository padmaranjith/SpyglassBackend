package com.skillstorm.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillstorm.controllers.GoalController;
import com.skillstorm.dtos.GoalDto;
import com.skillstorm.models.GoalImages;
import com.skillstorm.models.GoalPlanner;
import com.skillstorm.repository.IGoalImages;
import com.skillstorm.repository.IGoalRepository;

@Service
@Transactional
public class GoalService {
	//Creating logger
		private static final Logger logger = LoggerFactory.getLogger(GoalService.class);
	@Autowired
	private IGoalRepository goalRepository;
	
	@Autowired
	private IGoalImages goalImages;
	
	//list the goals based on the user
	public List<GoalDto> getAllGoalsByUserId(String userId){
		
		return goalRepository.findByUserId(userId)
				.stream()
				.map(goal->goal.toDto())
				.collect(Collectors.toList());
	}
	//delete the goal by id
	public void deleteGoalbyId(int id) {
		logger.info("Goal with id "+id+" deleted successfully");
		
		goalRepository.deleteById(id);
	}

	//create goal
	public GoalDto createGoal(GoalDto goalData) {
		logger.info("Creating goals.." + goalData.getGoalName());
		GoalPlanner goal = new GoalPlanner(goalData);
		logger.info("Goal object Created");
		return goalRepository.save(goal).toDto();
	}
// function to list the goal images
	public List<GoalImages> getAllGoalImages(){
		logger.info("Getting all the images");
		return goalImages.findAll();
	}
	//retrieve selected goal 
	public Optional<GoalDto> getGoalById(int goalId) {
		return goalRepository.findById(goalId)
			.map(goal->goal.toDto());
	}
	//update the goal
	public GoalDto updateGoal(GoalDto goalData) {
		logger.info("Updating Goal object "+goalData);
		GoalPlanner goal = new GoalPlanner(goalData);
		logger.info("Goal object "+goal);
		return goalRepository.save(goal).toDto();
	}
	//Update the savedamount
	public void updateAmount(int goalId,double savedAmount) {
		  logger.info("Updating saved amount in goal");
		   GoalPlanner goal = goalRepository.findById(goalId)
		            .orElseThrow(() -> new RuntimeException("Goal not found"));
		   double newSavedAmount=goal.getSavedamount()+savedAmount;
		   goal.setSavedamount(newSavedAmount);
		   goalRepository.save(goal);
		   logger.info("Goal after saving saved amount"+goal);
	}
}
