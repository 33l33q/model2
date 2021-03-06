# 프로젝트명 : **Java Model2 web application**
> Model2 pattern을 기반으로 한 web 응용 프로그램 만들기

## 1.요건정리
> - 목적 :  예상 이용자 100명 내외를 대상으로한 웹 게시판 구축
> - 구조 :  MODEL2 - MVC pattern을 기반
> - 기능 : 사용자 CRUD(입력, 수정, 삭제, 전체조회, 검색, like검색) 및 게시글 CRUD(입력, 수정, 삭제, 조회)
		비밀번호 
> - 제작 기간 : 36시간

테이블 정의서
 
> 1. 회원정보 테이블


컬럼ID		|	데이터 타입(크기)		|	컬럼명
----- 		|	--------		|	---
LMEM		|	VARCHAR2(13 BYTE)	|	회원번호	
LNAME		|	VARCHAR2(20 BYTE)	|	성명	
LID		|	VARCHAR2(20 BYTE)	|	아이디	
LPW		|	VARCHAR2(20 BYTE)	|	비밀번호	
LHP		|	VARCHAR2(20 BYTE)	|	전화번호	
LBIRTH		|	VARCHAR2(8 BYTE)	|	생년월일	
LEMAIL		|	VARCHAR2(20 BYTE)	|	이메일	
LPOSTNO		|	VARCHAR2(5 BYTE)	|	우편번호	
LLOADADDR	|	VARCHAR2(300 BYTE)	|	도로명주소	
LADDR		|	VARCHAR2(300 BYTE)	|	상세주소	
LPHOTO		|	VARCHAR2(500 BYTE)	|	사진	
LDELETEYN	|	VARCHAR2(1 BYTE)	|	삭제유무	
LINSERTDATE	|	DATE			|	생성일	
LUPDATEDATE	|	DATE			|	수정일	
						
> 2. 게시글 정보 테이블 						
						
컬럼ID		|	데이터 타입(크기)		|	컬럼명
----- 		|	--------		|	---
LNO		|	VARCHAR2(10 BYTE)	|	글번호	
LSUBJECT	|	VARCHAR2(1000 BYTE)	|	글제목	
LNAME		|	VARCHAR2(300 BYTE)	|	작성자	
LPW		|	VARCHAR2(400 BYTE)	|	비밀번호	
LMEMO		|	VARCHAR2(4000 BYTE)	|	글내용	
LPHOTO		|	VARCHAR2(500 BYTE)	|	사진	
LDELETEYN	|	VARCHAR2(1 BYTE)	|	삭제유무	
LINSERTDATE	|	DATE			|	생성일
LUPDATEDATE	|	DATE			|	수정일


시스템 아키텍쳐
![슬라이드12](https://user-images.githubusercontent.com/62315622/84184699-cdbb3280-aac8-11ea-8021-314cbbf4a69e.PNG)


## 2. 개발환경 : Eclipse Neon3, jdk 1.8, oracle 11g R2, apach-tomcat 8.0, window10, HMTL5, jsp, cos 20.0, Daum Open API, Servlet 3.1, jQuery


## 3. 실행화면

- 1-1 메인화면
![슬라이드1](https://user-images.githubusercontent.com/62315622/84184701-ce53c900-aac8-11ea-8a79-dfd4a704faad.PNG)

- 2-1 회원관리_회원가입
![슬라이드2](https://user-images.githubusercontent.com/62315622/84184704-ceec5f80-aac8-11ea-8c98-cafeed6ae264.PNG)
![슬라이드3](https://user-images.githubusercontent.com/62315622/84184705-cf84f600-aac8-11ea-9d0a-d9b0980b7bbe.PNG)

- 2-2 회원관리_전체조회
![슬라이드4](https://user-images.githubusercontent.com/62315622/84184706-d01d8c80-aac8-11ea-86de-b2891e166526.PNG)

- 2-3 회원관리_개인정보수정
![슬라이드5](https://user-images.githubusercontent.com/62315622/84184707-d0b62300-aac8-11ea-82b5-42cfb5c010f7.PNG)

- 2-4 회원관리_탈퇴
![슬라이드6](https://user-images.githubusercontent.com/62315622/84184708-d0b62300-aac8-11ea-8980-dfdc6712abee.PNG)

- 3-1 게시판관리_전체조회
![슬라이드7](https://user-images.githubusercontent.com/62315622/84184709-d14eb980-aac8-11ea-86e4-7706da7e3ee5.PNG)

- 3-2 게시판관리_상세조회
![슬라이드8](https://user-images.githubusercontent.com/62315622/84184691-ca27ab80-aac8-11ea-89dc-798f8688fe0f.PNG)

- 3-3 게시판관리_수정페이지
![슬라이드9](https://user-images.githubusercontent.com/62315622/84184693-cc8a0580-aac8-11ea-89a9-69d5704733e4.PNG)

- 3-4 게시판관리_글 수정하기
![슬라이드11](https://user-images.githubusercontent.com/62315622/84184695-cd229c00-aac8-11ea-8a9f-6852ffeebe96.PNG)

- 3-5 게시판관리_글 삭제하기
![슬라이드10](https://user-images.githubusercontent.com/62315622/84184694-cd229c00-aac8-11ea-92e2-d093a236c741.PNG)


