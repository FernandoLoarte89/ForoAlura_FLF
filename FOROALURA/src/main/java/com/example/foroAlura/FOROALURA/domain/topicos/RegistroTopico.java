package com.example.foroAlura.FOROALURA.domain.topicos;

import com.example.foroAlura.FOROALURA.domain.curso.Curso;
import com.example.foroAlura.FOROALURA.domain.usuario.Usuario;
import jakarta.validation.constraints.NotNull;

public record RegistroTopico(
        @NotNull String titulo,
        @NotNull String mensaje,
        @NotNull Usuario usuario,
        @NotNull Curso curso
) {
}
