package br.com.consultamedica.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import br.com.consultamedica.model.Paciente;
import br.com.consultamedica.utils.JPAUtils;

public class PacienteDAO {

	EntityManagerFactory emf = JPAUtils.getEntityManagerFactory();
	EntityManager factory = emf.createEntityManager();
	
	
	public void salvar(Paciente paciente) {
		factory.getTransaction().begin();
		factory.persist(paciente);
		factory.getTransaction().commit();
		factory.close();
	}
	
	public void remover(Long id) {
		this.factory.getTransaction().begin();
		this.factory.remove(this.buscarPorId(id));
		this.factory.getTransaction().commit();
		this.factory.close();
	}
	
	public Paciente buscarPorId(Long id) {
		this.factory.getTransaction().begin();
		Paciente pacienteBuscado = this.factory.find(Paciente.class, id);
		return pacienteBuscado;
	}
	
	
	public void editar(Paciente paciente) {
		this.factory.getTransaction().begin();
		this.factory.merge(paciente);
		this.factory.getTransaction().commit();
		this.factory.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Paciente> listar() {
		this.factory.getTransaction().begin();
		Query query = this.factory.createQuery("SELECT P From Pacientes as P");
		return (List<Paciente>) query.getResultList();
	}
}
