package br.com.consultamedica.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
public class Paciente extends Pessoa {
	
	private List<Contato> contatos = new ArrayList<Contato>();

	public List<Contato> getContatos() {
		return contatos;
	}

	public void setContatos(List<Contato> contatos) {
		this.contatos = contatos;
	}
	
	public void realizaAgendamento(Agendamento agendamento) {
		
	}
	
}
