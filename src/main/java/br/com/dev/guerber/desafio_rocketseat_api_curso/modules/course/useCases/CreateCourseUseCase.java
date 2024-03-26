package br.com.dev.guerber.desafio_rocketseat_api_curso.modules.course.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dev.guerber.desafio_rocketseat_api_curso.modules.course.entities.CourseEntity;
import br.com.dev.guerber.desafio_rocketseat_api_curso.modules.course.repositories.CourseRepository;

@Service
public class CreateCourseUseCase {

    @Autowired
    private CourseRepository courseRepository;

    public CourseEntity execute(CourseEntity courseEntity) {
        return this.courseRepository.save(courseEntity);
    }

}
