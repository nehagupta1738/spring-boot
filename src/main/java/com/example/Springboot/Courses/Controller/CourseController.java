package com.example.Springboot.Courses.Controller;


import com.example.Springboot.Courses.bean.Course;
import com.example.Springboot.Courses.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
public class CourseController {

    @Autowired
    private CourseRepository repo;
    @GetMapping("/courses")
    public List<Course> getAllCourses()
    {
        return repo.findAll();
    }

    @GetMapping("/courses/{id}")
    public Course getCoursesDetails(@PathVariable long id)
    {
        Optional<Course>temp=repo.findById(id);
        if(temp.isEmpty())
        {
            throw new RuntimeException("course not found");
        }
        return temp.get();
    }

    @PostMapping("/courses")
    public void createCourse(@RequestBody Course course)
    {
       repo.save(course);
    }
}
