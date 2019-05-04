package br.com.uaijug.eventos.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.uaijug.eventos.modelo.Participante;

@Repository
public interface ParticipanteRepositorio extends JpaRepository<Participante, Long> {
	 
}
