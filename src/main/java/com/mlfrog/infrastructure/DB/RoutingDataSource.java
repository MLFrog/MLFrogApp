package com.mlfrog.infrastructure.DB;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import com.mlfrog.infrastructure.DB.dto.DatabaseType;

public class RoutingDataSource extends AbstractRoutingDataSource {
  
  @Override
  protected DatabaseType determineCurrentLookupKey() {
    return DatabaseContextHolder.getDatabaseType();
  }

}