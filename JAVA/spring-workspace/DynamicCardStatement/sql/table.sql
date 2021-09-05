--1. 사용자정보 T_MEMBER
DROP TABLE T_MEMBER;
DROP SEQUENCE T_MEMBER_SEQ;
CREATE SEQUENCE T_MEMBER_SEQ;
CREATE TABLE T_MEMBER
(
    MEMBER_NO NUMBER DEFAULT T_MEMBER_SEQ.NEXTVAL CONSTRAINT MEMBER_MEMBER_NO_PK PRIMARY KEY,
    ID VARCHAR2(20) CONSTRAINT MEMBER_ID_UK UNIQUE,
    PW VARCHAR2(20) CONSTRAINT MEMBER__PW_NN NOT NULL,
    NAME VARCHAR2(20) CONSTRAINT NAME_NN NOT NULL,
    MOBILE_NO VARCHAR2(20) CONSTRAINT MEMBER_NO_NN NOT NULL,
    RRN VARCHAR2(20) CONSTRAINT MEMBER_RRN_UK UNIQUE,
    BIRTHDAY VARCHAR2(20) CONSTRAINT MEMBER_BIRTHDAY_NN NOT NULL,
    AGE NUMBER CONSTRAINT MEMBER_AGE_NN NOT NULL,
    GENDER VARCHAR2(20) CONSTRAINT MEMBER_GENDER_NN NOT NULL CHECK (GENDER IN ('F', 'M')),
    ISNATIVE VARCHAR2(20) CONSTRAINT MEMBER_NATIVE_NN NOT NULL CHECK (ISNATIVE IN ('N', 'F')),
    MANAGER_NO NUMBER DEFAULT NULL,
    USER_TYPE VARCHAR2(20) DEFAULT 'U' CONSTRAINT MEMBER_USER_TYPE_NN NOT NULL CHECK (USER_TYPE IN ('U', 'A')) ,
    ADDRESS VARCHAR2(100) CONSTRAINT MEMBER_USER_ADDRESS_NN NOT NULL,
    ADDRESS_DETAIL VARCHAR2(100) CONSTRAINT MEMBER_ADDRESS_DETAIL_NN NOT NULL
);

-----------------------------------
--2. 카드 CARD

DROP TABLE CARD;
CREATE TABLE CARD (
    CARD_CODE NUMBER(10) CONSTRAINT CARD_CARD_CODE_PK PRIMARY KEY, 
    CARD_NAME VARCHAR2(200) CONSTRAINT CARD_CARD_NAME_UK UNIQUE,
    CARD_CATEGORY VARCHAR2(20),
    ANNUAL_FEE NUMBER(10)
);

-----------------------------------
--3. 신용카드공지사항 CREDIT_CARD_NOTICE
DROP TABLE CREDIT_CARD_NOTICE;
DROP SEQUENCE CREDIT_CARD_NOTICE_SEQ;
CREATE SEQUENCE CREDIT_CARD_NOTICE_SEQ;


SELECT * FROM CREDIT_CARD_NOTICE;

-----------------------------------
--3. 혜택카테고리 (BENEFITS_CATEGORY)
CREATE TABLE CARD_BENEFITS_CATEGORY (
    CATEGORY VARCHAR2(50) CONSTRAINT BENEFTIS_CATEGORY_PK PRIMARY KEY,
    CATEGORY_KOR VARCHAR2(200)
);

-----------------------------------
--4. 카드 혜택 (CARD_BENEFTIS)
DROP SEQUENCE CARD_BENEFITS_SEQ;
DROP TABLE CARD_BENEFITS;

