package br.com.consultamedica.services;

import java.time.LocalDateTime;
import java.util.List;

import br.com.consultamedica.DAO.ConsultaDAO;
import br.com.consultamedica.model.Consulta;

public class ConsultaService {

	ConsultaDAO dao;
	
	public ConsultaService() {
		this.dao = new ConsultaDAO();
	}
	
	public void salvar(Consulta consulta) {
		this.dao.salvar(consulta);
	}
	public List<Consulta> listar() {
		return this.dao.listar();
	}
	
	public void editar(Consulta consulta) {
		this.dao.editar(consulta);
	}
	
	public List<Consulta> consultaPorPeriodo(LocalDateTime dataInicio, LocalDateTime dataFim) {
		return this.dao.consultaPorPeriodo(dataInicio, dataFim);
	}
	
}
