package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import jpa.ConnectionFactory;
import model.Cliente;
import model.Dvd;

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
	
	
	public void remove(int id){
		Cliente c = null;
		
		try {
			c = em.find(Cliente.class, id);
		
			if (c != null) {
				em.getTransaction().begin();
				em.remove(c);
				em.getTransaction().commit();				
			}
			
		} catch (Exception e) {
			System.err.println("Erro na remocao de cliente: " +e);
			em.getTransaction().rollback();
			
		} finally {
			em.close();
		}
		
	}
	
	
	

	/*
	 * Read all
	 */
	public List<Cliente> listaTodos() {

		List<Cliente> clientes = null;
		
		try {
			clientes = em.createQuery("from Cliente d").getResultList();
		} catch (Exception e) {
			System.err.println("Erro RESULT LIST clientes: " +e);
		} finally {
			em.close();
		}
		
		
		return clientes;
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