CREATE SEQUENCE CARD_BENEFITS_SEQ;
CREATE TABLE CARD_BENEFITS (
    BENEFITS_NO NUMBER DEFAULT CARD_BENEFITS_SEQ.NEXTVAL CONSTRAINT CARD_BENEFITS_PK PRIMARY KEY,
    CARD_NAME VARCHAR2(200),
    CATEGORY VARCHAR2(50),
    BENEFIT_TYPE VARCHAR2(20),
    BENEFIT NUMBER(10, 3) CONSTRAINT CARD_BENEFITS_NN NOT NULL,
    CONSTRAINT CARD_BENEFITS_CARD_NAME_FK FOREIGN KEY (CARD_NAME) REFERENCES CARD(CARD_NAME),
    CONSTRAINT CARD_BENEFITS_CARD_CATEGORY_FK FOREIGN KEY (CATEGORY) REFERENCES CARD_BENEFITS_CATEGORY(CATEGORY)  
);

SELECT * FROM CARD_BENEFITS;
-----------------------------------
--5. 신용카드 공지 (CREDIT_CARD_NOTICE)
DROP SEQUENCE CREDITCARD_NOTICE_SEQ;
DROP TABLE CREDITCARD_NOTICE;

CREATE SEQUENCE CREDITCARD_NOTICE_SEQ;
CREATE TABLE CREDITCARD_NOTICE (
    NOTICE_NO NUMBER DEFAULT CREDITCARD_NOTICE_SEQ.NEXTVAL CONSTRAINT CREDITCARD_NOTICE_PK PRIMARY KEY,
    CARD_NAME VARCHAR2(200),
    CATEGORY VARCHAR2(50),
    NOTICE VARCHAR2(300) CONSTRAINT CREDITCARD_NOTICE_NOTICE_NN NOT NULL,
    CONSTRAINT CREDITCARD_NOTICE_CARD_NAME_FK FOREIGN KEY (CARD_NAME) REFERENCES CARD(CARD_NAME),
    CONSTRAINT CREDITCARD_NOTICE_CARD_CATEGORY_FK FOREIGN KEY (CATEGORY) REFERENCES CARD_BENEFITS_CATEGORY(CATEGORY)
);

SELECT COUNT(*) FROM CREDITCARD_NOTICE;



-----------------210903














-----------------------------------
--4. 사용자카드 MEMBER_CARD
DROP TABLE MEMBER_CARD;
CREATE TABLE MEMBER_CARD
(
    CARD_NO VARCHAR2(30) CONSTRAINT MEMBER_CARD_CARD_NO_PK PRIMARY KEY,
    MEMBER_NO NUMBER,
    CARD_NAME VARCHAR2(30),
    CARD_PASSWORD VARCHAR2(20) CONSTRAINT MEMBER_CARD_CARD_PASSWORD_NN NOT NULL,
    VALID_DATE DATE CONSTRAINT MEMBER_CARD_VALID_DATE_NN NOT NULL,
    CARD_TYPE VARCHAR(20) CONSTRAINT MAMBER_CARD_CARD_TYPE_NN NOT NULL CHECK (CARD_TYPE IN ('CHECK', 'CREDIT')),
    CVC_NO VARCHAR2(30) CONSTRAINT MEMBER_CARD_CARD_CVV_NO_NN NOT NULL, 
    CONSTRAINT MEMBER_CARD_MEMBER_NO_FK FOREIGN KEY(MEMBER_NO) REFERENCES T_MEMBER(MEMBER_NO),
    CONSTRAINT MEMBER_CARD_CARD_NAME_FK FOREIGN KEY(CARD_NAME) REFERENCES CARD_INFO(CARD_NAME)
);









-----------------------------------
>>>>>>> 3ad9de92f44e3ee8a2c53eaf6421d9b6ef10b407
--1. 관리사원 MANAGER
DROP TABLE MANAGER;

CREATE TABLE MANAGER
(
    MANAGER_NO NUMBER CONSTRAINT MANAGER_MANAGER_NO_PK PRIMARY KEY,
    NAME VARCHAR2(20) CONSTRAINT MANAGER_NAME_NN NOT NULL,
    DEPT VARCHAR2(100) CONSTRAINT MANAGER_DEPT_NN NOT NULL
);

