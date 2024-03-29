CREATE OR REPLACE PROCEDURE CHANGE_SALARY(A_EMPNO IN NUMBER, A_SALARY NUMBER DEFAULT 2000)
AS
    V_AVG_SALARY    EMP.SAL%TYPE;
    V_SALARY        EMP.SAL%TYPE;
    V_MAX_SALARY    EMP.SAL%TYPE    :=  90000;
    V_ADD_SALARY_RATE   NUMBER      :=  0.02;
BEGIN
    SELECT AVG(SAL) INTO V_AVG_SALARY FROM EMP;
    
    IF A_SALARY < V_AVG_SALARY THEN
        V_SALARY := A_SALARY+ ROUND(A_SALARY + V_ADD_SALARY_RATE,1);
    ELSIF A_SALARY > 99999 THEN
        V_SALARY := -99999;
    ELSIF A_SALARY IS NULL THEN
        V_SALARY := 0;
    ELSE
        V_SALARY := A_SALARY;
    END IF;
    
    UPDATE EMP SET SAL = V_SALARY WHERE EMPNO = A_EMPNO;
    
    COMMIT;

EXCEPTION
    WHEN OTHERS THEN DBMS_OUTPUT.PUT_LINE('OTHERS => : ' || SQLERRM);
    ROLLBACK;
END CHANGE_SALARY;
/

