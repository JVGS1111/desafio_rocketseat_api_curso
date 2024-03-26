package br.com.dev.guerber.desafio_rocketseat_api_curso.modules.course.useCases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dev.guerber.desafio_rocketseat_api_curso.modules.course.entities.CourseEntity;
import br.com.dev.guerber.desafio_rocketseat_api_curso.modules.course.repositories.CourseCustomRepository;

@Service
public class ListAllCoursesUseCase {

    @Autowired
    private CourseCustomRepository courseCustomRepository;

    public List<CourseEntity> execute(String name, String category) {

        List<CourseEntity> list = this.courseCustomRepository.find(name, category);

        return list;
    }
}
