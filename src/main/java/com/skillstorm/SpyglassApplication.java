package com.skillstorm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin(origins = "http://spyglass-project3.s3-website-us-east-1.amazonaws.com/")
public class SpyglassApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpyglassApplication.class, args);
	}

}
