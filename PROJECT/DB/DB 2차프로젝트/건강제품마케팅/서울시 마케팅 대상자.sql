-- SEOUL ���� SEOUL ������ �ü��� ������ �� �� �ִ� ���̺� ����
CREATE TABLE SEOUL_RANK AS
(SELECT ������, COUNT(������) AS ����, RANK() OVER (ORDER BY COUNT(������) DESC) AS ����
FROM (
SELECT NVL(TRIM(SUBSTR(��������ü�ּ�, INSTR(��������ü�ּ�, ' ', 1, 1), INSTR(��������ü�ּ�, ' ', 1, 2)-INSTR(��������ü�ּ�, ' ', 1, 1))),
TRIM(SUBSTR(���θ���ü�ּ�, INSTR(���θ���ü�ּ�, ' ', 1, 1), INSTR(���θ���ü�ּ�, ' ', 1, 2)-INSTR(���θ���ü�ּ�, ' ', 1, 1)))) AS ������
FROM SEOUL
WHERE TRIM(SUBSTR(��������ü�ּ�, 0, INSTR(��������ü�ּ�, ' ', 1, 1))) = '����Ư����' OR
    TRIM(SUBSTR(���θ���ü�ּ�, 0, INSTR(���θ���ü�ּ�, ' ', 1, 1))) = '����Ư����') 
    GROUP BY ������);


-- ����ġ Ȯ��
SELECT * FROM(
SELECT ROWNUM AS ����, TRIM(SUBSTR(��������ü�ּ�, INSTR(��������ü�ּ�, ' ', 1, 1), INSTR(��������ü�ּ�, ' ', 1, 2)-INSTR(��������ü�ּ�, ' ', 1, 1))) AS ������������,
TRIM(SUBSTR(���θ���ü�ּ�, INSTR(���θ���ü�ּ�, ' ', 1, 1), INSTR(���θ���ü�ּ�, ' ', 1, 2)-INSTR(���θ���ü�ּ�, ' ', 1, 1))) AS ���θ������� FROM SEOUL
WHERE ��������ü�ּ� LIKE '����Ư����%' OR ���θ���ü�ּ� LIKE '����Ư����%')
WHERE ������������ != ���θ�������;


-- CUSTOMER �� ���￡ ��� ȸ������ ������
CREATE TABLE CUSTOMER_SEOUL AS
    (SELECT NAME, MOBILE_NO, TRIM(SUBSTR(ADDRESS1, INSTR(ADDRESS1, ' ', 1, 1), INSTR(ADDRESS1, ' ', 1, 2)-INSTR(ADDRESS1, ' ', 1, 1))) AS ������
    FROM CUSTOMER
    WHERE SUBSTR(ADDRESS1, 0, 2) = '����');

-- JOIN�� �̿��� ����� ���� (3�� ������ �̳���)

SET FEEDBACK OFF
SET HEAD ON
SPOOL "D:/DB Project/DB 2��������Ʈ/output.csv"
SELECT /*csv*/ C.NAME, C.MOBILE_NO, R.����, R.������ FROM SEOUL_RANK R, CUSTOMER_SEOUL C
    WHERE (R.������ = C.������) AND R.����<4
    ORDER BY R.����;



/*
SELECT ����, ������������, ���θ������� FROM
(SELECT ����, TRIM(SUBSTR(��������ü�ּ�, INSTR(��������ü�ּ�, ' ', 1, 1), INSTR(��������ü�ּ�, ' ', 1, 2)-INSTR(��������ü�ּ�, ' ', 1, 1))) AS ������������,
TRIM(SUBSTR(��������ü�ּ�, INSTR(��������ü�ּ�, ' ', 1, 1), INSTR(��������ü�ּ�, ' ', 1, 2)-INSTR(��������ü�ּ�, ' ', 1, 1))) AS ���θ������� FROM
(SELECT ROWNUM AS ����, NVL(��������ü�ּ�, ���θ���ü�ּ�) AS ��������ü�ּ�, NVL(���θ���ü�ּ�, ��������ü�ּ�) AS ���θ���ü�ּ� FROM SEOUL
WHERE TRIM(SUBSTR(��������ü�ּ�, 0, INSTR(��������ü�ּ�, ' ', 1, 1))) = '����Ư����' OR
    TRIM(SUBSTR(���θ���ü�ּ�, 0, INSTR(���θ���ü�ּ�, ' ', 1, 1))) = '����Ư����'))
    WHERE ������������ != ���θ�������;
*/
    
