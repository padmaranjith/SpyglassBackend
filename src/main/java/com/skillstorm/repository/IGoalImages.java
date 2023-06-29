package com.skillstorm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.models.GoalImages;

@Repository
public interface IGoalImages  extends JpaRepository<GoalImages, Integer>{

	
}
