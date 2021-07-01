-- SQL Day2

SELECT * FROM EMP; -- ��� �÷� ���
SELECT EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO FROM EMP; -- ���� ���� �÷� ���

SELECT LIST FROM EMP; -- LIST���� ����ϰ��� �ϴ� �÷�

SELECT EMPNO,ENAME,JOB,SAL FROM EMP;
SELECT SAL,JOB,EMPNO,ENAME FROM EMP;
SELECT EMPNO,EMPNO,EMPNO, ENAME,JOB,SAL FROM EMP; -- ������ �� ������� ����
SELECT EMPNO,SAL,8,'ORACLE' FROM EMP; -- �ش� ���� �÷��� �����, �÷����� �����͸� ������ �� // ������ �����ʹ� ' ' �� ǥ��

DESC EMP; -- �÷���, NULL ����, ������ Ÿ�� (Length)


SELECT * FROM EMP WHERE DEPTNO = 10;
SELECT EMPNO, ENAME, JOB, SAL FROM EMP WHERE SAL > 2000;

SELECT EMPNO, ENAME, JOB, SAL, DEPTNO FROM EMP WHERE DEPTNO = 10 AND SAL > 2000; --�񱳿�����
SELECT DEPTNO, ENAME, JOB FROM EMP WHERE JOB = 'manager';
SELECT DEPTNO,ENAME,JOB FROM EMP WHERE 1=1; -- �׻� true ����
SELECT DEPTNO,ENAME,JOB FROM EMP WHERE 1=2; -- �׻� false ����

SELECT ENAME, SAL, SAL*12, COMM, COMM+300 FROM EMP; --SQL ��ɾ� ������ ��������� ���, NULL�� ��� ���굵 �Ұ�
SELECT SAL, SAL+300*12, (SAL+300)*12 FROM EMP; -- ���� �պ��� �켱������ ����, ��ȣ�� �ļ� �켱������ ���ȭ�ϴ� ���� ���� ���

SELECT ENAME, SAL+200 bonus, SAL*12 as annual_SAL, COMM, COMM+300 "Special Bonus" FROM EMP; -- as���
SELECT ENAME, COMM+300 AS "Special Bonus" FROM EMP; -- AS " �� ���� �÷��� ����
SELECT ENAME, COMM+300 ���ʽ� FROM EMP; -- ���鹮�ڸ� ���� �÷��� ����, �÷����� �ѱ۵� ����

SELECT ENAME||JOB FROM EMP;
SELECT ENAME||' is a '||JOB FROM EMP; -- ���ڿ��� ���� ���� ���� ó���� DB������ �ѱ�
SELECT ENAME||' "s JOB is '||JOB FROM EMP; -- ���ڿ��� ���� ������ ' ' ���� ó��, "�� ���ڿ��� ���� �̱� �����̼�
SELECT ENAME||' "s JOB is '||JOB as JOB_list FROM EMP; -- �÷��� ������
SELECT ENAME, SAL, SAL*100, SAL||'00',to_char(SAL)||'00' FROM EMP;

SELECT to_char(EMPNO)||','||ENAME||','||to_char(SAL)||','||to_char(DEPTNO) as EMP_csv FROM EMP;

