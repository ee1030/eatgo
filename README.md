# eatgo

## 프로젝트 개요
eatgo 프로젝트는 간단한 레스토랑 예약 사이트의 백엔드 공부용으로 시작한 프로젝트입니다.
Java(JDK13)와 SpringBoot, H2-DataBase, Gradle 등을 활용하여 제작하였으며, 레스토랑의 정보의 CRUD 기능과
유저, 어드민 계정의 CRUD기능과 로그인을 통한 간단한 리뷰 작성 기능을 구현하였습니다.
프론트엔드 단이 없고 백엔드 프로세스만 개발하여 터미널을 이용하여 http를 이용해 제대로 데이터들이 입력 되었는지 확인하였습니다.

## 프로젝트 기본 로직
![Eatgo Basic Logic](https://user-images.githubusercontent.com/51356655/85255416-3200cd80-b49d-11ea-8214-8951b46e0e40.jpeg)

## 주요 기능
- 유저 등록 및 조회, 수정, 삭제기능(등록 외에는 Admin 계정만 가능)
- 레스토랑 생성, 조회, 수정, 삭제 기능(일반 이용자는 작성 불가)
- 등록된 유저의 패스워드 암호화(Spring Security의 PasswordEncrypt를 통해 암호화)
- 로그인 기능(JWT를 이용하여 액세스 토큰을 발급하고, authentication을 통해 인증)
- 레스토랑에 대한 리뷰 작성(리뷰 작성시 AccessToken을 Parameter로 함께 전달하여 Filter에서 유효성 검사 후 인증된 사용자만 작성 가능)

## 학습 내용
### TDD(테스트 주도 개발) 방식
모듈화와 리팩토링, 유지보수를 용이하게 만들기 위한 방법들과 기능들을 서버에 직접 배포하지 않고 스프링의 MVC 동작을 재현할 수 있는 방법등을 학습

- 테스트 케이스 작성
- MockMvc

### Layerd 아키텍쳐
프로젝트에 레이어를 나누어 관리하는 법을 학습

- UI(컨트롤러)
- Application(서비스 로직, Mock)
- Domain(정보 관리 및 JPA를 이용한 영속화)

### RestAPI
기본적인 CRUD 기능을 HTTP 기반으로 자원에 접근하는 REST를 이용한 RestAPI를 이용하여 구현하는 방법을 학습

- GET Mapping
- POST Mapping
- PUT/PATCH Mapping
- Delete Mapping
- RestAPI에 필요한 각종 어노테이션(@RequstMapping, @RequestBody, @PathVariable 등)

### JWT(JSON Web Token) & Spring Security
Status를 갖지 않는 RestAPI를 사용하였기 때문에 로그인 인증 기능에 JWT를 사용하는 방법을 학습하고 Spring Security 패키지를 사용하여 패스워드를 암호화하고 액세스 토큰을 발급하여 인증하는 방법을 학습

- JWT(액세스 토큰 발급)
- Spring Security 패키지(Password 암호화 및 authentication을 이용한 사용자 인증)
