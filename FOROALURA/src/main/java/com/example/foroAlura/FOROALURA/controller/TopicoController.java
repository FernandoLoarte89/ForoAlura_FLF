package com.example.foroAlura.FOROALURA.controller;

import com.example.foroAlura.FOROALURA.domain.topicos.*;
import com.example.foroAlura.FOROALURA.repository.TopicoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping
    public ResponseEntity<RespuestaTopico> registrarTopico(@RequestBody @Valid RegistroTopico registro,
                                                           UriComponentsBuilder uri){

        Topico topico = topicoRepository.save(new Topico(registro));
        RespuestaTopico respuestaTopico = new RespuestaTopico(topico);
        URI url = uri.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(url).body(respuestaTopico);
    }

    @GetMapping
    public ResponseEntity<Page<ListadoTopico>> listarTopico(Pageable paginacion){
        return ResponseEntity.ok(topicoRepository.findAll(paginacion).map(ListadoTopico::new));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ListadoTopico> buscarTopico(@PathVariable Long id){
        Topico topico = topicoRepository.getReferenceById(id);
        var datosTopico = new ListadoTopico(topico);
        return ResponseEntity.ok(datosTopico);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<RespuestaTopico> actualizarTopico(@RequestBody @Valid ActualizarTopico actualizarTopico){
        Topico topico = topicoRepository.getReferenceById(actualizarTopico.id());
        topico.actualizarDatos(actualizarTopico);
        return ResponseEntity.ok(new RespuestaTopico(topico));
    }

    public ResponseEntity<Void> eliminarTopico(@PathVariable Long id){
        Topico topico = topicoRepository.getReferenceById(id);
        topicoRepository.delete(topico);
        return ResponseEntity.noContent().build();
    }
}
