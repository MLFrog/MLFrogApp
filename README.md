# InfraStructure

1. Spring Security  
2. Spring Data JPA(지금은 서버가 없어서 제외)  

# Spring Security 임시 계정

id : admin  
password : admin

# Spring Boot Version

생성 환경
openjdk version "11.0.13" 2021-10-19

java : 11  
boot : 2.7.9
* 자바 버전이 맞지 않는 경우 작동하지 않거나 error 발생 가능성이 많으므로 위 버전으로 맞출것 최소 java 11로 맞춰서 진행할 것

# Test 환경 DB
H2 Database 사용
메모리 DB이므로, 서버 종료시 담겨있던 데이터가 지워진다.
사용 방법
url : localhost:8080/h2-console

# Swagger
url : localhost:8080/swagger-ui/index.html


### 추가 작업 필요  
레디스  
Mybatis  
JPA
