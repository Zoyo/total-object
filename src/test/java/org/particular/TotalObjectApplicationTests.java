package org.particular;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.particular.dao.ClienteDao;
import org.particular.model.cliente.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TotalObjectApplicationTests {
	@Autowired
	private ClienteDao clienteDao;

	@Test
	public void whenListClientes_thenOK() {
		List<Cliente> clientes = clienteDao.list();
		System.out.println(clientes);
		assertFalse(clientes.isEmpty());
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
