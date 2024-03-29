DROP TABLE SCOTT.CUST;
CREATE TABLE SCOTT.CUST(
    ID      VARCHAR2(8) NOT NULL,
    PWD     VARCHAR2(8) CONSTRAINT CUST_PWD_NN NOT NULL,
    NAME    VARCHAR2(20), -- �̸�
    SEX     CHAR(1),      -- ���� [M|F]
    AGE     NUMBER(3)
)   TABLESPACE USERS PCTFREE 5 PCTUSED 60 INITRANS 2 MAXTRANS 20
    STORAGE(INITIAL 100K NEXT 100K MINEXTENTS 3 MAXEXTENTS 10 PCTINCREASE 0);