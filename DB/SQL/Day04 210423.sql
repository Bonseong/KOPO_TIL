SELECT ENAME, HIREDATE FROM EMP;
SELECT ENAME, HIREDATE FROM EMP ORDER BY ENAME; -- ENAME �������� ���� (defalut : asc)
SELECT ENAME, HIREDATE FROM EMP ORDER BY ENAME asc; -- ENAME �������� �������� ���� (�ڵ��� ���Ἲ�� ����)
SELECT ENAME, HIREDATE FROM EMP ORDER BY ENAME desc; -- ENAME �������� �������� ����

/* Naming Rule (������Ģ)
�� �����ڸ��� �ڵ���Ÿ���̳� ������, Ŭ������ �� �ٸ��� ������ ���� ��Ģ
asc, desc ���� ���� �ҹ��ڷ�
*/a

SELECT ENAME, SAL, HIREDATE FROM EMP ORDER BY ENAME;
SELECT ENAME, SAL, HIREDATE FROM EMP ORDER BY 2; -- SELECT LIST�� �ι�° �÷��� �������� ����
SELECT ENAME, SAL*12 as annual_SAL FROM EMP ORDER BY annual_SAL; -- alias �� ��������
SELECT EMPNO, ENAME, COMM, JOB FROM EMP ORDER BY COMM*12;

SELECT DEPTNO,JOB,ENAME FROM EMP ORDER BY DEPTNO; 
SELECT DEPTNO,JOB,ENAME FROM EMP ORDER BY DEPTNO, JOB; -- ù��° ���� ���� : DEPTNO, �ι�° ���� ���� : JOB
SELECT DEPTNO,JOB,ENAME FROM EMP ORDER BY DEPTNO, JOB desc; -- ù��° ���� ���� : DEPTNO, �ι�° ���� ���� : JOB (��������)

SELECT ENAME, HIREDATE FROM EMP ORDER BY SAL desc; -- SELECT ���� ���� �÷��� �������� ������ �� ���� ������, �ǹ̴� ����.

SELECT EMPNO, COMM FROM EMP ORDER BY COMM asc; -- NULL�� ���� ū ������ ����
SELECT EMPNO, COMM FROM EMP ORDER BY COMM desc;

SELECT JOB FROM EMP;
SELECT ALL JOB FROM EMP;

SELECT DISTINCT JOB FROM EMP; -- ANSI ǥ��
SELECT UNIQUE JOB FROM EMP;

SELECT DISTINCT DEPTNO, JOB FROM EMP; -- �����ֿ� ���� �ߺ� ����

--SELECT DISTINCT JOB, DISTINCT DEPTNO FROM EMP;
--SELECT JOB, DISTINCT DEPTNO FROM EMP;

SELECT COMM FROM EMP WHERE COMM IS NOT NULL; -- null�� �ƴ� �Ϳ� ���� ���
SELECT DISTINCT COMM FROM EMP; -- null ���� �ߺ��� �����ϰ� ����Ѵ�

SELECT COMM FROM EMP WHERE COMM IS NOT NULL; -- null�� �ƴ� �Ϳ� ���� ���
SELECT DISTINCT COMM FROM EMP; -- null ���� �ߺ��� �����ϰ� ����Ѵ�


SELECT DEPTNO, ENAME, DECODE(DEPTNO, 10, 'ACCOUNTING', 20, 'RESEARCH', 30, 'SALES', 'ETC')
FROM EMP
ORDER BY DEPTNO;

SELECT COMM, DECODE(COMM, NULL, -99, COMM) FROM EMP;

SELECT GREATEST(3000, 1500, 2100, 5000), LEAST(3000,1500,2100,5000) FROM DUAL; -- GREATEST : �ִ�, LEAST : �ּڰ� ����

SELECT DEPTNO,ENAME,SAL,DECODE(GREATEST(SAL,5000),SAL,'HIGH',DECODE(GREATEST(SAL,2500),SAL,'MID','LOW'))
FROM EMP 
ORDER BY DEPTNO; -- DECODE�� == �� �����ϱ� ������, �񱳿����� �Ұ��� => CASE�� ��ü

SELECT DEPTNO, ENAME, SAL, COMM,
DECODE(GREATEST(COMM, 5000), COMM, 'HIGH', DECODE(GREATEST(COMM, 2500), COMM, 'MID', 'LOW'))
FROM EMP
ORDER BY DEPTNO;

