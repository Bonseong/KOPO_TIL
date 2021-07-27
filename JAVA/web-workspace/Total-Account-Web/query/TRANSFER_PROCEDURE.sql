DECLARE
V_SENDING_BANK_NAME VARCHAR2(40) := 'MG구마을금고'; 
V_SENDING_ACC_NO VARCHAR2(20) := '111-111-111';

V_REMITTANCE NUMBER := 100;
V_RECEIVING_BANK_NAME VARCHAR2(40) := 'WC'; 
V_RECEIVING_ACC_NO VARCHAR2(20) := '222-222-222';

V_SENDING_BALANCE NUMBER := 1000; -- 보내는 계좌의 잔액
V_RECEIVING_BALANCE NUMBER := 1000; -- 받는 계좌의 잔액

BEGIN 
    -- 출금
    IF V_SENDING_BANK_NAME='세진저축은행' THEN 
        UPDATE T_ACCOUNT SET BALANCE=BALANCE-V_REMITTANCE WHERE ACC_NO=V_SENDING_ACC_NO;
        INSERT INTO TRANSFER_LOG(SENDING_BANK_NAME, SENDING_ACC_NO, BEFORE_BALANCE, REMITTANCE, AFTER_BALANCE, RECEIVING_BANK_NAME, RECEIVING_ACC_NO) VALUES (V_SENDING_BANK_NAME, V_SENDING_ACC_NO, V_SENDING_BALANCE, V_REMITTANCE, V_SENDING_BALANCE-V_REMITTANCE, V_RECEIVING_BANK_NAME, V_RECEIVING_ACC_NO);
    ELSIF V_SENDING_BANK_NAME='WC' THEN
        UPDATE WC_ACCOUNT@WC SET ACC_BALANCE=ACC_BALANCE-V_REMITTANCE WHERE ACC_NUM=V_SENDING_ACC_NO;
        INSERT INTO WC_LOG@WC (ACC_NUM, ACTION, AMOUNT, OTHER_ACC_NUM, OTHER_BANK_NAME, PRE_BALANCE, POST_BALANCE) VALUES(V_SENDING_ACC_NO, 'W' , V_REMITTANCE, V_RECEIVING_ACC_NO, (SELECT BANK_CODE FROM BANK_INFO WHERE BANK_NAME = V_RECEIVING_BANK_NAME), V_SENDING_BALANCE, V_SENDING_BALANCE-V_REMITTANCE);
    ELSIF V_SENDING_BANK_NAME='MG구마을금고' THEN
        UPDATE MG_BANK@MG SET BALANCE = BALANCE-V_REMITTANCE WHERE ACCOUNT_NUMBER=V_SENDING_ACC_NO;
        INSERT INTO BANK_ORDERS@MG VALUES(BANKORDERS_SEQ.NEXTVAL@MG, V_SENDING_BALANCE-V_REMITTANCE, '이체(출금)', SYSDATE, V_RECEIVING_ACC_NO, V_RECEIVING_BANK_NAME, V_SENDING_BALANCE, 1);
    ELSE
        DBMS_OUTPUT.PUT_LINE( '출금오류' );
   END IF;
   
   -- 입금
   IF V_RECEIVING_BANK_NAME='세진저축은행' THEN 
        UPDATE T_ACCOUNT SET BALANCE=BALANCE+V_REMITTANCE WHERE ACC_NO=V_RECEIVING_ACC_NO;
        INSERT INTO TRANSFER_LOG(SENDING_BANK_NAME, SENDING_ACC_NO, BEFORE_BALANCE, REMITTANCE, AFTER_BALANCE, RECEIVING_BANK_NAME, RECEIVING_ACC_NO) VALUES (V_SENDING_BANK_NAME, V_SENDING_ACC_NO, V_RECEIVING_BALANCE, V_REMITTANCE, V_RECEIVING_BALANCE+V_REMITTANCE, V_RECEIVING_BANK_NAME, V_RECEIVING_ACC_NO);
    ELSIF V_RECEIVING_BANK_NAME='WC' THEN
        UPDATE WC_ACCOUNT@WC SET ACC_BALANCE=ACC_BALANCE+V_REMITTANCE WHERE ACC_NUM=V_RECEIVING_ACC_NO;
        INSERT INTO WC_LOG@WC (ACC_NUM, ACTION, AMOUNT, OTHER_ACC_NUM, OTHER_BANK_NAME, PRE_BALANCE, POST_BALANCE) VALUES(V_RECEIVING_ACC_NO, 'D' , V_REMITTANCE, V_SENDING_ACC_NO, (SELECT BANK_CODE FROM BANK_INFO WHERE BANK_NAME = V_SENDING_BANK_NAME), V_RECEIVING_BALANCE, V_RECEIVING_BALANCE+V_REMITTANCE);
    ELSIF V_RECEIVING_BANK_NAME='MG구마을금고' THEN
        UPDATE MG_BANK@MG SET BALANCE = BALANCE+V_REMITTANCE WHERE ACCOUNT_NUMBER=V_RECEIVING_ACC_NO;
        INSERT INTO BANK_ORDERS@MG VALUES(BANKORDERS_SEQ.NEXTVAL@MG, V_RECEIVING_BALANCE+V_REMITTANCE, '이체(입금)', SYSDATE, V_SENDING_ACC_NO, V_SENDING_BANK_NAME, V_RECEIVING_BALANCE, 1);
    ELSE
        DBMS_OUTPUT.PUT_LINE( '입금오류' );    
   END IF;
EXCEPTION
    WHEN OTHERS THEN
    ROLLBACK;
END;
/