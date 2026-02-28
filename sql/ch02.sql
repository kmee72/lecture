-- ch02.sql

use 세계무역;

-- *은 모든 컬럼을 의미한다.
SELECT *
FROM 고객;

-- 행의 갯수 (별칭(Alias)는 출력창에 임시로 생성되는 이름, as 생략가능)
SELECT count(*) AS '행의 갯수'
FROM 고객;

SELECT 고객번호,담당자명,고객회사명,마일리지 as 포인트,
    마일리지 * 1.1 as '10%인상된 마일리지'
FROM 고객;

-- where절 조건적 조회
SELECT 고객번호,담당자명,마일리지 as 포인트
FROM 고객
WHERE 마일리지 >= 100000;

-- order by절 정렬(내림차순,오름차순)
SELECT 고객번호,담당자명,도시,마일리지 as 포인트
FROM 고객
WHERE 도시 = '서울특별시'
ORDER by 마일리지 ASC; -- DESC

-- limit n : 갯수 제한
SELECT *
FROM 고객
LIMIT 3;

-- 마일리지 상위 3명 / 하위 3명
SELECT *
FROM 고객
ORDER BY 마일리지 asc -- DESC
limit 3;

-- distinct 중복 데이터 제거
SELECT DISTINCT 도시
FROM 고객;

-- 산술연산자
SELECT 23 + 5 as 더하기
	,23 - 5 as 빼기
	,23 * 5 as 곱하기
	,23 / 5 as '나누기 몫(실수)'
	,23 div 5 as '나누기 몫(정수)'
    ,23 % 5 as 나머지1
    ,23 mod 5 as 나머지2;

-- 비교연산자
-- MySQL/MariaDB - 불리언(boolean)을 정수형으로 처리한다.
--               True는 1, False는 0(단 null과의 비교는 null)
-- PostgreSQL(포스트그리-SQL): true/false 텍스트형태의 불리언 값 반환
-- Oracle,MS SQL Server - 불리언값을 직접 반환하지 않음.
SELECT 23 > 23
	,23 < 23
	,23 = 23 -- 같은가?
	,23 != 23 -- 같지 않은가?
	,23 <> 23 -- 같지 않은가?
	,23 >= 5  -- 크거나 같은가?
	,23 <= 5; -- 작거나 같은가?

use 세계무역;

SELECT *
FROM 고객
WHERE 담당자직위 = '영업 과장'; -- 문자열은 ''단따옴표 추천

SELECT *
FROM 고객
WHERE 도시 = '부산광역시' and 마일리지 < 1000;

-- 연습문제 - 게시판에 스샷 제출
-- 1.‘서울’에 사는 고객 중에 마일리지가 15,000점 이상 20,000점 이하인 
--    고객의 모든 컬럼 정보를 보이시오.
SELECT * 
from 고객
WHERE 도시 = '서울특별시' 
and ( 마일리지 >= 15000 and 마일리지 <= 20000 );
-- 2. 세계무역의 고객들은 어느 지역, 어느 도시에 사는지 지역과 도시를 
--    한 번씩만 보이시오.
--   이때 결과를 지역 순으로 나타내고, 
--   동일 지역에 대해서는 도시 순으로 나타내시오.
--   DISTINCT를 두개의 컬럼에 적용
SELECT distinct 지역
from 고객;

SELECT distinct 도시
from 고객;

-- distinct 컬럼이 2개이상이면, 쌍으로 구분된다.
-- (경기도, 광명시) <> (경기도, 구리시)
SELECT distinct 지역, 도시
from 고객;

SELECT distinct 지역, 도시
from 고객
order by 지역, 도시 asc;

-- 고객 테이블의 지역 필드가 ''(빈문자열)로 추가되었다.
-- ''인지? '  '인지? null인지? 헷갈린다.
-- 지역 필드의 값을 모두 '' -> null 바꿔준다.
-- 값이 없을 때는 명시적으로 null 값으로 채우는게 좋다.
UPDATE 고객 
set 지역 = null -- where절이 없으면, 모든 열의 데이터가 적용된다! 주의!
WHERE 지역 = '';

