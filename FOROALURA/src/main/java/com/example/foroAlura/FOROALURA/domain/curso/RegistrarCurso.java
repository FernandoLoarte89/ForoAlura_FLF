package com.example.foroAlura.FOROALURA.domain.curso;

import jakarta.validation.constraints.NotBlank;

public record RegistrarCurso(

        @NotBlank String nombre,
        @NotBlank String categoria
) {
}
