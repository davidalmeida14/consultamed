package br.com.consultamedica.services;

import java.util.List;

import br.com.consultamedica.model.Contato;

public interface IContato {

	public void salvar(Contato contato);
	
	public void remover(Long idContato);
	
	public List<Contato> listarContatos();
	
	public void editar(Contato contato);
	
	public Contato buscaContatoId(Long id);
	
	public Contato buscaContatoNome(String nome);
	
	public Contato buscaContatoEmail(String email);
	
	
}
