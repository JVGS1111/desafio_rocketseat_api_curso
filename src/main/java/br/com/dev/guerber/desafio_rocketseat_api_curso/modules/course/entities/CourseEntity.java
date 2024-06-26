package br.com.dev.guerber.desafio_rocketseat_api_curso.modules.course.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity(name = "course")
public class CourseEntity {

    @Id()
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank(message = "O campo [name] é obrigatório")
    private String name;

    @NotBlank(message = "O campo [category] é obrigatório")
    private String category;

    private boolean active = false;

    @CreationTimestamp()
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
