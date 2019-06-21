package br.com.consultamedica.services;

import java.util.List;

public interface IGerenciador<T> {
	
	public void salvar(T t);
	
	public void remover(Long id);
	
	public List<T> listar();
	
	public void editar(T t);
	
	public T buscaPorId(Long id);
	
	public T buscaPorNome(String nome);
	
	public T buscaPorEmail(String email);
	
}
