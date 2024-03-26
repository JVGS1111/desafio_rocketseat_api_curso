package br.com.dev.guerber.desafio_rocketseat_api_curso.modules.course.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.dev.guerber.desafio_rocketseat_api_curso.modules.course.entities.CourseEntity;
import jakarta.persistence.EntityManager;

@Repository
public class CourseCustomRepository {

    @Autowired
    private EntityManager entityManager;

    public List<CourseEntity> find(String name, String category) {
        String query = "select C from course as C ";
        String condition = "where";

        if (name != null) {
            query += condition + " C.name like :name";
            condition = " and ";
        }

        if (category != null) {
            query += condition + " C.category like :category";
            condition = " and ";
        }

        var q = entityManager.createQuery(query, CourseEntity.class);

        if (name != null) {
            q.setParameter("name", name + "%");
        }

        if (category != null) {
            q.setParameter("category", category + "%");
        }

        return q.getResultList();

    }

}
