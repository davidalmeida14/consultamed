package br.com.consultamedica.services;

import java.util.List;

import br.com.consultamedica.DAO.EnderecoDAO;
import br.com.consultamedica.model.Endereco;

public class EnderecoService implements IGerenciador<Endereco>{

	private EnderecoDAO enderecoDAO = new EnderecoDAO();

	@Override
	public void salvar(Endereco endereco) {
		this.enderecoDAO.salvar(endereco);
		
	}

	@Override
	public void remover(Long id) {
		this.enderecoDAO.remover(id);
	}

	@Override
	public List<Endereco> listar() {
		return this.enderecoDAO.listar();
	}

	@Override
	public void editar(Endereco endereco) {
		this.enderecoDAO.editar(endereco);
		
	}

	@Override
	public Endereco buscaPorId(Long id) {
		return this.enderecoDAO.buscarPorId(id);
	}

	@Override
	public Endereco buscaPorNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Endereco buscaPorEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
}
