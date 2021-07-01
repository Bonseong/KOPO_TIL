-- 1-1 CARD, COVID ������ �ε�
SELECT * FROM CARD;
SELECT * FROM COVID;
ALTER TABLE CARD RENAME COLUMN �̿����� TO DATEREP; -- �Ŀ� JOIN�� ����




-- 2-1 1�� ������ ���� ��ȭ
SELECT ������з�, PERIOD, ROUND(AVG(ī������Ǽ�),2) AS ���ī������Ǽ� FROM(
SELECT ������з�, ī������Ǽ�, CASE
    WHEN DATEREP <TO_DATE('19/03/31') THEN '�ڷγ� ���� ����' ELSE '�ڷγ� ���� ����' END AS PERIOD  FROM CARD
WHERE DATEREP BETWEEN TO_DATE('19/02/01') AND TO_DATE('19/03/31') OR
    DATEREP BETWEEN TO_DATE('20/02/01') AND TO_DATE('20/03/31'))
GROUP BY PERIOD, ������з�
ORDER BY PERIOD, ������з�;




-- 2-2 Ȯ���ڿ� ����м�
CREATE TABLE CARD_PIVOT AS (SELECT *
FROM (
    SELECT * FROM CARD
) 
PIVOT (
    SUM(ī������Ǽ�) FOR ������з� IN ('����/����' AS ����_����, '������Ȱ/����' AS ������Ȱ_����, '����/�п�' AS ����_�п�,
                                    '�̿�' AS �̿�, '������/��ȭ/����' AS ������_��ȭ_����, '����/����' AS ����_����, '���/����' AS ���_����,
                                    '����' AS ����, '��/�ķ�ǰ' AS ��_�ķ�ǰ, '�Ƿ�' AS �Ƿ�, '�ڵ���' AS �ڵ���, '����' AS ����, '�м�/��ȭ' AS �м�_��ȭ)
));

SELECT * FROM CARD_PIVOT;


SELECT DATEREP, CASES FROM COVID ORDER BY DATEREP;

CREATE TABLE CARD_COVID AS (
SELECT C.DATEREP, TO_NUMBER(SUBSTR(C.DATEREP, 1,2)) AS YEAR, TO_NUMBER(SUBSTR(C.DATEREP, 4,2)) AS MONTH, TO_NUMBER(SUBSTR(C.DATEREP, 7,2)) AS DAY,
    V.CASES, C.����_����, C.������Ȱ_����, C.����_�п�, C.�̿�, C.������_��ȭ_����, C.����_����, C.���_����, C.����, C.��_�ķ�ǰ, C.�Ƿ�, C.�ڵ���, C.����, C.�м�_��ȭ FROM CARD_PIVOT C, COVID V
WHERE C.DATEREP = V.DATEREP(+));

SELECT * FROM CARD_COVID WHERE CASES IS NOT NULL ORDER BY DATEREP;


SELECT SUBSTR(ADDRESS1, INSTR(ADDRESS1, ' ', 1, 1)+1,INSTR(ADDRESS1, ' ', 1, 2)-INSTR(ADDRESS1, ' ', 1, 1) ) FROM CUSTOMER;
select trim(substr(address1,4,3))
from customer
where address1 like '%���ʱ�%';





/*
SELECT YEAR, ROUND(AVG(����_����),2) AS ����_����, ROUND(AVG(������Ȱ_����),2) AS ������Ȱ_����, ROUND(AVG(����_�п�),2) AS ����_�п�,
    ROUND(AVG(�̿�),2) AS �̿�, ROUND(AVG(������_��ȭ_����),2) AS ������_��ȭ_����, ROUND(AVG(����_����),2) AS ����_����,
    ROUND(AVG(���_����),2) AS ���_����, ROUND(AVG(����),2) AS ����, ROUND(AVG(��_�ķ�ǰ),2) AS ��_�ķ�ǰ,
    ROUND(AVG(�Ƿ�),2) AS �Ƿ�, ROUND(AVG(�ڵ���),2) AS �ڵ���, ROUND(AVG(����),2) AS ����, ROUND(AVG(�м�_��ȭ),2) AS �м�_��ȭ FROM CARD_COVID
WHERE DATEREP BETWEEN TO_DATE('19/02/01') AND TO_DATE('19/03/31') OR
    DATEREP BETWEEN TO_DATE('20/02/01') AND TO_DATE('20/03/31')
GROUP BY YEAR
ORDER BY YEAR;
*/