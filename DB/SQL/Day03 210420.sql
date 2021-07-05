DESC DUAL; --�Ѱ��� �÷��� �ο츦 ���� ���̺�
SELECT * FROM DUAL;

SELECT sysdate FROM DUAL; --DBMS�� ���� ��¥�� �ð��� �����ϴ� �Լ�
SELECT 123456*123456, to_char(123456*123456, '999,999,999,999') FROM DUAL; --type conversion �Լ�

SELECT 300+400, 300/0 FROM DUAL;
SELECT 300+400, 300+NULL, 300/NULL FROM DUAL;
SELECT ENAME, SAL, COMM, COMM+SAL * 0.3 AS BONUS FROM EMP;

SELECT EMPNO, SAL, COMM FROM EMP;

SELECT EMPNO, SAL, COMM FROM EMP WHERE COMM=null;
SELECT EMPNO, SAL, COMM FROM EMP WHERE COMM!=null; -- != ^= <> not =

SELECT EMPNO, SAL, COMM FROM EMP WHERE COMM is null;
SELECT EMPNO, SAL, COMM FROM EMP WHERE COMM is not null;

SELECT ENAME, length(ENAME), COMM, length(COMM) FROM EMP; -- length(COMM) : ������ ����ȯ
SELECT SAL-EMPNO, abs(SAL-EMPNO), abs(SAL-COMM)+100 FROM EMP; -- ABS : ����

SELECT concat(ENAME||' is', COMM), nvl(COMM,-1), decode(COMM, null, -999, COMM) FROM EMP;




select to_char(systimestamp, 'YYYY-MM-DD HH:MI:SS:FF2') from dual;
select to_char(systimestamp, 'YYYY-MM-DD HH:MI:SS:FF3') from dual;

select systimestamp from dual;
select to_date('2013-09-06 13:15:24','YYYY-MM-DD HH24:MI:SS') from dual;

SELECT TO_CHAR
    (SYSDATE, 'MM-DD-YYYY HH24:MI:SS') AS NOW
     FROM DUAL;

SELECT TO_CHAR
(SYSDATE, 'MM-DD-YYYY HH24:MI:SS') AS NOW FROM DUAL;

    
SELECT SYSDATE FROM DUAL;

SELECT to_char(SYSTIMESTAMP, 'YYYY-MM-DD HH:MI:SS:FF2') FROM DUAL;
SELECT to_char(SYSTIMESTAMP, 'YYYY-MM-DD HH:MI:SS:FF3') FROM DUAL;