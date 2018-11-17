package dao;

import javax.persistence.EntityManager;

import jpa.ConnectionFactory;
import model.Dvd;

public class DvdDao {

	private EntityManager em = new ConnectionFactory().getEntityManager();
	
	
	public void salva(Dvd dvd) {		
		
		try {
			em.getTransaction().begin();
			em.persist(dvd);
			em.getTransaction().commit();
			
		} catch (Exception e) {
			System.err.println("Erro: " +e);;
		} finally {
			em.close();
		}
		
	}
	
	
}
