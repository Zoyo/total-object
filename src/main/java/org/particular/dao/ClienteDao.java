package org.particular.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.particular.model.cliente.Cliente;
import org.particular.model.cliente.components.ID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(propagation=Propagation.SUPPORTS)
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

	public Cliente findById(ID id) {
		return this.getSession().get(Cliente.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Cliente> list() {
		Criteria criteria = this.getSession().createCriteria(Cliente.class);
		return criteria.list();
	}
}
