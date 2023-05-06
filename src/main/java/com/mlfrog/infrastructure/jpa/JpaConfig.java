package com.mlfrog.infrastructure.jpa;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

/**
 * Mysql DataSource가 기본으로 되어있으며, 테스트 코드 실행할 땐, h2로 @Primary 변경 후 사용하면 됩니다.
 * entityManagerFactoryRef = "entityManagerFactoryMysql" 를 주석 처리하면 됩니다.
 * (기본 값이 H2로 지정되어 있음)
 * @author 최현호
 *
 */

@Configuration
@EnableJpaRepositories(
		basePackages = {"com.mlfrog.infrastructure.jpa.repository"}
//		entityManagerFactoryRef = "entityManagerFactoryMysql"
		)
public class JpaConfig {
	/*
	 * Spring Boot 기본 설정으로 사용.
	 * 추후 Entity Manager Factory 및 TransactionManager를 구현해야하면 여기서 진행 
	 */
	
	@Autowired
	@Qualifier("mysqlDataSource")
	private DataSource mysqlDataSource;
	
	@Autowired
	@Qualifier("h2DataSource")
	private DataSource h2DataSource;
	
	@Bean
//	@Primary
	@Qualifier("mysql")
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryMysql() {
	    LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
	    em.setDataSource(mysqlDataSource);
	    em.setPackagesToScan("com.mlfrog.infrastructure.jpa.dao");
	    em.setPersistenceUnitName("mysql");
	    
	    JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	    em.setJpaVendorAdapter(vendorAdapter);

	    Map<String, Object> jpaProperties = new HashMap<>();
	    jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
	    jpaProperties.put("hibernate.hbm2ddl.auto", "update");
	    em.setJpaPropertyMap(jpaProperties);

	    em.setPersistenceProvider(new HibernatePersistenceProvider());
	    return em;
	}
	
	@Bean
	@Primary
	@Qualifier("h2")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
	    LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
	    em.setDataSource(h2DataSource);
	    em.setPackagesToScan("com.mlfrog.infrastructure.jpa.dao");
	    em.setPersistenceUnitName("h2");
	    
	    JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	    em.setJpaVendorAdapter(vendorAdapter);

	    Map<String, Object> jpaProperties = new HashMap<>();
	    jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
	    jpaProperties.put("hibernate.hbm2ddl.auto", "update");
	    em.setJpaPropertyMap(jpaProperties);

	    em.setPersistenceProvider(new HibernatePersistenceProvider());
	    return em;
	}
}
