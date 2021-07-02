SET SERVEROUTPUT ON

INSERT INTO dept VALUES ( 66,'OUTER_BLK_PART','Outlander' ); -- 실행됨

DECLARE
    v_dname    VARCHAR2(14);
    v_deptno   NUMBER(200); -- Compile Time Error 유발 요인 및 발생
    --V_DEPTNO NUMBER(2);
    v_loc      VARCHAR2(13);
BEGIN
    v_deptno := 77;
    v_dname := 'GLOBAL_PART';
    v_loc := 'Main_Blk';
    << nested_block_1 >> DECLARE
        v_dname    VARCHAR2(14);
        v_deptno   NUMBER(2);
    BEGIN
        v_deptno := 88;
        v_dname := 'LOCAL_PART_1';
        v_loc := 'Nested_Blk1';
        INSERT INTO dept VALUES ( v_deptno,v_dname,v_loc ); -- DEPTNO에서 컴파일 에러가 발생되므로 실행되지 않고 예외 발생, 예외를 받아주는 부분이 없으므로 실행되지 않음

        COMMIT;
    END nested_block_1;

    << nested_block_2 >> DECLARE
        v_dname    VARCHAR2(14);
        v_deptno   NUMBER(2);
    BEGIN
        v_deptno := 99;
        v_dname := 'LOCAL_PART_2';
        v_loc := 'Nested_Blk2';
        INSERT INTO dept VALUES ( v_deptno,v_dname,v_loc );

        COMMIT;
    END nested_block_2;

    INSERT INTO dept VALUES ( v_deptno,v_dname,v_loc );

END;
/

SELECT
    *
FROM
    dept
WHERE
    deptno IN (
        66,77,88,99
    );

DELETE FROM dept WHERE
    deptno IN (
        66,77,88,99
    );

COMMIT;