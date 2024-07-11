package com.example.foroAlura.FOROALURA.domain.topicos;

import com.example.foroAlura.FOROALURA.domain.usuario.Usuario;
import com.example.foroAlura.FOROALURA.domain.curso.Curso;

public record ActualizarTopico(
        Long id,
        String titulo,
        String mensaje,
        StatusTopico statusTopico,
        Usuario usuario,
        Curso curso
) {
}
