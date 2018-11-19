package dao;

import java.util.List;

import javax.persistence.EntityManager;
import jpa.ConnectionFactory;
import model.Locacao;

public class LocacaoDao {

	private EntityManager em = new ConnectionFactory().getEntityManager();
	
	/*
	 * Create
	 */
	public void salva(Locacao l) {
		
		try {
			em.getTransaction().begin();
			em.persist(l);
			em.getTransaction().commit();
			
		} catch (Exception e) {
			System.err.println("Erro: " +e);;
		} finally {
			em.close();
		}
	}
	
	
	/*
	 * Read by Id 
	 */
	public Locacao pesquisa(int id) {
		Locacao l = null;
		
		try {
			if ( id > 0 ) {
				em.getTransaction().begin();
				l = em.find(Locacao.class, id);
			}
		} catch (Exception e) {
			System.err.println("Erro READ locacao: " +e);
		}
		
		return l;
	}
	

	/*
	 * Read all;
	 */
	public List<Locacao> listaTodos() {
		List<Locacao> locacoes = null;
		
		try {
			locacoes = em.createQuery("from Locacao l").getResultList();
		} catch (Exception e) {
			System.err.println("Erro RESULT LIST locacao: " +e);
		} finally {
			em.close();
		}		
		
		return locacoes;
	}
	
	
	/*
	 * Update
	 */
	// Non implement	
	
	
	/*
	 * Delete
	 */
	public void remove(int id) {
		Locacao l = null;

		
		try{
			//em.getTransaction().begin();
			l = em.find(Locacao.class, id);
			
			if ( l != null ) {
				em.remove(l);
				em.getTransaction().commit();
			} else {
				System.out.println("\n\n\n\t Id " +id+ " de locação não encontrado...");
			}
		} catch (Exception e) {
			System.err.println("Erro: " +e);
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}


	
	
}
