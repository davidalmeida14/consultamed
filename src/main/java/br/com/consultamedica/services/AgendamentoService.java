package br.com.consultamedica.services;

import java.util.List;

import br.com.consultamedica.DAO.AgendamentoDAO;
import br.com.consultamedica.model.Agendamento;

public class AgendamentoService implements IGerenciador<Agendamento> {

	AgendamentoDAO dao;
	
	public AgendamentoService() {
		dao = new AgendamentoDAO();
	}
	
	@Override
	public void salvar(Agendamento t) {
		this.dao.salvar(t);
	}

	@Override
	public void remover(Long id) {
		this.dao.remover(id);
	}

	@Override
	public List<Agendamento> listar() {
		return this.dao.listar();
	}

	@Override
	public void editar(Agendamento agendamento) {
		this.dao.editarAgendamento(agendamento);
		
	}

	@Override
	public Agendamento buscaPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Agendamento buscaPorNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Agendamento buscaPorEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

}
