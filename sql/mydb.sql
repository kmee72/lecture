-- 데이터베이스 생성
CREATE DATABASE IF NOT EXISTS mydb;

-- 데이터베이스 전환
USE mydb;

-- 회원 테이블 생성
-- INT(10) 정수 10자리 할당(고정길이)
--   4바이트 범위의 숫자(-21억 ~ +21억)
--   10의 의미 - 화면에 보여지는 표시 너비(예-0000012345)
-- VARCHAR(50) 문자열 50자리 할당(가변길이)
--   50미만의 문자를 넣으면, 그만큼만 메모리 확보.
--   50자리 이상의 문자를 넣으면 오류
-- PRIMARY KEY : 기본키, 열과 열을 구분하는 식별자(예-주민번호)
-- AUTO_INCREMENT : Insert시 1씩 증가하는 속성을 추가.
CREATE TABLE mydb.member(
  member_no INT(10) PRIMARY KEY AUTO_INCREMENT,
  member_id VARCHAR(50), -- 로그인 아이디
  member_pw VARCHAR(50), -- 로그인 암호
  member_nickname VARCHAR(50) -- 별명
);

-- 테이블 구조 확인할 때
DESC member;

-- 행/레코드/데이터 추가
-- sql에서는 쌍따옴표, 단따옴표 구분하지 않음.
-- 하지만 문자열:단따옴표, 테이블명,컬럼명:쌍따옴표
-- 백틱(`) : 예약어를 사용자정의어로 사용시 사용가능.
--   예) `order`, `user`, `desc`, `key`, `group`
INSERT into member (member_no, member_id, member_pw, member_nickname)
values (1, 'hong', '1234', '홍길동');

-- 모든 컬럼의 데이터를 기입하면, 필드(컬럼) 이름 생략 가능
INSERT INTO  `member` 
values (2, 'lee', '1234', '이순신');

-- auto_increment 속성은 0으로 추가하면 자동증가됨.
INSERT INTO member
values (0, 'park', '1234', '박수다');
INSERT INTO member
values (0, 'park', '1234', '박수다');

-- 열(레코드) 삭제하기
DELETE FROM member 
WHERE member_no = 4;

-- SQL예약어(SELECT,INSERT) : 대소문자 구분하지 않는다.
-- 사용자 정의어(테이블명, 컬럼명) : 윈OS - 구분하지 않는다. LinuxOS : 구분한다.
--                           : 모두 소문자로 작성한다!!
-- 데이터 값 : mySQL(_ci:case-insensitive) : 'abc'와 'ABC'를 같은 값으로 취급.
--           oracle/postgreSQL : 'abc'와 'ABC'를 다른 값으로 취급.

-- 열(레코드) 수정하기
UPDATE member SET member_id='hong2',member_pw='2222'
WHERE member_no = 1;

-- 모든 행과 열의 데이터 조회
select * 
from member;

-- 열의 갯수 세기
SELECT count(*)
FROM member;

-- 커밋 : 실제 물리적 파일로 저장하는 명령어.
-- mysql : auto commit - insert/update/delete명령 후 자동 저장.
-- oracle : manual commit - 직접 commit해야 저장됨.
commit;






