package com.kiet.AI_2A_FirstRestAPI.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kiet.AI_2A_FirstRestAPI.model.Book;
import com.kiet.AI_2A_FirstRestAPI.model.Course;
import com.kiet.AI_2A_FirstRestAPI.repository.BookRepository;
import com.kiet.AI_2A_FirstRestAPI.repository.CourseRepository;

@Service
public class CourseService {

	private CourseRepository repository;

	public CourseService(CourseRepository repository) {
		super();
		this.repository = repository;

	}

	public List<Course> reteriveAllCourses() {
		return repository.findAll();
	}

	public Course reteriveCourseById(int id) {
		return repository.findById(id).get();
	}

	public Course saveCourse(Course course) {
		return repository.save(course);
	}

	public void removeById(int id) {
		repository.deleteById(id);
		
	}

}
