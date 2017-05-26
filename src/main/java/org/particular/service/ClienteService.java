package org.particular.service;

import org.particular.dao.ClienteDao;
import org.particular.model.cliente.Cliente;
import org.particular.model.cliente.components.ID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class ClienteService {

	private static final Logger log = LoggerFactory.getLogger(ClienteService.class);

	@Autowired
	private ClienteDao clienteDao;

	public Cliente findClienteById(ID id) {
		log.debug("Load customer with id " + id);
		return clienteDao.findById(id);
	}

	@Transactional(readOnly = false)
	public void addCliennte(Cliente cliente) {
		log.debug("Save customer " + cliente);
		clienteDao.save(cliente);
	}
}
