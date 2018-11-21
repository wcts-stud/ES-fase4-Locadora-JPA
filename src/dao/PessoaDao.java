package dao;

import java.util.List;

import javax.persistence.EntityManager;

import jpa.ConnectionFactory;
import model.Pessoa;

public class PessoaDao {

	
private EntityManager em = new ConnectionFactory().getEntityManager();
	
	/*
	 * Create
	 */
	public String salva(Pessoa p) {
		String status = null;
		
		try {
			em.getTransaction().begin();
			em.persist(p);
			em.getTransaction().commit();
			status = "\n\t Inserido pessoa com sucesso!!!";
			
		} catch (Exception e) {
			System.err.println("Erro: " +e);;
		} finally {
			em.close();
		}
		
		return status;
	}
	
	
	/*
	 * Read by Id
	 */
	public Pessoa pesquisa(int id) {
		Pessoa c = new Pessoa();
		
		if ( id > 0 ){
			
			try { 
				c = em.find(Pessoa.class, id);
			} catch (Exception e){
				System.err.println("Erro READ pessoa: " +e);
			} finally {
				//Non implement, close in other method
			}			
		}
		
		return c;
	}
	
	
	/*
	 * Read all
	 */
	public List<Pessoa> listaTodos() {
		List<Pessoa> Pessoas = null;
		
		try {
			Pessoas = em.createQuery("from Pessoa p").getResultList();
		} catch (Exception e) {
			System.err.println("Erro RESULT LIST pessoas: " +e);
		} finally {
			em.close();
		}
		
		
		return Pessoas;
	}
	
	
	/*
	 * Update
	 */
	public void atualiza(Pessoa p) {
		
		try {
			em.getTransaction().begin();
			if (p.getId() > 0){
				em.merge(p);
				em.getTransaction().commit();
			} else {
				// Se o id informado não existir
				System.out.println("\n\n\nID não existe");
			}
		} catch (Exception e) {
			System.err.println("Erro UPDATE pessoa: " +e);
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
		
	}
	
	
	/*
	 * Delete
	 */
	public void remove(int id){		
		Pessoa p = null;
				
		try {
			p = em.find(Pessoa.class, id);
		
			if (p != null) {
				em.getTransaction().begin();
				em.remove(p);
				em.getTransaction().commit();				
			} else {
				System.err.println("\n\tFalha ao remover pessoa, nulo ou possui locação");
			}
			
		} catch (Exception e) {
			System.err.println("Erro na remocao de pessoa: " +e);
			em.getTransaction().rollback();
			
		} finally {
			em.close();
		}
		
	}
	
}
