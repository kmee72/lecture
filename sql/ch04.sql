-- ch04.sql
-- 집계함수(여러행 함수) : COUNT(), SUM(), AVG(), MIN(), MAX(), STDDEV()

USE 세계무역;

SELECT count(*)
FROM 고객;

-- 집계함수는 null값은 연산에서 제외한다.
SELECT count(고객번호), count(도시), count(지역)
FROM 고객;

SELECT sum(마일리지), avg(마일리지), MIN(마일리지), MAX(마일리지)
   ,  TRUNCATE( STDDEV(마일리지), -1 ) AS 표준편차
FROM 고객;

SELECT sum(마일리지), avg(마일리지), MIN(마일리지), MAX(마일리지)
   ,  TRUNCATE( STDDEV(마일리지), -1 ) AS 표준편차
FROM 고객
WHERE 도시 = '서울특별시';

-- GROUP BY절 : 특정컬럼에 대해 그룹(묶어서)으로 집계할 때
SELECT * FROM 고객;

-- select 옆에 컬럼이름은 (집계함수제외) 반드시 GROUP BY절에 써야 됨. 
SELECT 도시
	, 마일리지
	, COUNT(*) AS '도시별 고객수'
	, AVG(마일리지) AS '도시별 평균마일리지'
FROM 고객
GROUP BY 도시, 마일리지;

SELECT 도시
	, 마일리지
	, COUNT(*) AS '도시별 고객수'
	, AVG(마일리지) AS '도시별 평균마일리지'
FROM 고객
GROUP BY 1, 2;

SELECT 담당자직위, 도시
	, count(*) AS 고객수
	, avg(마일리지) AS 평균마일리지
FROM 고객
GROUP BY 1, 2
ORDER BY 1, 2;

-- HAVING절 : SELECT문에 들어가는 컬럼과 집계함수에만 적용 가능
--          : GROUP BY절과 함께 사용한다.
SELECT 도시
     , COUNT(*) AS '도시별 고객수'
FROM 고객
GROUP BY 도시
HAVING COUNT(*) >= 10
ORDER BY 2 DESC;

SELECT 도시
	, COUNT(*) AS '도시별 고객수'
	, AVG(마일리지) AS 평균마일리지
FROM 고객
WHERE 도시 LIKE '%광역시'   -- 집계에 참여할 행을 미리 선별한다.
GROUP BY 도시 -- 도시를 기준으로 집계하자.
HAVING COUNT(*) >= 5; -- 집계 후의 결과물에서 선별한다.
-- ORDER BY
-- LIMIT n

SELECT 도시, 담당자직위, SUM(마일리지)
FROM 고객
WHERE 고객번호 LIKE 'T%'
-- GROUP BY절에는 SELECT문의 컬럼명을 모두 적어야 됨.(집계함수 제외!)
GROUP BY 1, 2
HAVING SUM(마일리지) >= 1000;

-- 연습문제
-- 1. 고객 테이블에서 담당자직위 별로 집계를 하되,
--   담당자직위와 최대 마일리지(Max() 함수)를 출력하시오.
-- 다만, 집계에 참여하는 고객은 '광역시'에 거주해야 함.
-- 최대 마일리지는 10000이상인 행만 출력하시오.
SELECT 담당자직위
   	, MAX(마일리지) AS 최대마일리지
FROM 고객
WHERE 도시 LIKE '%광역시'
GROUP BY 담당자직위
HAVING MAX(마일리지) >= 10000;

SELECT 담당자직위, 마일리지
FROM 고객
WHERE 담당자직위 = '영업 과장';

-- COUNT()함수에 DISTINCT 예약어를 추가
-- COUNT(DISTINCT 도시) : 중복값을 한 번씩만 센다.
SELECT 도시, COUNT(도시), COUNT(DISTINCT 도시)
FROM 고객
GROUP BY 도시;

SELECT COUNT(도시) AS 전체데이터수 -- 93(전체고객수)
	,COUNT(DISTINCT 도시) AS 거래도시수  -- 27
FROM 고객;

-- 주문년도별로 집계를 해보자
SELECT YEAR(주문일) AS 주문년도
	,COUNT(*) AS 주문건수
FROM 주문
GROUP BY YEAR(주문일);

-- 분기별, 소계(ROLLUP)를 집계 해보자.
SELECT YEAR(주문일) AS 주문연도
    ,QUARTER(주문일) AS 분기
	,COUNT(*) AS 주문건수
FROM 주문
GROUP BY YEAR(주문일), QUARTER(주문일)
WITH ROLLUP; -- 분류별 소계, 총계를 내주는 구문

-- 주문 테이블에서 요청일보다 발송이 늦어진 주문을
--   월별로 집계(요약)해 보자.
SELECT MONTH(주문일) AS 주문월
	,COUNT(*) AS 주문건수
FROM 주문
WHERE 요청일 < 발송일
GROUP BY MONTH(주문일)
ORDER BY MONTH(주문일) ASC;

-- 제품 테이블에서 제품명에 '아이스크림'이 들어간 제품들의 재고합을
--   집계하여 출력하시오.
SELECT 제품명, SUM(재고) AS 재고합
FROM 제품
WHERE 제품명 LIKE '%아이스크림%'
GROUP BY 제품명
WITH ROLLUP;

-- 실전문제
-- 1. 주문세부 테이블에서 주문수량합과 주문금액합을 보이시오.
SELECT *
FROM 주문세부;

DESC 주문세부;

SELECT SUM(주문수량) AS 주문수량합
      ,SUM(단가 * 주문수량 * (1 - 할인율)) AS 주문금액합
FROM 주문세부;

-- 2. 주문세부 테이블에서 주문번호별로 주문된 제품번호의 목록과 
--    주문금액합을 보이시오.
--  주문번호는 주문 건당 하나씩 발급됨.
SELECT 주문번호, 제품번호, SUM(단가*주문수량) AS 주문금액합
FROM 주문세부
GROUP BY 주문번호, 제품번호
WITH ROLLUP
ORDER BY 주문번호;

-- 3. 주문 테이블에서 2021년 주문내역에 대해서 고객번호별로 
-- 주문건수를 보이되, 주문건수가 많은 상위 3건의 고객의 정보만 보이시오.
SELECT 고객번호, COUNT(*) AS 주문건수
FROM 주문
WHERE YEAR(주문일) = 2021
GROUP BY 고객번호
ORDER BY 주문건수 DESC
LIMIT 3;

-- GROUP_CONCAT()함수 : 여러 행의 문자열을 결행해 줌.
SELECT 직위, GROUP_CONCAT(이름 SEPARATOR ', ')
FROM 사원
GROUP BY 직위
ORDER BY 직위;

SELECT 직위, COUNT(직위), 이름
FROM 사원
GROUP BY 직위, 이름
ORDER BY 직위;





















