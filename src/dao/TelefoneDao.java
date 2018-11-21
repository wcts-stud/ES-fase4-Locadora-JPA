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
			Telefone d = new Telefone();
			
			if ( id > 0 ){
				
				try { 
					d = em.find(Telefone.class, id);
				} catch (Exception e){
					System.err.println("Erro READ Telefone: " +e);
				} finally {
					//em.close();
				}
				
			}
			
			return d;
		}
		
		
		/*
		 * Read all
		 */
		public List<Telefone> listaTodos() {

			List<Telefone> Telefones = null;
			
			try {
				Telefones = em.createQuery("from Telefone d").getResultList();
			} catch (Exception e) {
				System.err.println("Erro RESULT LIST Telefone: " +e);
			} finally {
				em.close();
			}
			
			
			return Telefones;
		}
		
		
		/*
		 * Update
		 */
		public void atualiza(Telefone Telefone) {
			
			try {
				em.getTransaction().begin();
				
				if ( Telefone.getId() > 0 ){
					em.merge(Telefone);
					em.getTransaction().commit();
				} else {
					// Se o id informado não existir: 
					//em.persist(Telefone);
					System.out.println("\n\n\nID não existe");
				}
				
			} catch (Exception e) {
				System.err.println("Erro UPDATE Telefone: " +e);
				em.getTransaction().rollback();
				
			} finally {
				em.close();
			}		
			
		}
		
		
		/*
		 * Delete
		 */
		public void remove(int id) {
			Telefone Telefone = null;
			
			try {
				Telefone = em.find(Telefone.class, id);
				if (Telefone != null){
					em.getTransaction().begin();
					em.remove(Telefone);
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
