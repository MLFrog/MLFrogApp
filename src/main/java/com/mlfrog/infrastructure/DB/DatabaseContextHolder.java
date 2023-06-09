package com.mlfrog.infrastructure.DB;

import com.mlfrog.infrastructure.DB.dto.DatabaseType;

public class DatabaseContextHolder {
	  private static final ThreadLocal<DatabaseType> contextHolder = new ThreadLocal<>();

	  public static void setDatabaseType(DatabaseType type) {
	    contextHolder.set(type);
	  }

	  public static DatabaseType getDatabaseType() {
	    return contextHolder.get();
	  }

	  public static void clearDatabaseType() {
	    contextHolder.remove();
	  }
	}
