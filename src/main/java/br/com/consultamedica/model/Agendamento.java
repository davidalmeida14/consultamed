package br.com.consultamedica.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import br.com.consultamedica.model.enums.StatusConsulta;

@Entity
public class Agendamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private LocalDateTime data;
	
	@ManyToMany
	private List<Paciente> paciente;
	
	@Enumerated(EnumType.STRING)
	private StatusConsulta stautsConsulta;
	
	private String descricaoCancelamento;
	
	@ManyToOne
	private Medico medico;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDateTime getData() {
		return data;
	}
	public void setData(LocalDateTime data) {
		this.data = data;
	}
	public List<Paciente> getPaciente() {
		return paciente;
	}
	public void setPaciente(List<Paciente> paciente) {
		this.paciente = paciente;
	}
	public StatusConsulta getStautsConsulta() {
		return stautsConsulta;
	}
	public void setStautsConsulta(StatusConsulta stautsConsulta) {
		this.stautsConsulta = stautsConsulta;
	}
	public String getDescricaoCancelamento() {
		return descricaoCancelamento;
	}
	public void setDescricaoCancelamento(String descricaoCancelamento) {
		this.descricaoCancelamento = descricaoCancelamento;
	}
	public Medico getMedico() {
		return medico;
	}
	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	

}
