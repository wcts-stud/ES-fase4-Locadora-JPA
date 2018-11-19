package dao;

import java.util.List;

import javax.persistence.EntityManager;

import jpa.ConnectionFactory;
import model.Dvd;

public class DvdDao {

	private EntityManager em = new ConnectionFactory().getEntityManager();
	
	
	/*
	 * Create
	 */
	public void salva(Dvd dvd) {		
		
		try {
			em.getTransaction().begin();
			em.persist(dvd);
			em.getTransaction().commit();
			
		} catch (Exception e) {
			System.err.println("Erro CREATE dvd: " +e);;
		} finally {
			em.close();
		}
		
	}
	
	
	
	/*
	 * Update
	 */
	public void atualiza(Dvd dvd) {
		
		try {
			em.getTransaction().begin();
			
			if ( dvd.getId() > 0 ){
				em.merge(dvd);
				em.getTransaction().commit();
			} else {
				// Se o id informado não existir: 
				//em.persist(dvd);
				System.out.println("\n\n\nID não existe");
			}
			
			//em.getTransaction().commit();
			
		} catch (Exception e) {
			System.err.println("Erro UPDATE dvd: " +e);
			em.getTransaction().rollback();
			
		} finally {
			em.close();
		}
		
	}
	
	
	
	/*
	 * Read by Id
	 */
	public Dvd pesquisa(int id) {
		Dvd d = new Dvd();
		
		if ( id > 0 ){
			
			try { 
				d = em.find(Dvd.class, id);
			} catch (Exception e){
				System.err.println("Erro READ dvd: " +e);
			} finally {
				em.close();
			}
			
		}
		
		return d;
	}
	
	
	
	/*
	 * Read all
	 */
	public List<Dvd> listaTodos() {

		List<Dvd> dvds = null;
		
		try {
			dvds = em.createQuery("from Dvd d").getResultList();
		} catch (Exception e) {
			System.err.println("Erro RESULT LIST dvd: " +e);
		} finally {
			em.close();
		}
		
		
		return dvds;
	}
	
	
	
	/*
	 * Delete
	 */
	public void remove(int id) {
		Dvd dvd = null;
		
		try {
			dvd = em.find(Dvd.class, id);
			if ( dvd != null ){
				em.getTransaction().begin();
				em.remove(dvd);
				em.getTransaction().commit();
			} else {
				System.out.println("\n\n\n\t Id " +id+ " de dvd não encontrado...");
			}
			
		} catch (Exception e) {
			System.err.println("Erro REMOVE dvd: " +e);
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
		
	}
	
}
