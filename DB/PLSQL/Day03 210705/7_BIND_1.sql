VARIABLE H_SALARY NUMBER
VARIABLE H_TAX NUMBER

DECLARE
    C_TAX_RATE NUMBER(2,3);
BEGIN
    C_TAX_RATE := 0.05; -- PL/SQL���� ����
    :H_SALARY := 1000; -- ���� ���� ������ ����
    
    :H_TAX := ROUND(:H_SALARY * C_TAX_RATE, 2);
END;
/

PRINT H_SALARY
PRINT H_TAX
PRINT
--��� ������ �� ���
