package com.kiet.AI_2A_FirstRestAPI.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kiet.AI_2A_FirstRestAPI.model.Book;
import com.kiet.AI_2A_FirstRestAPI.model.Course;

@RestController
public class FirstRestController {

	@RequestMapping("/hello")
	public String hello() {
		return "Hello from course manager";
	}

	@RequestMapping("/course")
	public Course getCourse() {
		return new Course(1, "Btech", "4 years", "John");
	}

}
