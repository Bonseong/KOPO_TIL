DROP TABLE �μ�;

CREATE TABLE �μ� (
    �μ�ID   VARCHAR2(2)
        CONSTRAINT DEPARTMENT_�μ�ID_PK PRIMARY KEY,
    �μ���    VARCHAR2(10)
);

DROP TABLE EMPLOYEE;

CREATE TABLE EMPLOYEE (
    EMPID   VARCHAR2(8),
    �μ�ID    VARCHAR2(2),
    CONSTRAINT EMPLOYEE_�μ�_�μ�ID_FK FOREIGN KEY ( �μ�ID )
        REFERENCES �μ� ( �μ�ID )
);

DESC �μ�;
DESC EMPLOYEE;