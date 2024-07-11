package com.example.foroAlura.FOROALURA.domain.respuesta;

import com.example.foroAlura.FOROALURA.domain.usuario.Usuario;
import com.example.foroAlura.FOROALURA.domain.topicos.Topico;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity(name = "Respuesta")
@Table(name = "respuestas")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Respuesta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mensaje;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "topico")
    Topico topico;
    @Column(name = "fecha_de_creacion")
    private LocalDateTime fechaDeCreacion = LocalDateTime.now();
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario")
    private Usuario usuario;
    private Boolean solucion = false;

    public Respuesta(RegistroRespuesta registroRespuesta) {
        this.mensaje = registroRespuesta.mensaje();
        this.topico = registroRespuesta.topico();
        this.usuario = registroRespuesta.autor();
    }

    public void actualizarDatos(ActualizarRespuesta actualizarRespuesta) {
        if (actualizarRespuesta.mensaje()!=null){
            this.mensaje = actualizarRespuesta.mensaje();
        }
        if (actualizarRespuesta.mensaje()!=null){
            this.topico = actualizarRespuesta.topico();
        }
        if (actualizarRespuesta.mensaje()!=null){
            this.usuario = actualizarRespuesta.autor();
        }
        if (actualizarRespuesta.mensaje()!=null){
            this.solucion = actualizarRespuesta.solucion();
        }
    }
}