SELECT 지역
FROM 고객;

-- UNION 연산자(2개 이상의 SELECT결과를 합쳐준다.)
SELECT 고객번호, 도시, 마일리지
FROM 고객
WHERE 도시 = '부산광역시' -- 5열
union all -- 모든 행을 더한다.
SELECT 고객번호, 도시, 마일리지
FROM 고객
WHERE 마일리지 < 1000
order by 고객번호; -- 45열

-- 첫번째 select의 필드명으로 출력된다.
SELECT 고객번호 as 고객아이디, 도시, 마일리지
FROM 고객
WHERE 도시 = '부산광역시' -- 5열
union all -- 모든 행을 더한다.
SELECT 고객번호, 도시, 마일리지
FROM 고객
WHERE 마일리지 < 1000
order by 고객아이디;

-- union all과 union(union distinct)의 차이
-- union all은 중복된 행을 포함해서 모든 행을 출력(정렬없이 그대로 합친다.)
-- union은 중복된 행을 제거하고 출력(내부적으로 정렬후 합친다.)

-- union 사용시 주의점
-- 1. 컬럼(필드) 갯수 일치
-- 2. 각 컬럼의 데이터 타입(숫자,문자,날짜)
-- 3. 첫번째 select의 필드명으로 출력된다.

-- IS NULL연산자 - NULL값인지?
SELECT * 
FROM 고객
WHERE 지역 is null; -- 66열

SELECT * 
FROM 고객
WHERE 지역 is not null; -- 27열

-- IN연산자 : ~중에 하나가 있으면 true(여러개의 or를 대체)
SELECT 고객번호, 담당자명, 담당자직위
FROM 고객
WHERE 담당자직위 = '영업 과장' 
or 담당자직위 = '마케팅 과장'
or 담당자직위 = '영업 사원'; -- 60열

SELECT 고객번호, 담당자명, 담당자직위
FROM 고객
WHERE 담당자직위 in ('영업 과장', '영업 사원', '마케팅 과장'); -- 60열

-- BETWEEN AND : ~이상 ~이하 범위를 지정할 때
SELECT 담당자명, 마일리지
FROM 고객
WHERE 100000 <= 마일리지 and 마일리지 <= 200000; -- 2열

SELECT 담당자명, 마일리지
FROM 고객
WHERE 마일리지 between 100000 and 200000; -- 2열

-- LIKE연산자 : 문자(열)의 일부를 검사할 때 사용
--           : % 여러 문자열을 대체
--           : _ 한 글자(문자)를 대체
SELECT *
FROM 고객
WHERE 도시 in ('부산광역시','울산광역시','대전광역시');

SELECT *
FROM 고객
WHERE 도시 like '%광역시'
and (고객번호 like '_C%') ; -- 고객번호 2번째 문자가 C인 열을 찾는다.

-- 연습문제 - 스샷을 게시판에 제출
-- 1. 제품 테이블에서 제품명에 '주스'가 들어가는 모든 제품을 출력하시오.
select * from 제품
where 제품명 like '%주스%'; -- 3열
-- 2. 제품 테이블에서 단가가 5,000원 이상 10,000원 이하인
--		'주스'가 제품명에 들어가는 제품들을 출력하시오.
select * from 제품
where 제품명 like '%주스%'
and 단가 between 5000 and 10000;
-- 3. 제품 테이블에서 제품번호가 1,2,3,4,11,20인 모든 제품을 출력하시오.
select * from 제품
where 제품번호 in (1,2,3,4,11,20); -- 6열
-- 4. 제품 테이블에서 재고금액이 높은 상위 10개 제품에 대해 제품번호, 제품명, 
--   단가, 재고, 재고금액(단가 * 재고)을 보이시오.
select 제품번호, 제품명, 단가, 재고, 단가 * 재고 as '재고금액'
from 제품
order by 재고금액 desc
limit 10; -- 10열



