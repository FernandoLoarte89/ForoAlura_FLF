package com.example.foroAlura.FOROALURA.domain.respuesta;

import com.example.foroAlura.FOROALURA.domain.usuario.Usuario;
import com.example.foroAlura.FOROALURA.domain.topicos.Topico;

public record ActualizarRespuesta(
        Long id,
        String mensaje,
        Topico topico,
        Usuario autor,
        Boolean solucion
) {
}
