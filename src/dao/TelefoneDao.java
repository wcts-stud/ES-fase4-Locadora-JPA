package dao;

import java.util.List;

import javax.persistence.EntityManager;

import jpa.ConnectionFactory;
import model.Telefone;

public class TelefoneDao {

		private EntityManager em = ConnectionFactory.getEntityManager();
		
		
		/*
		 * Create
		 */
		public String salva(Telefone Telefone) {
			String status = null;
			
			try {
				em.getTransaction().begin();
				em.persist(Telefone);
				em.getTransaction().commit();
				status = "\n\t Inserido Telefone com sucesso!!!";			
			} catch (Exception e) {
				System.err.println("Erro CREATE Telefone: " +e);;
			} finally {
				//Non implement, close in other method
			}
			
			return status;
		}
		
		
		/*
		 * Read by Id
		 */
		public Telefone pesquisa(int id) {
			Telefone telefone = new Telefone();
			
			if ( id > 0 ){
				
				try { 
					telefone = em.find(Telefone.class, id);
				} catch (Exception e){
					System.err.println("Erro READ Telefone: " +e);
				} finally {
					em.close();
				}
				
			}
			
			return telefone;
		}
		
		
		/*
		 * Read all
		 */
		public List<Telefone> listaTodos() {

			List<Telefone> telefone = null;
			
			try {
				telefone = em.createQuery("from Telefone d").getResultList();
			} catch (Exception e) {
				System.err.println("Erro RESULT LIST Telefone: " +e);
			} finally {
				em.close();
			}
			
			
			return telefone;
		}
		
		
		/*
		 * Update
		 */
		public void atualiza(Telefone Telefone) {

			// Non implement
			
		}
		
		
		/*
		 * Delete
		 */
		public void remove(int id) {
			Telefone telefone = null;
			
			try {
				telefone = em.find(Telefone.class, id);
				if (telefone != null){
					em.getTransaction().begin();
					em.remove(telefone);
					em.getTransaction().commit();
				} else {
					System.err.println("\n\n\t Falha ao remover Telefone, null ou possui locação");
				}
				
			} catch (Exception e) {
				System.err.println("Erro REMOVE Telefone: " +e);
				em.getTransaction().rollback();
			} finally {
				em.close();
			}
			
		}
		
	
	
}