-----------------------------------
--2. 사용자정보 T_MEMBER
DROP TABLE T_MEMBER;
DROP SEQUENCE T_MEMBER_SEQ;
CREATE SEQUENCE T_MEMBER_SEQ;
CREATE TABLE T_MEMBER
(
    MEMBER_NO NUMBER DEFAULT T_MEMBER_SEQ.NEXTVAL CONSTRAINT MEMBER_MEMBER_NO_PK PRIMARY KEY,
    ID VARCHAR2(20) CONSTRAINT MEMBER_ID_UK UNIQUE,
    PW VARCHAR2(20) CONSTRAINT MEMBER__PW_NN NOT NULL,
    NAME VARCHAR2(20) CONSTRAINT NAME_NN NOT NULL,
    MOBILE_NO VARCHAR2(20) CONSTRAINT MEMBER_NO_NN NOT NULL,
    RRN VARCHAR2(20) CONSTRAINT MEMBER_RRN_UK UNIQUE,
    GENDER VARCHAR2(20) CONSTRAINT MEMBER_GENDER_NN NOT NULL,
    NATIVE VARCHAR2(20) CONSTRAINT MEMBER_NATIVE_NN NOT NULL,
    MANAGER_NO NUMBER,
    USER_TYPE VARCHAR2(20) CONSTRAINT MEMBER_USER_TYPE_NN NOT NULL,
    AGE NUMBER CONSTRAINT MEMBER_AGE_NN NOT NULL,
    ADDRESS VARCHAR2(100) CONSTRAINT MEMBER_USER_ADDRESS_NN NOT NULL,
    ADDRESS_DETAIL VARCHAR2(100) CONSTRAINT MEMBER_ADDRESS_DETAIL_NN NOT NULL
);

-----------------------------------
--3. 문의게시판 QA_BOARD

DROP TABLE QA_BOARD;
DROP SEQUENCE QA_BOARD_SEQ;
CREATE SEQUENCE QA_BOARD_SEQ;
CREATE TABLE QA_BOARD
(
    BOARD_NO NUMBER DEFAULT QA_BOARD_SEQ.NEXTVAL CONSTRAINT QA_BOARD_BOARD_NO_PK PRIMARY KEY,
    MEMBER_NO NUMBER,
    UPPER_NO NUMBER,
    CONTENT VARCHAR2(1000) CONSTRAINT QA_BOARD_CONTENT_NN NOT NULL,
    REPLY VARCHAR2(1000) NOT NULL,
    VIEW_CNT NUMBER CONSTRAINT QA_BAORD_VIEW_CNT_NN NOT NULL,
    REG_DATE DATE DEFAULT SYSDATE CONSTRAINT QA_BOARD_REG_DATE_NN NOT NULL,
    CONTENT_CATEGORY VARCHAR2(100) CONSTRAINT QA_BOARD_CONTENT_CATEGORY NOT NULL,
    CONSTRAINT QA_BOARD_MEMBER_NO_FK FOREIGN KEY(MEMBER_NO) REFERENCES MEMBER(MEMBER_NO)
);



-----------------------------------
--4. 사용자계좌 MEMBER_ACCOUNT
DROP TABLE MEMBER_ACCOUNT;
CREATE TABLE MEMBER_ACCOUNT
(
    ACC_NO VARCHAR2(30) CONSTRAINT MEMBER_ACCOUNT_ACC_NO_PK PRIMARY KEY,
    BALANCE NUMBER CONSTRAINT MEMBER_ACCOUNT_BALANCE_NN NOT NULL,
    ACC_PW VARCHAR2(10) CONSTRAINT MEMBER_ACCOUNT_ACC_PW_NN NOT NULL,
    ACC_NICKNAME VARCHAR2(30),
    ACC_CREATING_DATE DATE DEFAULT SYSDATE CONSTRAINT MEMBER_ACCOUNT_CREATING_DATE_NN NOT NULL,
    ACC_STATUS VARCHAR2(20) DEFAULT 'ACTIVE' CONSTRAINT MEMBER_ACCOUNT_ACC_STATUS_NN NOT NULL,
    MEMBER_NO NUMBER,
    CONSTRAINT MEMBER_ACCOUNT_MEMBER_NO_FK FOREIGN KEY(MEMBER_NO) REFERENCES MEMBER(MEMBER_NO)
    
);

