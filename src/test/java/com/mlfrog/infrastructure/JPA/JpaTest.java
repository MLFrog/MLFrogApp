package com.mlfrog.infrastructure.JPA;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.orm.jpa.EntityManagerFactoryUtils;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import com.mlfrog.infrastructure.jpa.dao.Tester;
import com.mlfrog.infrastructure.jpa.repository.TesterRepository;

import lombok.extern.slf4j.Slf4j;


@SpringBootTest
@Transactional
@ExtendWith(SpringExtension.class)
@Slf4j
public class JpaTest {
	
//  자동 주입을 사용하는 경우 활성화 할 테스트 코드	
//	@Autowired
//	private EntityManagerFactory entityManagerFactory;
	
	@Autowired
	@Qualifier("mysql")
	private LocalContainerEntityManagerFactoryBean entityManagerFactory;
	
	@Autowired
	@Qualifier("h2")
	private LocalContainerEntityManagerFactoryBean entityManagerFactoryH2;
	
	@Autowired
	private TesterRepository testerRepository;
    
    @Test
    public void fullTests() {
    	Tester tester = new Tester();
        tester.setName("John");
        tester.setAge(30);
        
        Tester savedTester = testerRepository.save(tester);

        assertThat(savedTester).isNotNull();
        assertThat(savedTester.getId()).isGreaterThan(0);
        assertThat(savedTester.getName()).isEqualTo(tester.getName());
        assertThat(savedTester.getAge()).isEqualTo(tester.getAge());
        
        
        List<Tester> testList = testerRepository.findAll();

        log.info("give me the list : " + testList);
        
        assertThat(testList).isNotNull();
        assertThat(testList).hasSize(1); // 예상되는 데이터 개수로 수정

        Tester tester1 = testList.get(0);
        assertThat(tester1).isNotNull();
        assertThat(tester1.getId()).isGreaterThan(0);
        
        log.info("one : " + tester1.toString());

        testerRepository.deleteById(savedTester.getId());

        Optional<Tester> deletedTester = testerRepository.findById(savedTester.getId());
        assertThat(deletedTester).isEmpty();
    }
  
  // 사용중인 DB 확인
  @Test
  public void testDatabase() {
      EntityManager entityManager = EntityManagerFactoryUtils.getTransactionalEntityManager(entityManagerFactory.getObject());
  	  Session session = entityManager.unwrap(Session.class);

      String databaseName = session.doReturningWork(connection -> connection.getCatalog());
      log.info("Current database name: " + databaseName);
      
      EntityManager entityManagerH2 = EntityManagerFactoryUtils.getTransactionalEntityManager(entityManagerFactoryH2.getObject());
      Session sessionH2 = entityManagerH2.unwrap(Session.class);

      String databaseNameH2 = sessionH2.doReturningWork(connection -> connection.getCatalog());
      log.info("Current database name: " + databaseNameH2);
  }
	
      // 자동 주입을 설정했었을때 사용하는 테스트 코드.
//    @Test
//    public void testDatabase() {
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//    	  Session session = entityManager.unwrap(Session.class);
//
//        String databaseName = session.doReturningWork(connection -> connection.getCatalog());
//        log.info("Current database name: " + databaseName);
//    }
    
      // 쓰레드를 통한 JPA의 DataSource 변경은 통하지 않음
//    @Test
//    public void DBRoute테스트() {
//        Session session = entityManager.unwrap(Session.class);
//        String databaseName = session.doReturningWork(connection -> connection.getCatalog());
//        log.info("Current database name: " + databaseName);
//        
//        DatabaseContextHolder.setDatabaseType(DatabaseType.MYSQL);
//
//        databaseName = session.doReturningWork(connection -> connection.getCatalog());
//        log.info("Current database name: " + databaseName);
//    }    
}


