package com.example.foroAlura.FOROALURA.domain.respuesta;

public record ReturnRespuesta(
        Long id,
        String mensaje,
        String topico,
        String usuario
) {
    public ReturnRespuesta(Respuesta respuesta) {
        this(
                respuesta.getId(),
                respuesta.getMensaje(),
                respuesta.getTopico().getTitulo(),
                respuesta.getUsuario().getNombre()
        );
    }
}
