package com.xtglobal.datasource.config;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "bookEntityManagerFactory",
basePackages= {"com.xtglobal.datasource.repository.book"},
transactionManagerRef = "bookTransactionManager")
public class BookDBConfig 
{
	

	@Bean(name="bookDatasource")
	@ConfigurationProperties(prefix="spring.book.datasource")
	public DataSource dataSource()
	{
		return (DataSource) DataSourceBuilder.create().build();
		
	}

	
	@Bean(name="bookEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(EntityManagerFactoryBuilder builder,
			@Qualifier("bookDatasource") DataSource dataSource)
	{
		Map<String, Object> properties = new HashMap<>();
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.dialect", "org.hibernate.dialect.MYSQL5Dialect");
		return builder.dataSource(dataSource).properties(properties)
				.packages("com.xtglobal.datasource.model.book")
				.persistenceUnit("Book").build();
		
	}
	

	@Bean(name="bookTransactionManager")
	public PlatformTransactionManager transactionManager(
			@Qualifier("BookEntityManagerFactory") EntityManagerFactory entityManagerFactory)
	{
		return new JpaTransactionManager(entityManagerFactory);
		
	}
	
	

	
	

}
