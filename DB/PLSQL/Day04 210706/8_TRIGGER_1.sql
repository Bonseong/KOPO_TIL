CREATE OR REPLACE TRIGGER TRG_CHANGE_SAL
BEFORE UPDATE OF SAL ON EMP -- ������ �����ϱ� ���� Ʈ���Ÿ� ���� (<-> AFTER)
FOR EACH ROW -- ������ ROW���� Ʈ���� ���� (Ʈ������ ���� Ƚ��)
BEGIN
    IF ( :NEW.SAL > 9000 ) THEN -- NEW : ������ ���� ��
        :NEW.SAL := 9000;
    END IF;
END;
/


UPDATE EMP SET SAL = 9500 WHERE EMPNO IN (7839, 7844);
SELECT * FROM EMP WHERE EMPNO IN (7839, 7844);
ROLLBACK;