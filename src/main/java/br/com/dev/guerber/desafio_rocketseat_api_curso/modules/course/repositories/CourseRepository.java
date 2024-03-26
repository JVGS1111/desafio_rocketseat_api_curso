package br.com.dev.guerber.desafio_rocketseat_api_curso.modules.course.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.dev.guerber.desafio_rocketseat_api_curso.modules.course.entities.CourseEntity;

public interface CourseRepository extends JpaRepository<CourseEntity, UUID> {
    List<CourseEntity> findByNameContains(String name);
}
