DECLARE
    LOOP_INDEX  NUMBER(4)   :=  1;
    MAX_LOOP_INDEX  NUMBER(4)   :=  30; -- �����ص� �Ǵ� �κ�
BEGIN
    --FOR LOOP_INDEX  IN  1..30 -- ����
    --FOR LOOP_INDEX  IN  30..1
    FOR LOOP_INDEX  IN  REVERSE 30..1 -- ����
    --FOR LOOP_INDEX  IN  REVERSE 1..30
    LOOP
        DBMS_OUTPUT.PUT_LINE('LOOP COUNT '||TO_CHAR(LOOP_INDEX));
    END LOOP;
END;    