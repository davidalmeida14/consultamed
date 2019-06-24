/**
 * 
 */
package br.com.consultamedica.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import br.com.consultamedica.model.Contato;
import br.com.consultamedica.utils.JPAUtils;

/**
 * @author lab10usuario30
 *
 */
public class ContatoDAO {

	EntityManagerFactory emf = JPAUtils.getEntityManagerFactory();
	EntityManager factory = emf.createEntityManager();
	
	
	public void salvar(Contato contato) {
		factory.getTransaction().begin();
		factory.persist(contato);
		factory.getTransaction().commit();
	}
	
	public void remover(Long idContato) {
		this.factory.getTransaction().begin();
		this.factory.remove(this.buscaContatoId(idContato));
		this.factory.getTransaction().commit();
	}
	
	public Contato buscaContatoId(Long id) {
		this.factory.getTransaction().begin();
		Contato contatoBuscado = this.factory.find(Contato.class, id);
		return contatoBuscado;
	}
	
	public Contato buscaContatoNome(String nome) {
		this.factory.getTransaction().begin();
		Query query = this.factory.createQuery("SELECT C From Contato Where C.Nome = :nome");
		query.setParameter("nome", nome);
		Contato contato = (Contato) query.getSingleResult();
		return contato;
		
	}
	
	public Contato buscaContatoEmail(String email) {
		this.factory.getTransaction().begin();
		Query query = this.factory.createQuery("SELECT C From Contato Where C.Email = :email");
		query.setParameter("nome", email);
		Contato contato = (Contato) query.getSingleResult();
		return contato;
	}
	
	public void editar(Contato contato) {
		this.factory.getTransaction().begin();
		this.factory.merge(contato);
		this.factory.getTransaction().commit();
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Contato> buscarContatos(){
		this.factory.getTransaction().begin();
		Query query = this.factory.createQuery("SELECT C From Contato C");
		return (List<Contato>) query.getResultList();
	}
	
}
