package com.example.foroAlura.FOROALURA.domain.topicos;

public record ListadoTopico(
        Long id,
        String titulo,
        String mensaje,
        java.time.LocalDateTime fechaDeCreacion,
        String status,
        String usuario,
        String curso
) {
    public ListadoTopico(Topico topico){
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaDeCreacion(),
                topico.getStatus().toString(),
                topico.getUsuario().getNombre(),
                topico.getCurso().getNombre());
    }
}
