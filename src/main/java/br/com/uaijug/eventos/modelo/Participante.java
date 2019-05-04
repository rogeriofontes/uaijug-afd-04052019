package br.com.uaijug.eventos.modelo;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "participante")
public class Participante extends AbstractEntity {
	private static final long serialVersionUID = 1676134216320209573L;

	@NotEmpty
	private String nome;
	
	@ManyToOne
	@JoinColumn(name = "evento_id")
	private Evento evento;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}
}
