package br.com.consultamedica.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import br.com.consultamedica.model.Agendamento;
import br.com.consultamedica.utils.JPAUtils;

public class AgendamentoDAO {

	EntityManagerFactory emf = JPAUtils.getEntityManagerFactory();
	EntityManager em = emf.createEntityManager();
	
	
	public void salvar(Agendamento agendamento) {
		em.getTransaction().begin();
		em.persist(agendamento);
		em.getTransaction().commit();
		em.close();
	}
	
	public void remover(Long id) {
		em.getTransaction().begin();
		em.remove(this.buscarAgendamentoPorId(id));
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Agendamento> listar(){
		em.getTransaction().begin();
		Query query = em.createQuery("SELECT A FROM AGENDAMENTOS A");
		return (List<Agendamento>) query.getResultList();
	}

	public Agendamento buscarAgendamentoPorId(Long id) {
		em.getTransaction().begin();
		Agendamento agendamentoBuscado = em.find(Agendamento.class, id);
		return agendamentoBuscado;
	}
	
	public void editarAgendamento(Agendamento agendamneto) {
		em.getTransaction().begin();
		em.merge(agendamneto);
		em.getTransaction().commit();
		em.close();
	}
}
