package br.com.consultamedica.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Medico extends Pessoa {

	private String crm;
	
	@OneToMany
	private List<Agendamento> agendmentos;

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}
	
	public void realizaConsulta(Consulta consulta) {
		
	}
	
	public void cancelarConsulta(Consulta consulta) {
		
	}
	
}
