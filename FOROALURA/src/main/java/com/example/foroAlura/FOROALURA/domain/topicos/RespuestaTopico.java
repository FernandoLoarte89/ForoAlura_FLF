package com.example.foroAlura.FOROALURA.domain.topicos;

import java.time.LocalDateTime;

public record RespuestaTopico(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaDeCreacion,
        StatusTopico statusTopico,
        String usuario,
        String curso
) {
    public RespuestaTopico(Topico topico) {
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaDeCreacion(),
                topico.getStatus(),
                topico.getUsuario().getNombre(),
                topico.getCurso().getNombre()
        );
    }
}
