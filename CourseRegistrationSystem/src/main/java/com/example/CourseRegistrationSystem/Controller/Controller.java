package com.example.CourseRegistrationSystem.Controller;

import com.example.CourseRegistrationSystem.Model.Courseregistry;
import com.example.CourseRegistrationSystem.Model.Model;
import com.example.CourseRegistrationSystem.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class Controller {
    @Autowired
    CourseService courseService;

    @GetMapping("courses")
    public List<Model> availableCourse(){
        return courseService.availableCourse();
    }

    @GetMapping("enrolledcourses")
    public List<Courseregistry> enrolledcourses(){
        return courseService.enrolledcourses();
    }
    @PostMapping("registercourse")
    public String registercourse(@RequestParam ("name") String name,@RequestParam ("emailid") String emailid,@RequestParam ("CourseName") String CourseName){
        courseService.registercourses(name,emailid,CourseName);
        return "Congratulations  "+name+" EnrolledCourses Successfully for "+CourseName;
    }

}
