package br.com.consultamedica.services;

import java.util.List;

import br.com.consultamedica.DAO.MedicoDAO;
import br.com.consultamedica.model.Medico;

public class MedicoService implements IGerenciador<Medico> {

	MedicoDAO medicoDAO = new MedicoDAO();
	
	
	@Override
	public void salvar(Medico medico) {
		this.medicoDAO.salvar(medico);
	}

	@Override
	public void remover(Long id) {
		this.medicoDAO.remover(id);
	}

	@Override
	public List<Medico> listar() {
		return this.medicoDAO.listar();
	}

	@Override
	public void editar(Medico medico) {
		this.medicoDAO.editar(medico);
		
	}

	@Override
	public Medico buscaPorId(Long id) {
		return this.medicoDAO.buscarPorId(id);
	}

	@Override
	public Medico buscaPorNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Medico buscaPorEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

}
