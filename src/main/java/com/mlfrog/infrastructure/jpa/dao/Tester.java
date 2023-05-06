package com.mlfrog.infrastructure.jpa.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

/*
 * JPA 사용 여부가 불분명하나, JPA 연동 유무를 확인하기 위해서 생성
 * 추후 실 클래스가 제공되면 삭제 예정
 */
@Entity
@Data
public class Tester {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private int age;
}
