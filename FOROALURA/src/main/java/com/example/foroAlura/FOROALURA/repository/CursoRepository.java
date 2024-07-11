package com.example.foroAlura.FOROALURA.repository;

import com.example.foroAlura.FOROALURA.domain.curso.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}
