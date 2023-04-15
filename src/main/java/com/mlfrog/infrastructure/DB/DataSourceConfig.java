package com.mlfrog.infrastructure.DB;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.mlfrog.infrastructure.DB.dto.DatabaseType;

@Configuration
public class DataSourceConfig {

	  @Bean
	  @ConfigurationProperties("spring.datasource.mysql")
	  public DataSource mysqlDataSource() {
	    return DataSourceBuilder.create().build();
	  }
	  
	  @Bean
	  @ConfigurationProperties("spring.datasource.h2")
	  public DataSource h2DataSource() {
	    return DataSourceBuilder.create().build();
	  }

	  @Bean
	  @Primary
	  public DataSource routingDataSource(@Qualifier("mysqlDataSource") DataSource mysqlDataSource, @Qualifier("h2DataSource") DataSource h2DataSource) {
	    Map<Object, Object> targetDataSources = new HashMap<>();
	    targetDataSources.put(DatabaseType.MYSQL, mysqlDataSource);
	    targetDataSources.put(DatabaseType.H2, h2DataSource);
	    
	    RoutingDataSource routingDataSource = new RoutingDataSource();
	    routingDataSource.setTargetDataSources(targetDataSources);
	    routingDataSource.setDefaultTargetDataSource(h2DataSource);
	    
	    return routingDataSource;
	  }

}
