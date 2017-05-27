package org.particular;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.particular.dao.ClienteDao;
import org.particular.model.cliente.Cliente;
import org.particular.model.cliente.components.CPF;
import org.particular.model.cliente.components.Fone;
import org.particular.model.cliente.components.ID;
import org.particular.model.cliente.components.Nome;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TotalObjectApplicationTests {
	@Autowired
	private ClienteDao clienteDao;
	private EmbeddedDatabase db;
	
	@Before
	public void setup() {
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		db = builder.setType(EmbeddedDatabaseType.HSQL).addScripts("classpath:schema.sql", "classpath:data.sql").build();
		
	}
	
	@After
	public void finish() {
		db.shutdown();
	}
	
	@Test
	public void whenListClientes_thenOK() {
		List<Cliente> clientes = clienteDao.list();
		System.out.println(clientes);
		assertFalse(clientes.isEmpty());
	}
	
	@Test
	public void whenLoadByValidID_thenOK() throws Exception {
		Cliente cliente2 = clienteDao.findById(new ID(2L));
		assertEquals("ERIKA GOMES DO NASCIMENTO", cliente2.getNome().get());
		assertEquals("2587458932", cliente2.getCpf().get());
		assertEquals("(19)12345-1234", cliente2.getFone().get());
	}
	
	@Test
	public void whenAddNewCliente_thenOK() throws Exception {
		Cliente cliente = new Cliente();
		cliente.setId(new ID(3L));
		cliente.setNome(new Nome("Isso é só um teste"));
		cliente.setCpf(new CPF("12345678900"));
		cliente.setFone(new Fone("(12)3456-7890"));
		clienteDao.save(cliente);
		
		cliente = null;
		
		Cliente clienteRecente = clienteDao.findById(new ID(3L));
		assertEquals("Isso é só um teste", clienteRecente.getNome().get());
		assertEquals("12345678900", clienteRecente.getCpf().get());
		assertEquals("(12)3456-7890", clienteRecente.getFone().get());
	}
}

/*
 * https://www.google.com.br/search?q=spring+hsql+in+memory&oq=spring+hsql+in+memory&aqs=chrome..69i57.41334j0j1&sourceid=chrome&ie=UTF-8
 * https://www.mkyong.com/spring/spring-embedded-database-examples/
 * https://www.google.com.br/search?q=hibernate+with+hsql+db&oq=hibernate+with+hsql+db&aqs=chrome..69i57.5944j0j1&sourceid=chrome&ie=UTF-8#q=spring+hibernate+hsql
 * https://gist.github.com/twasink/2881461
 * https://stackoverflow.com/questions/36384367/using-hsqldb-as-a-portable-database-with-spring-hibernate
 * http://projects.spring.io/spring-boot/
 * https://www.google.com.br/search?q=hibernate+embedded+and+embedabble&oq=hibernate+embedded+and+embedabble&aqs=chrome..69i57.11759j0j1&sourceid=chrome&ie=UTF-8#q=hibernate+embedded+and+embeddable
 * http://www.concretepage.com/hibernate/example-embeddable-embedded-hibernate-annotation
 * https://www.google.com.br/search?q=spring+embedded+database+java+config&oq=spring+embedded+database+java+config&aqs=chrome..69i57.9409j0j1&sourceid=chrome&ie=UTF-8#q=spring+hibernate+database+java+config
 * https://stackoverflow.com/questions/16038360/initialize-database-without-xml-configuration-but-using-configuration
 * https://dzone.com/articles/springhibernate-application
 * https://www.google.com.br/search?q=spring+hibernate+5+getsession&oq=spring+hibernate+5+getsession&aqs=chrome..69i57.7491j0j1&sourceid=chrome&ie=UTF-8
 * http://www.bytestree.com/hibernate/spring-4-hibernate-5-example/
 */
