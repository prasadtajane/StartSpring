package com.prasad.learnspring.api;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@PropertySource(value="classpath:config.properties")
public class JPAConfig {
	
	@Autowired
	private Environment env;

	@Bean
	public LocalContainerEntityManagerFactoryBean emf()	{
		
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		//The above line is equivalent to -
		//<provider>org.hibernate.jpa.HibernatePersistenceProvider</provider>
		emf.setDataSource(getDataSource());
		emf.setPackagesToScan("com.prasad.learnspring.api.entity");
		emf.setJpaProperties(jpaProperties());

		return emf;
	}

	
	@Bean
	public DataSource getDataSource()	{

		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		//ds.setUrl("jdbc:mysql://localhost:3306/weather-db?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
		ds.setUrl(env.getProperty("db.url", "jdbc:mysql://localhost:3306/weather-db?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"));
		ds.setUsername(env.getProperty("db.user", "root"));
		ds.setPassword(env.getProperty("db.password", "root1"));

		return ds;
	}
	
	
	@Bean
	public PlatformTransactionManager txnMngr (EntityManagerFactory emf)	{
		return new JpaTransactionManager(emf);
	}
	
	
	private Properties jpaProperties()	{
		Properties props = new Properties();
		props.setProperty("hibernate.format_sql", env.getProperty("hiber.formatsql", "true"));
		props.setProperty("hibernate.show_sql", env.getProperty("hiber.showsql", "true"));
		props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		props.setProperty("hibernate.hbm2ddl.auto", env.getProperty("hiber.hbm2ddl", "create"));
		//props.setProperty("cascade", "CascadeType.ALL");
		
		return props;
	}
}
