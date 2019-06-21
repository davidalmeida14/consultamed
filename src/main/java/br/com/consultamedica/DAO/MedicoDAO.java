package br.com.consultamedica.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import br.com.consultamedica.model.Medico;
import br.com.consultamedica.utils.JPAUtils;

public class MedicoDAO {
	
	EntityManagerFactory emf = JPAUtils.getEntityManagerFactory();
	EntityManager factory = emf.createEntityManager();
	
	
	public void salvar(Medico medico) {
		factory.getTransaction().begin();
		factory.persist(medico);
		factory.getTransaction().commit();
		factory.close();
	}
	
	public void remover(Long id) {
		this.factory.getTransaction().begin();
		this.factory.remove(this.buscarPorId(id));
		this.factory.getTransaction().commit();
		this.factory.close();
	}
	
	public Medico buscarPorId(Long id) {
		this.factory.getTransaction().begin();
		Medico medicoBuscado = this.factory.find(Medico.class, id);
		return medicoBuscado;
	}
	
	
	public void editar(Medico medico) {
		this.factory.getTransaction().begin();
		this.factory.merge(medico);
		this.factory.getTransaction().commit();
		this.factory.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Medico> listar() {
		this.factory.getTransaction().begin();
		Query query = this.factory.createQuery("SELECT M From MEDICO as M");
		return (List<Medico>) query.getResultList();
	}
}
