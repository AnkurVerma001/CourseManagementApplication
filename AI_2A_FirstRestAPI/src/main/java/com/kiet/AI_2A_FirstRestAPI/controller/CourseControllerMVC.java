package com.kiet.AI_2A_FirstRestAPI.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kiet.AI_2A_FirstRestAPI.model.Book;
import com.kiet.AI_2A_FirstRestAPI.model.Course;
import com.kiet.AI_2A_FirstRestAPI.service.BookService;
import com.kiet.AI_2A_FirstRestAPI.service.CourseService;

@Controller
@RequestMapping("/view")
public class CourseControllerMVC {

	private CourseService service;
	
	
	public CourseControllerMVC(CourseService service) {
		super();
		this.service = service;
	}
	
	@GetMapping("/courses/{id}")
	public String getCourseById(Model model,@PathVariable int id ) {
		Course cour= service.reteriveCourseById(id);
		model.addAttribute("course", cour);  
		return "demo";
		
	}
	@GetMapping("/courses/update/{id}")
	public String updatePage(Model model ,@PathVariable int id ) {
		model.addAttribute("course",service.reteriveCourseById(id));
		return "course";
	}
	
	@GetMapping("/courses/delete/{id}")
	public String removeCourse(@PathVariable int id ) {
		service.removeById(id);
		
		return "redirect:/view/courses";
	}
	
	@GetMapping("/courses")
	public String getAllCourses(Model model) {
		List<Course> c =service.reteriveAllCourses();
		model.addAttribute("courses", c);
		return "index";
	}	
	
	@GetMapping("/courses/add")
	public String addPage(Model model) {
		Course course = new Course();
		course.setId(0);
		model.addAttribute("course", course);
		return "course";
	}
	
	
	@PostMapping("/courses/save")
	public String insertCourse(@ModelAttribute Course course) {
		service.saveCourse(course);
		return "redirect:/view/courses";
	}
}
