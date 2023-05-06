package com.mlfrog.infrastructure.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mlfrog.infrastructure.jpa.dao.Tester;

/*
 * JPA 사용 여부가 불분명하나, JPA 연동 유무를 확인하기 위해서 생성
 * 추후 실 클래스가 제공되면 삭제 예정
 */
public interface TesterRepository extends JpaRepository<Tester, Long> {
	
}
