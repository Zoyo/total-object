package org.particular.service;

import org.particular.dao.ClienteDao;
import org.particular.model.Cliente;
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
	
	public Cliente findClienteById(Long id) {
		log.debug("Load customer with id " + id);
		return clienteDao.findById(id);
	}
	
	public void addCliennte(Cliente cliente) {
		log.debug("Save customer " + cliente);
		clienteDao.save(cliente);
	}
}
