package com.example.foroAlura.FOROALURA.domain.topicos;

import com.example.foroAlura.FOROALURA.domain.usuario.Usuario;
import com.example.foroAlura.FOROALURA.domain.curso.Curso;
import com.example.foroAlura.FOROALURA.domain.respuesta.Respuesta;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Topico")
@Table(name = "topicos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    @Column(name = "fecha_de_creacion")
    private LocalDateTime fechaDeCreacion = LocalDateTime.now();
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private StatusTopico status = StatusTopico.NO_RESPONDIDO;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "autor_id")
    private Usuario usuario;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curso_id")
    private Curso curso;

    @OneToMany(mappedBy = "topico", cascade = CascadeType.ALL)
    private List<Respuesta> respuestas = new ArrayList<>();
    private Boolean activo = true;

    public Topico(RegistroTopico registro) {
        this.titulo = registro.titulo();
        this.mensaje = registro.mensaje();
        this.usuario = new Usuario(registro.usuario());
        this.curso = new Curso(registro.curso());
    }

    public void actualizarDatos(ActualizarTopico actualizarTopico) {
        if(actualizarTopico.titulo() != null){
            this.titulo = actualizarTopico.titulo();
        }
        if(actualizarTopico.mensaje() != null){
            this.mensaje = actualizarTopico.mensaje();
        }
        if(actualizarTopico.statusTopico()!= null){
            this.status = actualizarTopico.statusTopico();
        }
        if(actualizarTopico.usuario()!= null){
            this.usuario = actualizarTopico.usuario();
        }
        if(actualizarTopico.curso()!= null){
            this.curso = actualizarTopico.curso();
        }
    }
}