-----------------------------------
--5. 카드정보 CARD_INFO
DROP TABLE CARD_INFO;
CREATE TABLE CARD_INFO
(
    CARD_NAME VARCHAR2(30) CONSTRAINT CARD_INFO_CARD_NAME_PK PRIMARY KEY,
    CARD_CREATING_DATE DATE DEFAULT SYSDATE CONSTRAINT CARD_INFO_CARD_CREATING_DATE_NN NOT NULL,
    CARD_CATEGORY VARCHAR2(30)
);

-----------------------------------
--6. 사용자카드 MEMBER_CARD
DROP TABLE MEMBER_CARD;
CREATE TABLE MEMBER_CARD
(
    CARD_NO VARCHAR2(20) CONSTRAINT MEMBER_CARD_CARD_NO_PK PRIMARY KEY,
    CARD_NAME VARCHAR2(30),
    CARD_PASSWORD VARCHAR2(20) CONSTRAINT MEMBER_CARD_CARD_PASSWORD_NN NOT NULL,
    ACC_NO VARCHAR2(30),
    CONSTRAINT MEMBER_CARD_CARD_NAME_FK FOREIGN KEY(CARD_NAME) REFERENCES CARD_INFO(CARD_NAME),
    CONSTRAINT MEMBER_CARD_ACC_NO_FK FOREIGN KEY(ACC_NO) REFERENCES MEMBER_ACCOUNT(ACC_NO)
);

-----------------------------------
--7. 사용자거래내역 TRANSACTION_HISTORY
DROP TABLE TRANSACTION_HISTORY;
DROP SEQUENCE TRANSACTION_HISTORY_SEQ;
CREATE SEQUENCE TRANSACTION_HISTORY_SEQ;
CREATE TABLE TRANSACTION_HISTORY
(

    HISTORY_NO NUMBER DEFAULT TRANSACTION_HISTORY_SEQ.NEXTVAL CONSTRAINT TRANSACTION_HISTORY_HISTORY_NO_PK PRIMARY KEY,
    HISTORY_DATE DATE DEFAULT SYSDATE CONSTRAINT TRANSACTION_HISTORY_HISTORY_DATE_NN NOT NULL,
    AMOUNT NUMBER CONSTRAINT TRANSACTION_HISTORY_AMOUNT_NN NOT NULL,
    CATEGORY VARCHAR2(30),
    HISTORY_TIME VARCHAR2(30) CONSTRAINT TRANSACTION_HISTORY_HISTORY_TIME_NN NOT NULL,
    STORE VARCHAR2(1000),
    CARD_NO VARCHAR2(20),
    CONSTRAINT TRANSACTION_HISTORY_CARD_NO_FK FOREIGN KEY(CARD_NO) REFERENCES MEMBER_CARD(CARD_NO)
);

-----------------------------------
--8. 사용자카드리뷰 CARD_REVIEW

DROP SEQUENCE CARD_REVIEW_SEQ;
DROP TABLE CARD_REVIEW;

CREATE SEQUENCE CARD_REVIEW_SEQ;
CREATE TABLE CARD_REVIEW
(
    REVIEW_NO NUMBER DEFAULT CARD_REVIEW_SEQ.NEXTVAL CONSTRAINT CARD_REVIEW_REVIEW_NO_PK PRIMARY KEY,
    GRADE NUMBER CONSTRAINT CARD_REVIEW_GRANDE_NN NOT NULL,
    BODY VARCHAR2(1000),
    REVIEW_DATE DATE DEFAULT SYSDATE CONSTRAINT CARD_REVIEW_REVIEW_DATE_NN NOT NULL,
    CARD_NO VARCHAR2(20),
    CONSTRAINT CARD_REVIEW_CARD_NO_FK FOREIGN KEY(CARD_NO) REFERENCES MEMBER_CARD(CARD_NO)
);



