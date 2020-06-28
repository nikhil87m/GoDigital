package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/TestSwaggerController")
public class TestSwaggerController {

	@GetMapping("/sayHi")
	public String sayHi() {
		return "hi good day!";
	}
}
