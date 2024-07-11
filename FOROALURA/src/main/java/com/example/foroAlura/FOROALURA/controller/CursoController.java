package com.example.foroAlura.FOROALURA.controller;

import com.example.foroAlura.FOROALURA.domain.curso.Curso;
import com.example.foroAlura.FOROALURA.domain.curso.RegistrarCurso;
import com.example.foroAlura.FOROALURA.repository.CursoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoRepository cursoRepository;

    @PostMapping
    public ResponseEntity regitrarCurso(@RequestBody @Valid RegistrarCurso registrarCurso) {

        cursoRepository.save(new Curso(
                registrarCurso.nombre(),
                registrarCurso.categoria()
        ));
        return ResponseEntity.noContent().build();
    }
}