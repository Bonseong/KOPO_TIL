-- T_CONS.SQL
START T_CONS.SQL

DESC CUST;
INSERT INTO CUST(ID, PWD, NAME, SEX, AGE) VALUES('xman', 'ok', 'kang', 'M', 21);
INSERT INTO CUST(ID, PWD, NAME, SEX, AGE) VALUES('XMAN', 'no', 'kim', 'T', -20);
INSERT INTO CUST(ID, NAME, AGE) VALUES('zman', 'son', 99); -- 에러, PWD는 NOT NULL이기 때문이 반드시 입력해야함
INSERT INTO CUST(ID, PWD, NAME, AGE) VALUES('rman', NULL, 'jjang', 24); -- 에러, PWD는 NOT NULL이기 때문이 반드시 입력해야함
INSERT INTO CUST(ID, PWD, NAME, AGE) VALUES('', 'pwd', 'jjang', 24);

UPDATE CUST SET AGE=-1, NAME = NULL;
UPDATE CUST SET PWD = NULL WHERE ID = 'XMAN'; -- PWD는 NOT NULL
UPDATE CUST SET PWD = NULL;

SELECT * FROM CUST;

-- T_CONS2.SQL
START T_CONS2.SQL

DESC CUST2;
INSERT INTO CUST2(ID, PWD, NAME, SEX, AGE) VALUES('xman', 'ok', 'kang', 'M', 21);
INSERT INTO CUST2(ID, PWD, NAME, SEX, AGE) VALUES('xman', 'ok', 'jjang', 'M', 20);
INSERT INTO CUST2(ID, PWD, NAME, SEX, AGE) VALUES('XMAN', 'no', 'kim', 'M', -20); -- AGE 제약조건 위배
INSERT INTO CUST2(ID, PWD, NAME, AGE) VALUES('asura', 'ok', 'joo', 99);
INSERT INTO CUST2(ID, PWD, NAME, SEX, AGE) VALUES('harisu', 'ok', 'susu', 'T', 33); -- SEX 제약조건 위배
INSERT INTO CUST2(ID, PWD, NAME, SEX, AGE) VALUES('shinsun', 'ok', '도사', 'M', 999); -- AGE 제약조건 위배
UPDATE CUST2 SET AGE = AGE + 1; -- 99 데이터가 있기 때문에 제약조건 위배

SELECT * FROM CUST2;

-- T_CONS3.SQL
START T_CONS3.SQL

INSERT INTO CUST3(ID, PWD, NAME, MOBILE, AGE) VALUES ('xman', 'ok', 'kang', '011-3333', 21);
INSERT INTO CUST3(ID, PWD, NAME, MOBILE, AGE) VALUES ('yman', 'yes', 'lee', '011-3333', 28); -- MOBILE 제약조건 위배
INSERT INTO CUST3(ID, PWD, NAME, MOBILE, AGE) VALUES ('XMAN', 'yes', 'kim', '011-3334', 33); -- 대소문자 구별
INSERT INTO CUST3(ID, PWD, NAME, MOBILE, AGE) VALUES ('xman', 'yes', 'lee', '011-3335', -21); -- 대소문자 구별, ID 제약조건 위배
INSERT INTO CUST3(ID, PWD, NAME, MOBILE) VALUES ('무명', 'yes', NULL, NULL); -- UNIQUE는 NULL 허용

ALTER TABLE CUST3 ADD CONSTRAINT CUST3_NAME_SEX_UK UNIQUE(NAME, SEX);
ALTER TABLE CUST3 MODIFY(NAME NOT NULL);

INSERT INTO CUST3(ID, PWD, NAME, SEX) VALUES('rman', 'yes', 'ksh', 'M');
INSERT INTO CUST3(ID, PWD, NAME, SEX) VALUES('Rman', 'yes', 'ksh', 'F');
INSERT INTO CUST3(ID, PWD, NAME, SEX) VALUES('RmaN', 'yes', 'ksh', 'M');


-- PL/SQL
--CREATE OR REPlACE TRIGGER TRG_EMP_UPD_SAL
--BEFORE UPDATE ON EMP
--FOR EACH ROW
--BEGIN
--    IF :NEW.SAL < 0 THEN
--        :NEW.SAL := 0;
--    END IF;
--END;    

SELECT * FROM EMP;

UPDATE EMP SET SAL = -999 WHERE DEPTNO = 10;


-- T_CONS4.SQL
START T_CONS4.SQL

INSERT INTO CUST4(ID, PWD, NAME, MOBILE) VALUES('zman', 'ok', '한국', '011');
INSERT INTO CUST4(ID, PWD, NAME) VALUES('xman', 'ok', 'king');
INSERT INTO CUST4(ID, PWD, NAME) VALUES('xman', 'power', 'zzang'); -- PK에 대한 제약조건 위배
INSERT INTO CUST4(ID, PWD, NAME) VALUES('Xman', 'korea', 'dbzzang');
INSERT INTO CUST4(ID, PWD, NAME) VALUES(lower('Xman'), 'ok', 'dbzzang'); -- values절에서 함수 사용 -> PK에 대한 제약조건 위배
INSERT INTO CUST4(PWD, NAME) VALUES('korea', 'dbzzang'); -- PK는 NULL을 허용하지 않음

UPDATE CUST4 SET ID = NULL; -- PK는 NULL을 허용하지 않음
UPDATE CUST4 SET ID = 'XMAN'; -- PK는 UNIQUE해야 함

SELECT INDEX_NAME, INDEX_TYPE, UNIQUENESS FROM USER_INDEXES WHERE TABLE_NAME = 'CUST4';
SELECT INDEX_NAME, COLUMN_POSITION, COLUMN_NAME FROM USER_IND_COLUMNS
WHERE TABLE_NAME = 'CUST4' ORDER BY INDEX_NAME, COLUMN_POSITION;

-- 소유 테이블, 제약사항 확인
SELECT * FROM USER_TABLES;
SELECT * FROM USER_CONSTRAINTS;

-- 제약사항 확인
SELECT TABLE_NAME, CONSTRAINT_NAME, CONSTRAINT_TYPE, SEARCH_CONDITION FROM USER_CONSTRAINTS WHERE TABLE_NAME = 'CUST';