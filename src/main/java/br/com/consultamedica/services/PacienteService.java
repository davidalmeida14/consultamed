package br.com.consultamedica.services;

import java.util.List;

import br.com.consultamedica.DAO.PacienteDAO;
import br.com.consultamedica.model.Paciente;

public class PacienteService implements IGerenciador<Paciente>{

	PacienteDAO dao = new PacienteDAO();
	
	@Override
	public void salvar(Paciente paciente) {
		this.dao.salvar(paciente);
	}

	@Override
	public void remover(Long id) {
		this.dao.remover(id);
	}

	@Override
	public List<Paciente> listar() {
		return this.dao.listar();
	}

	@Override
	public void editar(Paciente paciente) {
		this.dao.editar(paciente);
	}

	@Override
	public Paciente buscaPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Paciente buscaPorNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Paciente buscaPorEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

}
