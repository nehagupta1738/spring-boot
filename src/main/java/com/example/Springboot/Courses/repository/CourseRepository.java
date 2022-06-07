package com.example.Springboot.Courses.repository;

import com.example.Springboot.Courses.bean.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Long> {

}
