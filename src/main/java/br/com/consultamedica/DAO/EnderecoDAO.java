package br.com.consultamedica.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import br.com.consultamedica.model.Endereco;
import br.com.consultamedica.utils.JPAUtils;

public class EnderecoDAO {

	EntityManagerFactory emf = JPAUtils.getEntityManagerFactory();
	EntityManager factory = emf.createEntityManager();
	
	public void salvar(Endereco endereco) {
		factory.getTransaction().begin();
		factory.persist(endereco);
		factory.getTransaction().commit();
		factory.close();
	}
	
	public void remover(Long id) {
		this.factory.getTransaction().begin();
		this.factory.remove(this.buscarPorId(id));
		this.factory.getTransaction().commit();
		this.factory.close();
	}
	
	public Endereco buscarPorId(Long id) {
		this.factory.getTransaction().begin();
		Endereco enderecoBuscado = this.factory.find(Endereco.class, id);
		return enderecoBuscado;
	}
	
	public void editar(Endereco endereco) {
		this.factory.getTransaction().begin();
		this.factory.merge(endereco);
		this.factory.getTransaction().commit();
		this.factory.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Endereco> listar(){
		this.factory.getTransaction().begin();
		Query query = this.factory.createQuery("SELECT E From Endereco as E");
		return (List<Endereco>) query.getResultList();
	}
	
	
}
