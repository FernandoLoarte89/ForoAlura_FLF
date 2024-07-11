package com.example.foroAlura.FOROALURA.domain.respuesta;

public record ListadoRespuesta(
        Long id,
        String mensaje,
        Long topicoId,
        java.time.LocalDateTime fechaDeCreacion,
        Long usuario,
        Boolean solucion
) {
    public ListadoRespuesta(Respuesta respuesta) {
        this(
                respuesta.getId(),
                respuesta.getMensaje(),
                respuesta.getTopico().getId(),
                respuesta.getFechaDeCreacion(),
                respuesta.getUsuario().getId(),
                respuesta.getSolucion()
        );
    }
}
