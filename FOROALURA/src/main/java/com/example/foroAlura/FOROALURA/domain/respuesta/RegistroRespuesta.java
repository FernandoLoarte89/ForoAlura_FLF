package com.example.foroAlura.FOROALURA.domain.respuesta;

import com.example.foroAlura.FOROALURA.domain.usuario.Usuario;
import com.example.foroAlura.FOROALURA.domain.topicos.Topico;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RegistroRespuesta(
        @NotBlank
        String mensaje,
        @NotNull
        Topico topico,
        @NotNull
        Usuario autor
) {
}
