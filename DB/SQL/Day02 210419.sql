-- SQL Day2

SELECT * FROM EMP; -- 모든 컬럼 출력
SELECT EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO FROM EMP; -- 보고 싶은 컬럼 출력

SELECT LIST FROM EMP; -- LIST에는 출력하고자 하는 컬럼

SELECT EMPNO,ENAME,JOB,SAL FROM EMP;
SELECT SAL,JOB,EMPNO,ENAME FROM EMP;
SELECT EMPNO,EMPNO,EMPNO, ENAME,JOB,SAL FROM EMP; -- 실제로 잘 사용하지 않음
SELECT EMPNO,SAL,8,'ORACLE' FROM EMP; -- 해당 명의 컬럼을 만들고, 컬럼명의 데이터를 가지게 함 // 문자형 데이터는 ' ' 로 표시

DESC EMP; -- 컬럼명, NULL 여부, 데이터 타입 (Length)


SELECT * FROM EMP WHERE DEPTNO = 10;
SELECT EMPNO, ENAME, JOB, SAL FROM EMP WHERE SAL > 2000;

SELECT EMPNO, ENAME, JOB, SAL, DEPTNO FROM EMP WHERE DEPTNO = 10 AND SAL > 2000; --비교연산자
SELECT DEPTNO, ENAME, JOB FROM EMP WHERE JOB = 'manager';
SELECT DEPTNO,ENAME,JOB FROM EMP WHERE 1=1; -- 항상 true 리턴
SELECT DEPTNO,ENAME,JOB FROM EMP WHERE 1=2; -- 항상 false 리턴

SELECT ENAME, SAL, SAL*12, COMM, COMM+300 FROM EMP; --SQL 명령어 내에서 산술연산자 사용, NULL은 어떠한 연산도 불가
SELECT SAL, SAL+300*12, (SAL+300)*12 FROM EMP; -- 곱이 합보다 우선순위가 높음, 괄호를 쳐서 우선순위를 명료화하는 것이 좋은 방식

SELECT ENAME, SAL+200 bonus, SAL*12 as annual_SAL, COMM, COMM+300 "Special Bonus" FROM EMP; -- as사용
SELECT ENAME, COMM+300 AS "Special Bonus" FROM EMP; -- AS " 을 통한 컬럼명 지정
SELECT ENAME, COMM+300 보너스 FROM EMP; -- 공백문자를 통해 컬럼명 지정, 컬럼명은 한글도 가능

SELECT ENAME||JOB FROM EMP;
SELECT ENAME||' is a '||JOB FROM EMP; -- 문자열에 대한 가공 연산 처리를 DB서버에 넘김
SELECT ENAME||' "s JOB is '||JOB FROM EMP; -- 문자열에 대한 지정은 ' ' 으로 처리, "은 문자열에 대한 싱글 쿼테이션
SELECT ENAME||' "s JOB is '||JOB as JOB_list FROM EMP; -- 컬럼명 재정의
SELECT ENAME, SAL, SAL*100, SAL||'00',to_char(SAL)||'00' FROM EMP;

SELECT to_char(EMPNO)||','||ENAME||','||to_char(SAL)||','||to_char(DEPTNO) as EMP_csv FROM EMP;

