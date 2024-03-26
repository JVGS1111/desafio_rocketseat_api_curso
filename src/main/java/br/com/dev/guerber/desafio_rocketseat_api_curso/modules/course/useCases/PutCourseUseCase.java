package br.com.dev.guerber.desafio_rocketseat_api_curso.modules.course.useCases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dev.guerber.desafio_rocketseat_api_curso.modules.course.entities.CourseEntity;
import br.com.dev.guerber.desafio_rocketseat_api_curso.modules.course.repositories.CourseRepository;

@Service
public class PutCourseUseCase {

    @Autowired
    private CourseRepository courseRepository;

    public CourseEntity execute(String id, CourseEntity updatedCourse) {

        CourseEntity courseMatches = courseRepository.findById(UUID.fromString(id))
                .orElseThrow(() -> new RuntimeException("Curso não encontrado"));

        if (updatedCourse.getName() != null) {
            courseMatches.setName(updatedCourse.getName());
        }

        if (updatedCourse.getCategory() != null) {
            courseMatches.setCategory(updatedCourse.getCategory());
        }

        return courseRepository.save(courseMatches);
    }
}
