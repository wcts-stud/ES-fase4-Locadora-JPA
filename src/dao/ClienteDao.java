package dao;

import java.util.List;

import javax.persistence.Query;

import model.Cliente;

public class ClienteDao extends JpaDaoBase<Cliente> {
	
	
	public List<Cliente> pesquisaPorNome(String nomeMarca) {
		Query q = super.em.createNamedQuery("Marca.pesquisaPorNome");
		q.setParameter("nomeMarca", "%" + nomeMarca + "%");
		return q.getResultList();
	}
	
	public List<Cliente> listaTodosSimplificado(){
		Query q = super.em
					.createQuery(" select  new Marca(m.id, m.nome) "
				       + " from Marca m ");
		return q.getResultList();
	}
	
}
