package com.sampark.digitalCrm.configuration;

import java.util.Properties;

import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = { "com.sampark.digitalCrm.repository" })
@EnableTransactionManagement
public class DatabaseConfig {
	String url = "useSSL=false";

	@Bean
	public DriverManagerDataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/leadsdb?" + url);
		dataSource.setUsername("root");
		dataSource.setPassword("root");

		/*
		 * dataSource.setUrl("jdbc:mysql://103.240.91.180:3306/leaddb?"+url);
		 * dataSource.setUsername("sampark"); dataSource.setPassword("Se2fc@re");
		 */

		// dataSource.setUrl("jdbc:mysql://localhost:3306/leaddb?"+url);
		// dataSource.setUsername("sampark");
		// dataSource.setPassword("Se2fc@re");
		return dataSource;
	}

	@Bean
	@Autowired
	public PlatformTransactionManager getTransactionManager(EntityManagerFactory emf) throws NamingException {
		JpaTransactionManager jpaTransaction = new JpaTransactionManager();
		jpaTransaction.setEntityManagerFactory(emf);
		return jpaTransaction;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean getEMF() {

		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setDataSource(getDataSource());
		emf.setPackagesToScan("com.sampark.digitalCrm.entity");
		emf.setPersistenceUnitName("spring-jpa-unit");
		emf.setJpaVendorAdapter(getHibernateAdapter());

		emf.setJpaProperties(hibernateProperties());
		return emf;
	}

	@Bean
	public JpaVendorAdapter getHibernateAdapter() {

		return new HibernateJpaVendorAdapter();
	}

	private Properties hibernateProperties() {
		return new Properties() {
			{
				setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
				setProperty("hibernate.hbm2ddl.auto", "update");
				setProperty("hibernate.show_sql", "true");
				setProperty("hibernate.format_sql", "false");
			}
		};
	}
}
