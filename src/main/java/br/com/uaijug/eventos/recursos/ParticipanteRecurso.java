package br.com.uaijug.eventos.recursos;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.uaijug.eventos.modelo.Participante;
import br.com.uaijug.eventos.repositorio.ParticipanteRepositorio;

@RestController
@RequestMapping(path = "/participantes")
public class ParticipanteRecurso {
	
	@Autowired
	private ParticipanteRepositorio participanteRepositorio;
	
	@RequestMapping(method = RequestMethod.POST, consumes = 
			MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<String> salvar(@Valid @RequestBody Participante participante) {
		participanteRepositorio.save(participante);
		return new ResponseEntity<String>("Dados Gravados", HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.GET, produces = 
			MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<List<Participante>> allParticipantes() {
		 List<Participante> participantes = participanteRepositorio.findAll();
		 return new ResponseEntity<List<Participante>>(participantes, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE, consumes = 
			MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<String> deletar(@RequestBody Participante participante) {
		participanteRepositorio.delete(participante);
		return new ResponseEntity<String>("Dados Deletados", HttpStatus.OK);
	}

}
