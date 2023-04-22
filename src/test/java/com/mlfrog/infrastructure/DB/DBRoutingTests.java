package com.mlfrog.infrastructure.DB;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.transaction.annotation.Transactional;

import com.mlfrog.infrastructure.DB.dto.DatabaseType;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
//@Transactional
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Slf4j
public class DBRoutingTests {
	
	@Autowired
	@Qualifier("mysqlDataSource")
	private DataSource dataSource;
	  
//    @Autowired
//    private JdbcTemplate jdbcTemplate;

	
//	@BeforeEach
//	void setUp() throws Exception {
//	  // h2 데이터베이스에 테이블 생성
//	  try (Connection conn = DataSourceUtils.getConnection(dataSource)) {
//	    PreparedStatement pstmt = conn.prepareStatement("CREATE TABLE user (id BIGINT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(255) NOT NULL, age INT NOT NULL)");
//	    pstmt.executeUpdate();
//	  }
//	
//	  // h2 데이터베이스에 데이터 insert
//	  jdbcTemplate.update("INSERT INTO user (name, age) VALUES (?, ?)", "John", 25);
//	  jdbcTemplate.update("INSERT INTO user (name, age) VALUES (?, ?)", "Mary", 30);
//	}
	
	@Test
	public void H2디비테스트() {
		DatabaseContextHolder.setDatabaseType(DatabaseType.H2);
		
		assertEquals(DatabaseContextHolder.getDatabaseType(), DatabaseType.H2);
	}
	
	@Test
	public void Mysql디비테스트() {
		DatabaseContextHolder.setDatabaseType(DatabaseType.MYSQL);
		
		assertEquals(DatabaseContextHolder.getDatabaseType(), DatabaseType.MYSQL);
	}
	
    @Test
    void testConnection() throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
        	log.info("나는 누구? : " + connection.toString());
            assertThat(connection.isValid(1)).isTrue();
        }
    }
}
