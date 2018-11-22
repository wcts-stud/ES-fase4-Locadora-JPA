package dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.EntityManager;

import jpa.ConnectionFactory;
import model.Filme;

public class FilmeDao extends DaoBase {
	
	
	/*
	 * Create
	 */
	public String salva(Filme filme) {
		String status = null;
		
		try {
			em.getTransaction().begin();
			em.persist(filme);
			em.getTransaction().commit();
			status = "\n\t Inserido dvd com sucesso!!!";			
		} catch (Exception e) {
			System.err.println("Erro CREATE dvd: " +e);;
		} finally {
			//Non implement, implemented in other method
		}
		
		return status;
	}
		
	
	/*
	 * Read by Id - no used
	 */
	public Filme pesquisa(int id) {
		Filme f = new Filme();
		
		if ( id > 0 ){
			
			try { 
				f = em.find(Filme.class, id);
			} catch (Exception e){
				System.err.println("Erro READ filme: " +e);
			} finally {
				em.close();
			}
			
		}
		
		return f;
	}
	
	
	
	/*
	 * Read by name
	 */
	/*
	public Filme pesquisaByName(String titulo){
		Filme filme = null;
		
		SessionFactory sfac = new Configuration().configure().buildSessionFactory();
        Session se = sfac.openSession();
        Transaction tx = (Transaction) se.beginTransaction();
        Criteria crit = (Criteria) se.createCriteria(Filme.class);
        crit.a
        (Restrictions.eq("titulo", titulo));
		
		//@SuppressWarnings("deprecation")
		//SessionFactory sfac = new Configuration().configure().buildSessionFactory();
        //Session se = sfac.openSession();
		
        //Query select = em.createNamedQuery("from Filme as f where ilike f.titulo = :titulo");
		
		em.getTransaction().begin();
		Query q = (Query) em.createQuery("select m from Filme f where f.titulo ilike :titulo");
		//q.setParameter("titulo", "%" + titulo + "%");
		
		System.out.println("QUERY: \n" +q);
		return filme;
	}
	 */
		
	/*
	 * Read all
	 */
	public List<Filme> listaTodos() {

		List<Filme> filmes = null;
		
		try {
			filmes = em.createQuery("from Filme f").getResultList();
		} catch (Exception e) {
			System.err.println("Erro RESULT LIST filme: " +e);
		} finally {
			em.close();
		}
		
		
		return filmes;
	}
	
	
	/*
	
	/*
	 * Update
	 
	public void atualiza(Filme f) {
		
		try {
			em.getTransaction().begin();
			
			if ( f.getId() > 0 ){
				em.merge(f);
				em.getTransaction().commit();
			} else {
				// Se o id informado não existir: 
				//em.persist(dvd);
				System.out.println("\n\n\nID não existe");
			}
			
		} catch (Exception e) {
			System.err.println("Erro UPDATE dvd: " +e);
			em.getTransaction().rollback();
			
		} finally {
			em.close();
		}		
		
	}
	
		
	/*
	 * Delete
	 
	public void remove(int id) {
		Filme filme = null;
		
		try {
			filme = em.find(Filme.class, id);
			if (filme != null){
				em.getTransaction().begin();
				em.remove(filme);
				em.getTransaction().commit();
			} else {
				System.err.println("\n\n\t Falha ao remover dvd, null ou possui locação");
			}
			
		} catch (Exception e) {
			System.err.println("Erro REMOVE dvd: " +e);
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
		
	}
	
	*/
}
