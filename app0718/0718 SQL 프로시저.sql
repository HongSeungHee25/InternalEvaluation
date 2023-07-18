SELECT * FROM p_buy#;
SELECT * FROM TBL_PRODUCT tp ; 


-- ※  준비 1. 문제 테이블 생성하기

CREATE TABLE p_buy#(
     buy_seq number(8) PRIMARY KEY ,
     customId varchar2(20) NOT NULL , -- 회원ID
     pcode varchar2(20) NOT NULL , -- 상품코드
     quantity number(5) DEFAULT 1 , --수량
     buy_date DATE,
     money number(7) CHECK (money >=10000), -- 수량x단가 = 구매금액
     FOREIGN KEY (customId)
                REFERENCES tbl_custom(custom_id), -- 회원테이블과 참조관계
     FOREIGN KEY (pcode)
                REFERENCES tbl_product(pcode) -- 상품테이블과 참조관계
);

-- ※  준비 2. 시퀀스생성과 컬럼 추가
CREATE SEQUENCE pbuy#_seq START WITH 1001;


-- 프로시저 생성
CREATE OR REPLACE PROCEDURE pbuy#_set_money(
	a_custom_id IN varchar2,		-- 회원 ID
	a_pcode IN varchar2,			-- 상품코드
	a_cnt IN NUMBER ,				-- 수량
	o_money OUT varchar2			-- fail 문자열 출력을 위해 편의상 varchar2로 함.
)
IS 
	vseq NUMBER;
	vprice NUMBER;
BEGIN
	INSERT INTO p_buy#(buy_seq,customid, pcode,quantity,buy_date)		-- 입력값 insert
		VALUES(pbuy#_seq.nextval, a_custom_id, a_pcode, a_cnt, sysdate);
	
	SELECT pbuy#_seq.currval INTO vseq									-- INSERT 한 시퀀스값 조회
		FROM dual;
	DBMS_OUTPUT.PUT_LINE('INSERT 시퀀스 값 : ' || vseq);					-- db 콘솔 출력

	SELECT price INTO vprice											-- 입력된 상품코드의 가격 조회
		FROM TBL_PRODUCT WHERE pcode = a_pcode;
	DBMS_OUTPUT.PUT_LINE(a_pcode || ' 상품의 가격 : ' || vprice);

	UPDATE p_buy# SET money = vprice * quantity							-- 위 insert한 가갹*수량 수식 결과로 money 컬럼값 수정
		WHERE buy_seq = vseq;
	
	SELECT money INTO o_money												-- 위 UPDATE money 컬럼값 조회하여 출력값으로 저장
		FROM p_buy# WHERE buy_seq = vseq;
	COMMIT;
EXCEPTION 
	WHEN OTHERS THEN 
		ROLLBACK;
	o_money :='fail';
END;

-------------------------------------------------------------------------------------------
/*
 CREATE OR REPLACE PROCEDURE pbuy#_set_money(
	a_custom_id IN varchar2,		
	a_pcode IN varchar2,
	a_cnt IN NUMBER ,
	o_money OUT varchar2
)
 */


-- 실행 1
DECLARE 
	vresult varchar2(20);
BEGIN 
	dbms_output.put_line('pbuy#_set_money 프로시저 실행 1 ------------------------------');
	pbuy#_set_money('mina012','CJBAb12g',3,vresult);
	dbms_output.put_line('결과 : ' || vresult);
END;

-- 실행 2
DECLARE 
	vresult varchar2(20);
BEGIN 
	dbms_output.put_line('pbuy#_set_money 프로시저 실행 2 ------------------------------');
	pbuy#_set_money('hongGD','3MCRY',2,vresult);
	dbms_output.put_line('결과 : ' || vresult);
END;

-- 실행 3
DECLARE 
	vresult varchar2(20);
BEGIN 
	dbms_output.put_line('pbuy#_set_money 프로시저 실행 3 ------------------------------');
	pbuy#_set_money('hongGD','3M_CRY',10,vresult);
	dbms_output.put_line('결과 : ' || vresult);
END;







