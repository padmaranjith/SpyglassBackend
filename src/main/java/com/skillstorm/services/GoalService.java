package com.skillstorm.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillstorm.dtos.GoalDto;
import com.skillstorm.models.GoalImages;
import com.skillstorm.models.GoalPlanner;
import com.skillstorm.repository.IGoalImages;
import com.skillstorm.repository.IGoalRepository;

@Service
@Transactional
public class GoalService {
	
	@Autowired
	private IGoalRepository goalRepository;
	
	@Autowired
	private IGoalImages goalImages;
	
	public List<GoalDto> getAllGoalsByUserId(String userId){
		
		return goalRepository.findByUserId(userId)
				.stream()
				.map(goal->goal.toDto())
				.collect(Collectors.toList());
	}
	
	public void deleteGoalbyId(int id) {
		System.out.println("Goal with id "+id+" deleted successfully");
		
		goalRepository.deleteById(id);
	}

	public GoalDto createGoal(GoalDto goalData) {
		System.out.println("Creating goals.." + goalData.toString());
		System.out.println("Creating goals for userid.." + goalData.getUserId()
		+"descrip:"+goalData.getDescription()+"date:"+goalData.getTargetDate()
		+"targetamt:"+goalData.getTargetAmount()		);
		GoalPlanner goal = new GoalPlanner(goalData);
		//goal.setGoalDto(goalData);
		System.out.println("Goal object "+goal);
		return goalRepository.save(goal).toDto();
	}

	public List<GoalImages> getAllGoalImages(){
		System.out.println("Getting all the images");
		return goalImages.findAll();
	}
	
	public Optional<GoalDto> getGoalById(int goalId) {
		return goalRepository.findById(goalId)
			.map(goal->goal.toDto());
	}
	
	public GoalDto updateGoal(GoalDto goalData) {
		System.out.println("Goal object from user"+goalData);
		GoalPlanner goal = new GoalPlanner(goalData);
		System.out.println("Goal object "+goal);
		return goalRepository.save(goal).toDto();
	}
	public void updateAmount(int goalId,double savedAmount) {
		System.out.println("Updating saved amount in goal");
		   GoalPlanner goal = goalRepository.findById(goalId)
		            .orElseThrow(() -> new RuntimeException("Goal not found"));
		        double newSavedAmount=goal.getSavedamount()+savedAmount;
		   goal.setSavedamount(newSavedAmount);
		        System.out.println("Goal before saving saved amount"+goal);
		   goalRepository.save(goal);
		   System.out.println("Goal after saving saved amount"+goal);
	}
}
