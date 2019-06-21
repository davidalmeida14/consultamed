package br.com.consultamedica.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Paciente extends Pessoa {
	
	@OneToMany
	private List<Contato> contatos;
	
	@OneToMany
	private List<Agendamento> agendamento;


	public List<Agendamento> getAgendamento() {
		return agendamento;
	}

	public void setAgendamento(List<Agendamento> agendamento) {
		this.agendamento = agendamento;
	}

	public List<Contato> getContatos() {
		return contatos;
	}

	public void setContatos(List<Contato> contatos) {
		this.contatos = contatos;
	}
	
	public void realizaAgendamento(Agendamento agendamento) {
		
	}
	
}
