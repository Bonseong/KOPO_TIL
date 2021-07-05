DROP TABLE TEMP;
CREATE TABLE TEMP AS (SELECT NAME, BIRTH_DT FROM CUSTOMER);
SELECT * FROM USER_INDEXES WHERE TABLE_NAME='CUSTOMER';

CREATE INDEX BIRTH_DT_IDX ON TEMP(BIRTH_DT);

SELECT * FROM ALL_IND_COLUMNS WHERE TABLE_NAME='TEMP';
SELECT * FROM USER_INDEXES WHERE TABLE_NAME='TEMP';

SELECT * FROM TEMP WHERE TO_CHAR(BIRTH_DT, 'yyyy') = 1981;

SELECT
    COUNT(*)
FROM
    TEMP
WHERE
    BIRTH_DT BETWEEN TO_DATE('1981-01-01','YYYY-MM-DD') AND TO_DATE('1981-12-31','YYYY-MM-DD');

SELECT
    COUNT(*)
FROM
    TEMP
WHERE
    BIRTH_DT BETWEEN TO_DATE('1981-01-01','YYYY-MM-DD') AND TO_DATE('1981-07-31','YYYY-MM-DD');
--------
SELECT * FROM CUSTOMER;
SET AUTOTRACE ON



SELECT * FROM CUSTOMER WHERE TO_CHAR(BIRTH_DT, 'yyyy-mm-dd') = '1997-07-20';

SET AUTOTRACE ON

SELECT
    *
FROM
    CUSTOMER
WHERE
    BIRTH_DT = TO_DATE('1997-07-20','YYYY-MM-DD'); 

DESC CUSTOMER;
SELECT * FROM CUSTOMER;

SELECT * FROM CUSTOMER WHERE BIRTH_DT = TO_DATE('1980/07/24','YYYY/MM/DD');