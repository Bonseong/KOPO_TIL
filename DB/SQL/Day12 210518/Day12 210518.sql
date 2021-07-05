-- T_CONS5.SQL
START T_CONS5.SQL

INSERT INTO EMPLOYEE VALUES('XMAN', '10'); -- �θ�Ű�� ����, ������� ����
INSERT INTO �μ�(�μ�ID, �μ���) VALUES('10', '������');
INSERT INTO �μ�(�μ�ID, �μ���) VALUES('20', '�����');

INSERT INTO EMPLOYEE VALUES('XMAN', '10');
INSERT INTO EMPLOYEE VALUES('XMAN', 'XX'); -- �θ�Ű�� ����, ������� ����
DELETE FROM �μ� WHERE �μ�ID = '10'; -- �ڽ� ���ڵ� ����, ������� ����

DROP TABLE �μ�; -- �ڽ� ���ڵ尡 �����ϱ� ������ ���� �Ұ�
DROP TABLE �μ� CASCADE CONSTRAINTS; -- �ڽ� ���ڵ尡 �����ϴ��� ����
DROP TABLE EMPLOYEE;

SELECT * FROM USER_CONSTRAINTS WHERE TABLE_NAME = 'EMPLOYEE'; -- FOREIGN KEY ��������� ���ŵǾ� ����

-- T_CONS5_2.SQL
START T_CONS5_2.SQL

SELECT TABLE_NAME, CONSTRAINT_NAME, CONSTRAINT_TYPE
FROM DBA_CONSTRAINTS WHERE TABLE_NAME IN ('DEPARTMENT', 'EMPLOYEE');

INSERT INTO EMPLOYEE(���, �̸�, DEPTNO) VALUES('XMAN', 'TUNER', '10'); -- �θ�Ű�� ����, ������� ����

INSERT INTO DEPARTMENT ( DEPTNO,DNAME ) VALUES ( '10','������' );
INSERT INTO DEPARTMENT ( DEPTNO,DNAME ) VALUES ( '20','������' );
INSERT INTO DEPARTMENT ( DEPTNO,DNAME ) VALUES ( '30','������' );

INSERT INTO EMPLOYEE ( ���,�̸�,DEPTNO ) VALUES ( 'XMAN','TUNER',10 );
INSERT INTO EMPLOYEE ( ���,�̸�,DEPTNO ) VALUES ( 'YMAN','DBA',20 );
INSERT INTO EMPLOYEE ( ���,�̸�,DEPTNO ) VALUES ( 'ZMAN','DEVELOPER',30 );

SELECT * FROM DEPARTMENT;

SELECT * FROM EMPLOYEE;

DELETE FROM DEPARTMENT WHERE DEPTNO = 30; -- �ڽ� ���ڵ� ����, ������� ����
DELETE FROM DEPARTMENT WHERE DEPTNO = 10; -- �ڽ� ���ڵ� ����, ������� ����
UPDATE EMPLOYEE SET DEPTNO=20 WHERE DEPTNO=10; -- DEPTNO�� 10�� �Ϳ� ���� 20���� ���� -> 10�� ���� FK ������ ������
DELETE FROM DEPARTMENT WHERE DEPTNO = 10; -- FK�� �������� �ʱ� ������ ���� ����
