package com.skillstorm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.models.GoalPlanner;

@Repository 
public interface IGoalRepository extends JpaRepository<GoalPlanner, Integer> {
	
	List<GoalPlanner> findByUserId(String userId);

}
