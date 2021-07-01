-- 1-1 CARD, COVID 데이터 로드
SELECT * FROM CARD;
SELECT * FROM COVID;
ALTER TABLE CARD RENAME COLUMN 이용일자 TO DATEREP; -- 후에 JOIN을 위해




-- 2-1 1차 대유행 매출 변화
SELECT 업종대분류, PERIOD, ROUND(AVG(카드결제건수),2) AS 평균카드결제건수 FROM(
SELECT 업종대분류, 카드결제건수, CASE
    WHEN DATEREP <TO_DATE('19/03/31') THEN '코로나 유행 이전' ELSE '코로나 유행 이후' END AS PERIOD  FROM CARD
WHERE DATEREP BETWEEN TO_DATE('19/02/01') AND TO_DATE('19/03/31') OR
    DATEREP BETWEEN TO_DATE('20/02/01') AND TO_DATE('20/03/31'))
GROUP BY PERIOD, 업종대분류
ORDER BY PERIOD, 업종대분류;




-- 2-2 확진자와 상관분석
CREATE TABLE CARD_PIVOT AS (SELECT *
FROM (
    SELECT * FROM CARD
) 
PIVOT (
    SUM(카드결제건수) FOR 업종대분류 IN ('가전/가구' AS 가전_가구, '가정생활/서비스' AS 가정생활_서비스, '교육/학원' AS 교육_학원,
                                    '미용' AS 미용, '스포츠/문화/레저' AS 스포츠_문화_레저, '여행/교통' AS 여행_교통, '요식/유흥' AS 요식_유흥,
                                    '유통' AS 유통, '음/식료품' AS 음_식료품, '의료' AS 의료, '자동차' AS 자동차, '주유' AS 주유, '패션/잡화' AS 패션_잡화)
));

SELECT * FROM CARD_PIVOT;


SELECT DATEREP, CASES FROM COVID ORDER BY DATEREP;

CREATE TABLE CARD_COVID AS (
SELECT C.DATEREP, TO_NUMBER(SUBSTR(C.DATEREP, 1,2)) AS YEAR, TO_NUMBER(SUBSTR(C.DATEREP, 4,2)) AS MONTH, TO_NUMBER(SUBSTR(C.DATEREP, 7,2)) AS DAY,
    V.CASES, C.가전_가구, C.가정생활_서비스, C.교육_학원, C.미용, C.스포츠_문화_레저, C.여행_교통, C.요식_유흥, C.유통, C.음_식료품, C.의료, C.자동차, C.주유, C.패션_잡화 FROM CARD_PIVOT C, COVID V
WHERE C.DATEREP = V.DATEREP(+));

SELECT * FROM CARD_COVID WHERE CASES IS NOT NULL ORDER BY DATEREP;


SELECT SUBSTR(ADDRESS1, INSTR(ADDRESS1, ' ', 1, 1)+1,INSTR(ADDRESS1, ' ', 1, 2)-INSTR(ADDRESS1, ' ', 1, 1) ) FROM CUSTOMER;
select trim(substr(address1,4,3))
from customer
where address1 like '%구례군%';





/*
SELECT YEAR, ROUND(AVG(가전_가구),2) AS 가전_가구, ROUND(AVG(가정생활_서비스),2) AS 가정생활_서비스, ROUND(AVG(교육_학원),2) AS 교육_학원,
    ROUND(AVG(미용),2) AS 미용, ROUND(AVG(스포츠_문화_레저),2) AS 스포츠_문화_레저, ROUND(AVG(여행_교통),2) AS 여행_교통,
    ROUND(AVG(요식_유흥),2) AS 요식_유흥, ROUND(AVG(유통),2) AS 유통, ROUND(AVG(음_식료품),2) AS 음_식료품,
    ROUND(AVG(의료),2) AS 의료, ROUND(AVG(자동차),2) AS 자동차, ROUND(AVG(주유),2) AS 주유, ROUND(AVG(패션_잡화),2) AS 패션_잡화 FROM CARD_COVID
WHERE DATEREP BETWEEN TO_DATE('19/02/01') AND TO_DATE('19/03/31') OR
    DATEREP BETWEEN TO_DATE('20/02/01') AND TO_DATE('20/03/31')
GROUP BY YEAR
ORDER BY YEAR;
*/