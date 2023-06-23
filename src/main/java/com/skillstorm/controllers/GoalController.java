package com.skillstorm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.dtos.GoalDto;
import com.skillstorm.services.GoalService;

@RestController
@RequestMapping("/goal")
public class GoalController {

	@Autowired
	private GoalService goalService;
	
	public List<GoalDto> getAllGoalsByUserId(@AuthenticationPrincipal OAuth2User user) {
        String userId = user.getAttribute("sub"); // Retrieve the sub value from the principal
        return goalService.getAllGoalsByUserId(userId);
		
	}
	
	
}
