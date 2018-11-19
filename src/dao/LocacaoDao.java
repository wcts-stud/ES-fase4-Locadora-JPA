package dao;

import java.util.List;

import javax.management.Query;
import javax.persistence.EntityManager;

import org.hibernate.Session;

import jpa.ConnectionFactory;
import model.Dvd;
import model.Locacao;

public class LocacaoDao {

	private EntityManager em = new ConnectionFactory().getEntityManager();
	
	
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
	
	
	
	public void remove(int id) {
		Locacao l = null;
		
		try{ 
			l = em.find(Locacao.class, id);
			
			if ( l != null ) {
				em.getTransaction().begin();
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
	public Locacao listaTodos(){
		Query query = Session.
		List<Locacao> locacoes = Query.list();
		
		try {
			
		}
		
	}
	*/
	
}
