package com.example.foroAlura.FOROALURA.controller;

import com.example.foroAlura.FOROALURA.domain.respuesta.*;
import com.example.foroAlura.FOROALURA.repository.RespuestaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/respuestas")
public class RespuestaController {

    @Autowired
    private RespuestaRepository respuestaRepository;

    @PostMapping
    public ResponseEntity<ReturnRespuesta> registrarRespuesta(RegistroRespuesta registroRespuesta,
                                                              UriComponentsBuilder uriComponentsBuilder){
        Respuesta respuesta = respuestaRepository.save(new Respuesta(registroRespuesta));
        ReturnRespuesta returnRespuesta = new ReturnRespuesta(respuesta);
        URI url = uriComponentsBuilder.path("/respuestas/{id}").buildAndExpand(respuesta.getId()).toUri();
        return ResponseEntity.created(url).body(returnRespuesta);
    }

    @GetMapping
    public ResponseEntity<Page<ListadoRespuesta>> listarRespuesta(Pageable paginacion){
        return ResponseEntity.ok(respuestaRepository.findAll(paginacion).map(ListadoRespuesta::new));
    }

    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity<ListadoRespuesta> obtenerRespuesta(@PathVariable Long id){
        Respuesta respuesta = respuestaRepository.getReferenceById(id);
        var datosRespuesta = new ListadoRespuesta(respuesta);
        return ResponseEntity.ok(datosRespuesta);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<ListadoRespuesta> actualizarRespuesta(@RequestBody ActualizarRespuesta actualizarRespuesta){
        Respuesta respuesta = respuestaRepository.getReferenceById(actualizarRespuesta.id());
        respuesta.actualizarDatos(actualizarRespuesta);
        return ResponseEntity.ok(new ListadoRespuesta(respuesta));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> eliminarRespuesta(@PathVariable Long id){
        Respuesta respuesta = respuestaRepository.getReferenceById(id);
        respuestaRepository.delete(respuesta);
        return ResponseEntity.noContent().build();
    }
}
