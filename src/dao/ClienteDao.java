package dao;

import java.util.List;
import model.Cliente;

public class ClienteDao extends DaoBase {
	
	/*
	 * Create
	 */
	public String salva(Cliente c) {
		String status = null;
		
		try {
			em.getTransaction().begin();
			em.persist(c);
			em.getTransaction().commit();
			status = "\n\t Inserido cliente com sucesso!!!";
			
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
	public Cliente pesquisa(int id) {
		Cliente c = new Cliente();
		
		if ( id > 0 ){
			
			try { 
				c = em.find(Cliente.class, id);
			} catch (Exception e){
				System.err.println("Erro READ cliente: " +e);
			} finally {
				// Non implement, implemented in other method;
			}
			
		}
		
		return c;
	}
	
	
	/*
	 * Read all
	 */
	public List<Cliente> listaTodos() {

		List<Cliente> clientes = null;
		
		try {
			clientes = em.createQuery("from Cliente d").getResultList();
		} catch (Exception e) {
			System.err.println("Erro RESULT LIST clientes: " +e);
		} finally {
			em.close();
		}
		
		
		return clientes;
	}
	
	
	/*
	 * Update
	 */
	public void atualiza(Cliente c) {
		
		try {
			em.getTransaction().begin();
			if (c.getId() > 0){
				em.merge(c);
				em.getTransaction().commit();
			} else {
				// Se o id informado não existir
				System.out.println("\n\n\nID não existe");
			}
		} catch (Exception e) {
			System.err.println("Erro UPDATE cliente: " +e);
			em.getTransaction().rollback();
		} finally {
			//Non implement, close in other method
		}
		
	}
	
	
	/*
	 * Delete
	 */
	public void remove(int id){		
		Cliente c = null;
				
		try {
			c = em.find(Cliente.class, id);
		
			if (c != null && c.isLocacao() == false) {
				em.getTransaction().begin();
				em.remove(c);
				em.getTransaction().commit();				
			} else {
				System.err.println("\n\tFalha ao remover cliente, nulo ou possui locação");
			}
			
		} catch (Exception e) {
			System.err.println("Erro na remocao de cliente: " +e);
			em.getTransaction().rollback();
			
		} finally {
			em.close();
		}
		
	}
	
	
	
	/*
	 * Deletar para envio
	 */
	/*
	public List<Cliente> pesquisaPorNome(String nomeMarca) {
		Query q = em.createNamedQuery("Marca.pesquisaPorNome");
		q.setParameter("nomeMarca", "%" + nomeMarca + "%");
		return q.getResultList();
	}
	
	public List<Cliente> listaTodosSimplificado(){
		Query q = em.createQuery(" select  new Marca(m.id, m.nome) "
				       + " from Marca m ");
		return q.getResultList();
	}
	*/
}
