package br.com.dev.guerber.desafio_rocketseat_api_curso.modules.course.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.dev.guerber.desafio_rocketseat_api_curso.modules.course.entities.CourseEntity;
import br.com.dev.guerber.desafio_rocketseat_api_curso.modules.course.useCases.ActiveOrDeactiveCourseUseCase;
import br.com.dev.guerber.desafio_rocketseat_api_curso.modules.course.useCases.CreateCourseUseCase;
import br.com.dev.guerber.desafio_rocketseat_api_curso.modules.course.useCases.DeleteCourseUseCase;
import br.com.dev.guerber.desafio_rocketseat_api_curso.modules.course.useCases.ListAllCoursesUseCase;
import br.com.dev.guerber.desafio_rocketseat_api_curso.modules.course.useCases.PutCourseUseCase;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/cursos")
public class CourseController {

    @Autowired
    private CreateCourseUseCase createCourseUseCase;

    @Autowired
    private ListAllCoursesUseCase listAllCoursesUseCase;

    @Autowired
    private PutCourseUseCase putCourseUseCase;

    @Autowired
    private DeleteCourseUseCase deleteCourseUseCase;

    @Autowired
    private ActiveOrDeactiveCourseUseCase activeOrDeactiveCourseUseCase;

    @PostMapping("")
    public ResponseEntity<Object> create(@Valid @RequestBody CourseEntity courseEntity) {

        try {
            var result = this.createCourseUseCase.execute(courseEntity);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("")
    public ResponseEntity<Object> listAllCourses(
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String name) {

        try {
            var result = this.listAllCoursesUseCase.execute(name, category);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> putCourse(@PathVariable String id, @Valid @RequestBody CourseEntity updatedCourse) {
        try {
            var result = this.putCourseUseCase.execute(id, updatedCourse);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCourse(@PathVariable String id) {
        try {
            this.deleteCourseUseCase.execute(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PatchMapping("/{id}/active")
    public ResponseEntity<Object> activeOrDeactiveCourse(@PathVariable String id) {
        try {
            var course = this.activeOrDeactiveCourseUseCase.execute(id);
            return ResponseEntity.ok().body(course);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
