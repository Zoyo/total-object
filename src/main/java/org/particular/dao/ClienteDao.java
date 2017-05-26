package org.particular.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.particular.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ClienteDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public Cliente save(Cliente cliente) {
		this.getSession().save(cliente);
		return cliente; 
	}
	
	public Cliente findById(Long id) {
		return this.getSession().get(Cliente.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Cliente> list() {
		Criteria criteria = this.getSession().createCriteria(Cliente.class);
		return criteria.list();
	}
}
