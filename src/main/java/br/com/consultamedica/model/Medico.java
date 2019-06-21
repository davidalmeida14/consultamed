package br.com.consultamedica.model;

import javax.persistence.Entity;

@Entity
public class Medico extends Pessoa {

	private String crm;

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
