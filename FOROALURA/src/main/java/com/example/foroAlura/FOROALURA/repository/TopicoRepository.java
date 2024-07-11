package com.example.foroAlura.FOROALURA.repository;

import com.example.foroAlura.FOROALURA.domain.topicos.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
}
