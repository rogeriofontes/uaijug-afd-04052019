package br.com.uaijug.eventos.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.uaijug.eventos.modelo.Evento;

@Repository
public interface EventoRepositorio extends JpaRepository<Evento, Long> {
	 
}
