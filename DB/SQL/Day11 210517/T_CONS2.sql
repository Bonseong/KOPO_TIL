DROP TABLE SCOTT.CUST2;
CREATE TABLE SCOTT.CUST2(
    ID      VARCHAR2(8) NOT NULL,
    PWD     VARCHAR2(8) CONSTRAINT CUST2_PWD_NN NOT NULL,
    NAME    VARCHAR2(20), -- �̸�
    SEX     CHAR(1)     CONSTRAINT CUST2_SEX_CK CHECK (SEX IN ('F', 'M')),
    AGE     NUMBER(3)   CHECK (AGE > 0 AND AGE < 100)
) 