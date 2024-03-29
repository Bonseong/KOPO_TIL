CREATE TABLE EXCEPTION_LOG
(   LOG_DATE    VARCHAR2(8) DEFAULT TO_CHAR(SYSDATE, 'YYYYMMDD'),
    LOG_TIME    VARCHAR2(6) DEFAULT TO_CHAR(SYSDATE, 'HH24MISS'),
    PROGRAM_NAME    VARCHAR2(100),
    ERROR_MESSAGE   VARCHAR2(250),
    DESCRIPTION VARCHAR2(250)
);

CREATE OR REPLACE PROCEDURE CHANGE_SALARY(A_EMPNO IN NUMBER, A_SALARY NUMBER DEFAULT 2000)
AS
    V_ERROR_MESSAGE EXCEPTION_LOG.ERROR_MESSAGE%TYPE;
BEGIN
    UPDATE EMP SET SAL = A_SALARY WHERE EMPNO = A_EMPNO;
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
    ROLLBACK;
    
    BEGIN
        V_ERROR_MESSAGE := SQLERRM;
        INSERT INTO EXCEPTION_LOG(PROGRAM_NAME, ERROR_MESSAGE, DESCRIPTION) VALUES('CHANGE_SALARY', V_ERROR_MESSAGE,'VALUES : [1]=>'||A_EMPNO||' [2]=>'||A_SALARY);
        COMMIT; -- 에러로그 테이블에 에러에 대한 상세정보
    EXCEPTION
        WHEN OTHERS THEN -- 에러로그에 대한 예외처리
            NULL;
    END;
END CHANGE_SALARY;
/

EXECUTE CHANGE_SALARY(7369, 1234567);

SELECT * FROM EXCEPTION_LOG;