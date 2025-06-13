package com.kiet.AI_2A_FirstRestAPI.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kiet.AI_2A_FirstRestAPI.model.Book;
import com.kiet.AI_2A_FirstRestAPI.model.Course;
import com.kiet.AI_2A_FirstRestAPI.service.BookService;
import com.kiet.AI_2A_FirstRestAPI.service.CourseService;

@RestController
@RequestMapping("/api")
public class CourseController {

	private CourseService service;

	public CourseController(CourseService service) {
		super();
		this.service = service;
	}

	@GetMapping("/courses")
	public List<Course> getAllCourses() {
		return service.reteriveAllCourses();
	}

	@GetMapping("/courses/{id}")
	public Course getCourseById(@PathVariable int id) {
		return service.reteriveCourseById(id);
	}

	@DeleteMapping("/courses/{id}")
	public void removeCourse(@PathVariable int id) {
		service.removeById(id);
	}

	@PostMapping("/courses")
	public Course insertCourse(@RequestBody Course course) {
		return service.saveCourse(course);
	}

}
