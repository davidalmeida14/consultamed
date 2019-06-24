package br.com.consultamedica.model.enums;

public enum DiasDaSemana {
	
	DOMINGO(1),
	SEGUNDA(2),
	TERCA(3),
	QUARTA(4),
	QUINTA(5),
	SEXTA(6),
	SABADO(7);
	
	
	DiasDaSemana(int day){
		this.day = day;
	}
	
	int day;

}
