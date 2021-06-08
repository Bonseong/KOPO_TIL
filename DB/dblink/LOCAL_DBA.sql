--1. LOCAL DB DBA 계정 (CLIENT) - 서버실 (SERVER)
--- 클라이언트
CREATE DATABASE LINK TLINK CONNECT TO DA2103 IDENTIFIED BY "da03" USING
'(DESCRIPTION=
 (ADDRESS_LIST=
  (ADDRESS=(PROTOCOL=TCP)(HOST=192.168.217.202)(PORT=1521))
 )
 (CONNECT_DATA=
 (SERVICE_NAME=KOPODA)
 )
)';

DROP DATABASE LINK TLINK;

SELECT * FROM TEST_TABLE@TLINK;


INSERT INTO SERVER_TABLE@TLINK(VAR1, VAR2) VALUES (4, 'test4');
INSERT INTO SERVER_TABLE@TLINK(VAR1, VAR2) VALUES (5, 'test5');
INSERT INTO SERVER_TABLE@TLINK(VAR1, VAR2) VALUES (6, 'test6');

COMMIT;

SELECT * FROM SERVER_TABLE@TLINK;
SELECT * FROM CLIENT_TABLE;

UPDATE SERVER_TABLE@TLINK SET VAR1 = 10 WHERE VAR2='test';


--2. LOCAL DB DBA 계정 (SERVER) - 서버실 (CLIENT)
--- 서버



--3. LOCAL DBA
--- 클라이언트
GRANT CREATE DATABASE LINK TO SCOTT;
GRANT CREATE PUBLIC DATABASE LINK TO SCOTT;
GRANT DROP PUBLIC DATABASE LINK TO SCOTT;

--4. 분산트랜잭션 구현
CREATE TABLE B_BANK (
    ACC VARCHAR(32) ,
    SUM NUMBER(10)
);

INSERT INTO B_BANK VALUES('333-333-333', 30000);
INSERT INTO B_BANK VALUES('444-444-444', 40000);
COMMIT;

SELECT * FROM A_BANK@TLINK;
SELECT * FROM B_BANK;

BEGIN
    UPDATE B_BANK SET SUM = SUM - 10000 WHERE ACC = '333-333-333';
    UPDATE A_BANK@TLINK SET SUM = SUM + 100000000000 WHERE ACC = '111-111-111';
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
    ROLLBACK;
END;    
