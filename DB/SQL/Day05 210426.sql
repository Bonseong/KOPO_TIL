SET FEEDBACK OFF
SET HEAD ON
SPOOL C:\Oracle\EMP_FINAL.CSV
SELECT /*csv*/ DEPTNO,SAL*12 AS ANUAL_SAL,ENAME,JOB,HIREDATE FROM EMP ORDER BY DEPTNO;

SELECT * FROM SCOTT.EMP;

SELECT to_char("202") as a FROM dual;


SELECT ENAME,HIREDATE,SAL FROM EMP WHERE HIREDATE between to_date('81/02/20','yy/mm/dd') and to_date('82/12/09','yy/mm/dd');

SELECT HIREDATE+to_char(123) FROM EMP;

SELECT HIREDATE + to_char(01/01/01) FROM EMP;

CREATE TABLE D as (SELECT HIREDATE + TO_CHAR(TO_DATE('01', 'YY'), 'YYYY') as aa  FROM EMP);



SELECT * FROM SALGRADE;
SELECT * FROM EMP;
SELECT * FROM EMP WHERE 850 BETWEEN DEPTNO AND SAL;

create table c as(
select to_char(3) + 1 as a FROM EMP);

desc b;

SELECT TO_CHAR(TO_DATE('50','YY'),'YYYY') FROM DUAL;

create x as (SELECT HIREDATE + to_char(to_date('01/01/01','YY/MM/DD')) FROM EMP);

select * from user_tables;

create table test as (select hiredate from emp where hiredate like '81%');

desc test;