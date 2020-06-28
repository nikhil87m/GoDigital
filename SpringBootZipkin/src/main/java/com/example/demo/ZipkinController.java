package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ZipkinController")
public class ZipkinController {
	private static Logger logger= LoggerFactory.getLogger(ZipkinController.class);
	
	@GetMapping("/sayHello")
	public String sayHello() {
		logger.info("Inside test logger sayHello");
		return "Hello Good morning!";
		
	}

}
