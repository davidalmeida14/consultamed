package br.com.consultamedica.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import br.com.consultamedica.model.enums.DiasDaSemana;

@Entity
public class DiasAtendimento {
	
	public DiasAtendimento(DiasDaSemana dia, Medico medico) {
		this.diasDaSemana = dia;
		this.medico = medico;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@OneToOne()
	private Medico medico;
	
	private DiasDaSemana diasDaSemana;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public DiasDaSemana getDiasDaSemana() {
		return diasDaSemana;
	}

	public void setDiasDaSemana(DiasDaSemana diasDaSemana) {
		this.diasDaSemana = diasDaSemana;
	}



}
