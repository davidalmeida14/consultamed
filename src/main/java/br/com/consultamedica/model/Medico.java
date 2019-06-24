package br.com.consultamedica.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Medico extends Pessoa {

	private String crm;
	
	@OneToMany(mappedBy = "medico")
	private List<Agendamento> agendmentos;
	
	@OneToMany(mappedBy = "medico")
	private List<DiasAtendimento> diasAtendimento;
	
	public List<DiasAtendimento> getDiasAtendimento() {
		return diasAtendimento;
	}

	public void setDiasAtendimento(List<DiasAtendimento> diasAtendimento) {
		this.diasAtendimento = diasAtendimento;
	}

	public List<Agendamento> getAgendmentos() {
		return agendmentos;
	}

	public void setAgendmentos(List<Agendamento> agendmentos) {
		this.agendmentos = agendmentos;
	}

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
