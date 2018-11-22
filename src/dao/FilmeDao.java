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

}
