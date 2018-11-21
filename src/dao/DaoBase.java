package dao;

import javax.persistence.EntityManager;

import jpa.ConnectionFactory;

public class DaoBase {
	
	protected EntityManager em = new ConnectionFactory().getEntityManager();

}
