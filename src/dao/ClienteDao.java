package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import jpa.ConnectionFactory;
import model.Cliente;

public class ClienteDao {
	
	private EntityManager em = new ConnectionFactory().getEntityManager();
	
	
	public void salva(Cliente c) {		
		
		try {
			em.getTransaction().begin();
			em.persist(c);
			em.getTransaction().commit();
			
		} catch (Exception e) {
			System.err.println("Erro: " +e);;
		} finally {
			em.close();
		}
		
	}
	
	
	public List<Cliente> pesquisaPorNome(String nomeMarca) {
		Query q = em.createNamedQuery("Marca.pesquisaPorNome");
		q.setParameter("nomeMarca", "%" + nomeMarca + "%");
		return q.getResultList();
	}
	
	public List<Cliente> listaTodosSimplificado(){
		Query q = em.createQuery(" select  new Marca(m.id, m.nome) "
				       + " from Marca m ");
		return q.getResultList();
	}
	
}