-----------------------------------
--9. 월간요약통계 MONTHLY SUMMARY
DROP SEQUENCE MONTHLY_SUMMARY_SEQ;
DROP TABLE MONTHLY_SUMMARY;

CREATE SEQUENCE MONTHLY_SUMMARY_SEQ;
CREATE TABLE MONTHLY_SUMMARY
(
    SUMMARY_NO NUMBER DEFAULT MONTHLY_SUMMARY_SEQ.NEXTVAL CONSTRAINT MONTHLY_SUMMARY_SUMMARY_NO_PK PRIMARY KEY,
    MAIN_CARD_NAME VARCHAR2(30) CONSTRAINT MONTHLY_SUMMARY_MAIN_CARD_NAME_NN NOT NULL,
    CARD_NO VARCHAR2(20),
    MOST_EXPENDITURE_CATEGORIES VARCHAR2(50) CONSTRAINT MONTHLY_SUMMARY_MEC_NN NOT NULL,
    MAX_OF_EXPENDITURE NUMBER CONSTRAINT MONTHLY_SUMMARY_MOE_NN NOT NULL,
    AVG_OF_EXPENDITURE_PER_CASE NUMBER CONSTRAINT MONTHLY_SUMMARY_AEC_NNn NOT NULL,
    MAX_EXPENDITURE_AREA VARCHAR2(100) CONSTRAINT MONTHLY_SUMMARY_MEA_NN NOT NULL,
    CONSTRAINT MONTHLY_SUMMARY_CARD_NO_FK FOREIGN KEY(CARD_NO) REFERENCES MEMBER_CARD(CARD_NO)
);

-----------------------------------
--10. 공통코드 TOTAL_CODE
DROP SEQUENCE TOTAL_CODE_SEQ;
DROP TABLE TOTAL_CODE;

CREATE SEQUENCE TOTAL_CODE_SEQ;
CREATE TABLE TOTAL_CODE
(
    CODE_NO NUMBER DEFAULT TOTAL_CODE_SEQ.NEXTVAL CONSTRAINT TOTAL_CODE_CODE_NO_PK PRIMARY KEY,
    LARGE_CATEGORY VARCHAR2(10) CONSTRAINT TOTAL_CODE_CODE_NO_LARGE_CATEGORY_NN NOT NULL,
    MEDIUM_CATEGORY VARCHAR2(10) CONSTRAINT TOTAL_CODE_CODE_NO_MEDIUM_CATEGORY_NN NOT NULL,
    SMALL_CATEGORY VARCHAR2(10) CONSTRAINT TOTAL_CODE_CODE_NO_SMALL_CATEGORY_NN NOT NULL
);

-----------------------------------
--11. 요약통계로그 SUMMARY_LOG
DROP TABLE SUMMARY_LOG;
DROP SEQUENCE SUMMARY_LOG_SEQ;

CREATE SEQUENCE SUMMARY_LOG_SEQ;
CREATE TABLE SUMMARY_LOG
(
    LOG_NO NUMBER DEFAULT SUMMARY_LOG_SEQ.NEXTVAL CONSTRAINT SUMMARY_LOG_LOG_NO_PK PRIMARY KEY,
    SENDING_DATE DATE DEFAULT SYSDATE CONSTRAINT SUMMARY_LOG_SENDING_DATE_NN NOT NULL,
    TOTAL NUMBER CONSTRAINT SUMMARY_LOG_TOTAL_NN NOT NULL,
    OPEN_RATE NUMBER CONSTRAINT SUMMARY_LOG_OPEN_RATE_NN NOT NULL
);






