package com.skillstorm.controllers;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.dtos.GoalDto;
import com.skillstorm.models.GoalImages;
import com.skillstorm.services.GoalService;

@RestController
@RequestMapping("/goal")
@CrossOrigin(allowCredentials = "true", originPatterns = {"http://localhost:3000",
"http://spyglass-project3.s3-website-us-east-1.amazonaws.com",
"http://localhost:5000","http://sg-project3-env.eba-x42sixpj.us-east-1.elasticbeanstalk.com",
"https://spyglass-project3.s3-website-us-east-1.amazonaws.com",
"https://sg-project3-env.eba-x42sixpj.us-east-1.elasticbeanstalk.com"})
public class GoalController {

	@Autowired
	private GoalService goalService;
	
	@GetMapping
	public List<GoalDto> getAllGoalsByUserId(@AuthenticationPrincipal OAuth2User user) {
        String userId = user.getAttribute("sub"); // Retrieve the sub value from the principal
        return goalService.getAllGoalsByUserId(userId);
		
	}
	
	@GetMapping("/{goalId}")
	public Optional<GoalDto> getGoalByID(@PathVariable int goalId) {
		return goalService.getGoalById(goalId);
		
	}
	
	@PostMapping
	public ResponseEntity<GoalDto> createGoal(@RequestBody GoalDto goalData,
			@AuthenticationPrincipal OAuth2User user) {
      
        	String userId=user.getAttribute("sub");
        	goalData.setUserId(userId);
        	GoalDto goal = goalService.createGoal(goalData);
        	return new ResponseEntity<>(goal, HttpStatus.CREATED);
        	
	}
	@GetMapping("/images")
	public List<GoalImages> getAllGoalImages(){
		return goalService.getAllGoalImages();
	}
	
	@PutMapping("/{goalId}")
	public GoalDto updateGoal(@PathVariable int goalId,@RequestBody GoalDto goalData) {
		goalData.setGoalId(goalId);
		return goalService.updateGoal(goalData);
	}
	
	@DeleteMapping("/{goalId}")
	public void deleteGoal(@PathVariable int  goalId) {
		goalService.deleteGoalbyId(goalId);
	}
	
	@PutMapping("/{goalId}/savedamount")
	public void updateAmount(@PathVariable int goalId, @RequestParam double savedAmount) {
	  goalService.updateAmount(goalId, savedAmount);
	}

}
