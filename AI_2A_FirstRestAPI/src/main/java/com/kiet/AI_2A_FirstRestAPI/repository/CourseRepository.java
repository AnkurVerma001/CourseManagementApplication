package com.kiet.AI_2A_FirstRestAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kiet.AI_2A_FirstRestAPI.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer>{

}
