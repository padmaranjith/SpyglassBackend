package com.skillstorm.controllers;

import java.util.Map;


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


@Controller
@CrossOrigin(allowCredentials = "true", originPatterns = {"http://localhost:3000",
"http://spyglass-project3.s3-website-us-east-1.amazonaws.com","http://localhost:5000"})
public class LoginController {
	
	@Autowired
	private OAuth2AuthorizedClientService clientService;
	
	@Value("${frontend.url}")
	private String frontEndUrl;

	@GetMapping("/signin")
	public RedirectView redirectView() {
		//RedirectView redirectView = new RedirectView("http://localhost:3000/creategoal");
		RedirectView redirectView = new RedirectView(frontEndUrl);
		return redirectView;
	}
	
	
	@GetMapping("/userinfo")
	@ResponseBody
	public Map<String, Object> getUserInfo(@AuthenticationPrincipal OAuth2User user) {
		//Info about the user
		System.out.println("User name:"+user.getAttribute("given_name"));
		System.out.println("email name:"+user.getAttribute("email"));
		return user.getAttributes();
	}
	
//	//Return access token
//	@GetMapping("/access")
//	@ResponseBody
//	public String access(Authentication auth) {
//		
//		if(auth instanceof OAuth2AuthenticationToken) {
//			OAuth2AuthenticationToken authToken =(OAuth2AuthenticationToken) auth;
//		  OAuth2AuthorizedClient client=	clientService.loadAuthorizedClient(authToken.getAuthorizedClientRegistrationId(),
//					authToken.getName());
//		  System.out.println("Principal name:"+client.getPrincipalName());
//		  System.out.println(client);
//		  return client.getAccessToken().getTokenValue();
//		}
//		return "No Token found";
//	}
//	
//	@GetMapping("/id")
//	@ResponseBody
//	public String idToken(@AuthenticationPrincipal OAuth2User user) {
//		
//		return ((DefaultOidcUser)user).getIdToken().getTokenValue();
//		
//	}
	
	
}
