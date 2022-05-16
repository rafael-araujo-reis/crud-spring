package dev.rafaelreis.crudspring.controller;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.rafaelreis.crudspring.model.Course;
import dev.rafaelreis.crudspring.repository.CourseRepository;
// import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/courses")
// @AllArgsConstructor
public class CoursesControler {

  public CoursesControler(CourseRepository courseRepository) {
    this.courseRepository = courseRepository;
  }

  private final CourseRepository courseRepository;

  @GetMapping
  public List<Course> list() {
    return courseRepository.findAll();
  }

  @Bean
  CommandLineRunner initDatabase(CourseRepository courseRepository) {
    return args -> {
      courseRepository.deleteAll();

      Course course = new Course();
      course.setName("Angular com Spring Boot");
      course.setCategory("Front-end");

      courseRepository.save(course);
    };
  }
}
