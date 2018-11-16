package test;

import javax.persistence.EntityManager;

import jpa.ConnectionFactory;
import ui.InterfaceCliente;
import ui.InterfacePrincipal;

public class LocacaoTest {
	
	
	
	public static void main(String[] args) {
		
		EntityManager em = ConnectionFactory.getEntityManager();
		
		
		em.getTransaction().begin();
		
		
	}
	
	
	
	/*
	public static void main(String[] args){
		
		
		
		InterfacePrincipal ic = new InterfacePrincipal();
		
		ic.menuPrincipal();
		
		
		
	}
	*/

}
