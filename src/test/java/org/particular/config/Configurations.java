package org.particular.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@PropertySource(value = { "classpath:application.properties" })
public class Configurations {
	
	@Bean
	public DataSource getDataSource() {
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		builder.setType(EmbeddedDatabaseType.HSQL).addScript("schema.sql").addScript("data.sql");
		return builder.build();
	}

	/*
	 * 
	 * Abaixo, seria bom quebrar em arquivo de configuração específico para repositórios.
	 * 
	 */
	
	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory);
		return transactionManager;
	}
	
	@Bean
	public HibernateTemplate getHiberanteTemplate(SessionFactory sessionFactory) {
		HibernateTemplate hibernateTemplate = new HibernateTemplate(sessionFactory);
		return hibernateTemplate;
	}
	
	@Bean
	public LocalSessionFactoryBean getSessionFactory() {
		LocalSessionFactoryBuilder lsfb = new LocalSessionFactoryBuilder(getDataSource());
		lsfb.scanPackages("org.particular");
		lsfb.setProperties(getHibernateProperties());
		return null;
	}

	@Bean
	public Properties getHibernateProperties() {
		Properties hp = new Properties();
        hp.put("hibernate.dialect", "org.hibernate.dialect.HSQLDialect");
        hp.put("hibernate.show_sql", "true");
        hp.put("hibernate.hbm2ddl.auto", "create-drop");
        hp.put("hibernate.show_sql", "true");
		return hp;
	}
	
}


/*
################### JDBC Configuration ##########################
jdbc.driverClassName=org.hsqldb.jdbcDriver
jdbc.url=jdbc:hsqldb:file:db/SivaLabsDB;shutdown=true
jdbc.username=sa
jdbc.password=

################### Hibernate Configuration ##########################
hibernate.dialect=org.hibernate.dialect.HSQLDialect
hibernate.show_sql=true
hibernate.hbm2ddl.auto=update
hibernate.generate_statistics=true
*/