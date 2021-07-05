CREATE OR REPLACE FUNCTION CALC_BONUS(P_SALARY IN NUMBER, P_DEPTNO IN NUMBER) -- 함수 내부로 전달되는 파라미터 (이름, 모드, 데이터타입)
RETURN NUMBER -- 리턴하는 데이터 타입
IS
    V_BONUS_RATE    NUMBER  :=0;
    V_BONUS         NUMBER(7,2) :=0;
BEGIN
    IF P_DEPTNO = 10 THEN
        V_BONUS_RATE := 0.1;
    ELSIF P_DEPTNO = 20 THEN
        V_BONUS_RATE := 0.2;
    ELSIF P_DEPTNO = 30 THEN
        V_BONUS_RATE := 0.3;
    ELSE
        V_BONUS_RATE := 0.05;
    END IF;
    -- BONUS := ROUND(NVL(P_SALARY,0) * C_BONUS_RATE,2); -- 식별자가 정의되어야 함
    RETURN V_BONUS;
END CALC_BONUS;    
/
        
    