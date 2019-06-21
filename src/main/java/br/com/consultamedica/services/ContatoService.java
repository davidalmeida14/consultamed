/**
 * 
 */
package br.com.consultamedica.services;

import java.util.List;

import br.com.consultamedica.DAO.ContatoDAO;
import br.com.consultamedica.model.Contato;

/**
 * @author davidalmeidasantos
 *
 */
public class ContatoService implements IContato {

	ContatoDAO dao;
	
	public ContatoService() {
		this.dao = new ContatoDAO();
	}
	
	@Override
	public void salvar(Contato contato) {
		this.dao.salvar(contato);
	}

	@Override
	public void remover(Long idContato) {
		this.dao.remover(idContato);
	}

	@Override
	public List<Contato> listarContatos() {
		return this.dao.buscarContatos();
	}

	@Override
	public void editar(Contato contato) {
		this.dao.editar(contato);
	}

	@Override
	public Contato buscaContatoNome(String nome) {
		return this.dao.buscaContatoNome(nome);
	}

	@Override
	public Contato buscaContatoEmail(String email) {
		return this.dao.buscaContatoEmail(email);
	}

	@Override
	public Contato buscaContatoId(Long id) {
		return this.dao.buscaContatoId(id);
	}

	
}
