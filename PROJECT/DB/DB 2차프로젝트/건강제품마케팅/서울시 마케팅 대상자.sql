-- SEOUL 에서 SEOUL 지역구 시설의 갯수를 알 수 있는 테이블 생성
CREATE TABLE SEOUL_RANK AS
(SELECT 지역구, COUNT(지역구) AS 갯수, RANK() OVER (ORDER BY COUNT(지역구) DESC) AS 순위
FROM (
SELECT NVL(TRIM(SUBSTR(소재지전체주소, INSTR(소재지전체주소, ' ', 1, 1), INSTR(소재지전체주소, ' ', 1, 2)-INSTR(소재지전체주소, ' ', 1, 1))),
TRIM(SUBSTR(도로명전체주소, INSTR(도로명전체주소, ' ', 1, 1), INSTR(도로명전체주소, ' ', 1, 2)-INSTR(도로명전체주소, ' ', 1, 1)))) AS 지역구
FROM SEOUL
WHERE TRIM(SUBSTR(소재지전체주소, 0, INSTR(소재지전체주소, ' ', 1, 1))) = '서울특별시' OR
    TRIM(SUBSTR(도로명전체주소, 0, INSTR(도로명전체주소, ' ', 1, 1))) = '서울특별시') 
    GROUP BY 지역구);


-- 결측치 확인
SELECT * FROM(
SELECT ROWNUM AS 순번, TRIM(SUBSTR(소재지전체주소, INSTR(소재지전체주소, ' ', 1, 1), INSTR(소재지전체주소, ' ', 1, 2)-INSTR(소재지전체주소, ' ', 1, 1))) AS 소재지지역구,
TRIM(SUBSTR(도로명전체주소, INSTR(도로명전체주소, ' ', 1, 1), INSTR(도로명전체주소, ' ', 1, 2)-INSTR(도로명전체주소, ' ', 1, 1))) AS 도로명지역구 FROM SEOUL
WHERE 소재지전체주소 LIKE '서울특별시%' OR 도로명전체주소 LIKE '서울특별시%')
WHERE 소재지지역구 != 도로명지역구;


-- CUSTOMER 중 서울에 사는 회원들의 지역구
CREATE TABLE CUSTOMER_SEOUL AS
    (SELECT NAME, MOBILE_NO, TRIM(SUBSTR(ADDRESS1, INSTR(ADDRESS1, ' ', 1, 1), INSTR(ADDRESS1, ' ', 1, 2)-INSTR(ADDRESS1, ' ', 1, 1))) AS 지역구
    FROM CUSTOMER
    WHERE SUBSTR(ADDRESS1, 0, 2) = '서울');

-- JOIN을 이용한 대상자 선정 (3위 지역구 이내로)

SET FEEDBACK OFF
SET HEAD ON
SPOOL "D:/DB Project/DB 2차프로젝트/output.csv"
SELECT /*csv*/ C.NAME, C.MOBILE_NO, R.순위, R.지역구 FROM SEOUL_RANK R, CUSTOMER_SEOUL C
    WHERE (R.지역구 = C.지역구) AND R.순위<4
    ORDER BY R.순위;



/*
SELECT 순번, 소재지지역구, 도로명지역구 FROM
(SELECT 순번, TRIM(SUBSTR(소재지전체주소, INSTR(소재지전체주소, ' ', 1, 1), INSTR(소재지전체주소, ' ', 1, 2)-INSTR(소재지전체주소, ' ', 1, 1))) AS 소재지지역구,
TRIM(SUBSTR(소재지전체주소, INSTR(소재지전체주소, ' ', 1, 1), INSTR(소재지전체주소, ' ', 1, 2)-INSTR(소재지전체주소, ' ', 1, 1))) AS 도로명지역구 FROM
(SELECT ROWNUM AS 순번, NVL(소재지전체주소, 도로명전체주소) AS 소재지전체주소, NVL(도로명전체주소, 소재지전체주소) AS 도로명전체주소 FROM SEOUL
WHERE TRIM(SUBSTR(소재지전체주소, 0, INSTR(소재지전체주소, ' ', 1, 1))) = '서울특별시' OR
    TRIM(SUBSTR(도로명전체주소, 0, INSTR(도로명전체주소, ' ', 1, 1))) = '서울특별시'))
    WHERE 소재지지역구 != 도로명지역구;
*/
    
