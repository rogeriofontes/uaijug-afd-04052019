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

import br.com.uaijug.eventos.modelo.Evento;
import br.com.uaijug.eventos.repositorio.EventoRepositorio;

@RestController
@RequestMapping(path = "/eventos")
public class EventoRecurso {
	
	@Autowired
	private EventoRepositorio eventoRepositorio;
	
	@RequestMapping(method = RequestMethod.POST, consumes = 
			MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<String> salvar(@Valid @RequestBody Evento evento) {
		eventoRepositorio.save(evento);
		return new ResponseEntity<String>("Dados Gravados", HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.GET, produces = 
			MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<List<Evento>> allEventos() {
		 List<Evento> eventos = eventoRepositorio.findAll();
		 return new ResponseEntity<List<Evento>>(eventos, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE, consumes = 
			MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<String> deletar(@RequestBody Evento evento) {
		eventoRepositorio.delete(evento);
		return new ResponseEntity<String>("Dados Deletados", HttpStatus.OK);
	}

}