SELECT DEPTNO, ENAME, SAL,
    CASE WHEN SAL>=5000 THEN 'HIGH'
        WHEN SAL>=2500 THEN 'MID'
        WHEN SAL<2500 THEN 'LOW'
    ELSE 'UNKNOWN'
    END
FROM EMP
ORDER BY DEPTNO;

SELECT DEPTNO, ENAME, SAL,
    CASE WHEN SAL >=5000 THEN 'HIGH'
        WHEN SAL >=2500 THEN 'MID'
        WHEN SAL BETWEEN 300 AND 2500 THEN 'LOW'
    ELSE 'UNKNOWN'
    END
FROM EMP
ORDER BY DEPTNO;

SELECT DEPTNO, ENAME, SAL,
    CASE WHEN COMM >=5000 THEN 'HIGH'
        WHEN COMM >=2500 THEN 'MID'
        WHEN COMM BETWEEN 300 AND 2500 THEN 'LOW'
    ELSE 'UNKNOWN'
    END
FROM EMP
ORDER BY DEPTNO;

SELECT DEPTNO,
    CASE DEPTNO
        WHEN 10 THEN 'ACCOUNTING'
        WHEN 20 THEN 'RESEARCH'
        WHEN 30 THEN 'SALES'
        WHEN 40 THEN 'OPERATIONS'
        ELSE 'UNKNOWN'
    END AS DNAME
FROM EMP
ORDER BY DEPTNO;

SELECT SAL,
    CASE
        WHEN SAL>=1000 THEN 1
        WHEN SAL>=2000 THEN 2
        WHEN SAL>=3000 THEN 3
        WHEN SAL>=4000 THEN 4
        WHEN SAL>=5000 THEN 5
        ELSE 0
    END AS SAL_CHK
FROM EMP
ORDER BY SAL; --���� ��κ��� ���� SAL>=1000�� ���ǿ� �ش�Ǳ� ������ ���� ���� ���

SELECT SAL,
    CASE
        WHEN SAL>=5000 THEN 5
        WHEN SAL>=4000 THEN 4
        WHEN SAL>=3000 THEN 3
        WHEN SAL>=2000 THEN 2
        WHEN SAL>=1000 THEN 1
        ELSE 0
    END AS SAL_CHK
FROM EMP
ORDER BY SAL;

SELECT JOB,
    NULLIF(JOB, 'MANAGER'),
    CASE
        WHEN JOB = 'MANAGER' THEN NULL
        ELSE JOB
    END AS NULLIF_SIM
FROM EMP;    


SELECT * FROM EMP;

SELECT ROWNUM, ENAME, DEPTNO, SAL FROM EMP;

SELECT ROWNUM, ENAME, DEPTNO, SAL FROM EMP
ORDER BY DEPTNO, SAL; -- ROWNUM�� ���ڵ庰 ���������� �ִ� ���ڰ� �ƴ�

SELECT ROWNUM, ENAME, DEPTNO, SAL FROM EMP
WHERE DEPTNO IN (10,20)
ORDER BY DEPTNO, SAL; 

SELECT ENAME, DEPTNO, SAL FROM EMP WHERE ROWNUM = 1;

SELECT ENAME, DEPTNO, SAL FROM EMP WHERE ROWNUM <= 3;
SELECT ROWNUM, ENAME, DEPTNO, SAL FROM EMP;

SELECT ENAME,DEPTNO,SAL FROM EMP WHERE ROWNUM<100;







SELECT * FROM DEPT;
------------
SELECT DEPTNO FROM EMP
UNION
SELECT DEPTNO FROM DEPT;

SELECT DEPTNO FROM EMP
UNION ALL
SELECT DEPTNO FROM DEPT;

SELECT DEPTNO FROM DEPT
INTERSECT
SELECT DEPTNO FROM EMP;


SELECT DEPTNO FROM DEPT
INTERSECT
SELECT DEPTNO FROM EMP;


SELECT ENAME, DEPTNO, SAL,
    CASE
        WHEN DEPTNO = 10 THEN TRUNC(SAL*0.003)
        WHEN DEPTNO = 20 THEN TRUNC(SAL*0.2)
        WHEN DEPTNO = 30 THEN TRUNC(SAL*0.1)
        ELSE TRUNC(SAL*0.01)
    END AS BONUS
FROM EMP
ORDER BY DEPTNO, BONUS;
        
SELECT DEPTNO, ENAME, SAL FROM
    (SELECT DEPTNO, ENAME, SAL
    FROM EMP
    ORDER BY SAL DESC)
WHERE ROWNUM <=5;


select dbms_random.value(1,5) from dual;