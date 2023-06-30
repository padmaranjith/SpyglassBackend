package com.skillstorm.controllers;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

import com.skillstorm.services.GoalService;


@Controller
@CrossOrigin(allowCredentials = "true", origins= {"http://localhost:3000",
		"http://spyglass-project3.s3-website-us-east-1.amazonaws.com",
		"http://localhost:5000","http://sg-project3-env.eba-x42sixpj.us-east-1.elasticbeanstalk.com",
		"https://spyglass-project3.s3-website-us-east-1.amazonaws.com",
		"https://sg-project3-env.eba-x42sixpj.us-east-1.elasticbeanstalk.com"})
public class LoginController {
	
	//Creating logger
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
		
	@Value("${frontend.url}")
	private String frontEndUrl;

	//Authenticating signin and redirecting to the frontend
	@GetMapping("/signin")
	public RedirectView redirectView() {
		//RedirectView redirectView = new RedirectView("http://localhost:3000/creategoal");
		RedirectView redirectView = new RedirectView(frontEndUrl);
		return redirectView;
	}
	
	//Retrieve user details after authentication
	@GetMapping("/userinfo")
	@ResponseBody
	public Map<String, Object> getUserInfo(@AuthenticationPrincipal OAuth2User user) {
		//Info about the user
		logger.info("User name:"+user.getAttribute("given_name"));
		logger.info("email name:"+user.getAttribute("email"));
		return user.getAttributes();
	}
	

}
