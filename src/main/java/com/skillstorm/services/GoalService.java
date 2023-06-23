package com.skillstorm.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillstorm.dtos.GoalDto;
import com.skillstorm.repository.IGoalRepository;

@Service
@Transactional
public class GoalService {
	
	@Autowired
	private IGoalRepository goalRepository;
	
	public List<GoalDto> getAllGoalsByUserId(String userId){
		
		return goalRepository.findByUserId(userId)
				.stream()
				.map(goal->goal.toDto())
				.toList();
	}
	
	public void deleteGoalbyId(int id) {
		goalRepository.deleteById(id);
	}

}
