package dao;

import java.util.List;

import javax.persistence.EntityManager;

import jpa.ConnectionFactory;
import model.Dvd;

public class DvdDao extends DaoBase {

	
	/*
	 * Create
	 */
	public String salva(Dvd dvd) {
		String status = null;
		
		try {
			em.getTransaction().begin();
			em.persist(dvd);
			em.getTransaction().commit();
			status = "\n\t Inserido dvd com sucesso!!!";			
		} catch (Exception e) {
			System.err.println("Erro CREATE dvd: " +e);;
		} finally {
			em.close();
		}
		
		return status;
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
				// Non implement, implemented in other method;
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
	 */
	public void remove(int id) {
		Dvd dvd = null;
		
		try {
			dvd = em.find(Dvd.class, id);
			if (dvd != null && dvd.isLocacao() == false){
				em.getTransaction().begin();
				em.remove(dvd);
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
	
}
