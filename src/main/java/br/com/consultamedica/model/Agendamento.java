package br.com.consultamedica.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.consultamedica.model.enums.StatusConsulta;

@Entity
public class Agendamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private LocalDateTime dataAgendamento;
	
	@ManyToOne
	@JoinColumn(name="Id_Paciente")
	private Paciente paciente;
	
	@Enumerated(EnumType.STRING)
	private StatusConsulta stautsConsulta;
	
	private String descricaoCancelamento;
	
	private LocalDateTime dataCancelamento;
	
	@ManyToOne()
	@JoinColumn(name = "Id_Medico")
	private Medico medico;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public LocalDateTime getDataCancelamento() {
		return dataCancelamento;
	}
	public void setDataCancelamento(LocalDateTime dataCancelamento) {
		this.dataCancelamento = dataCancelamento;
	}
	public LocalDateTime getDataAgendamento() {
		return dataAgendamento;
	}
	public void setDataAgendamento(LocalDateTime dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
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
