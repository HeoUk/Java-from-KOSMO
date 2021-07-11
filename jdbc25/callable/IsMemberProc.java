package jdbc25.callable;

import java.sql.Types;

import jdbc25.service.IConnectImpl;
/*
create or replace PROCEDURE SP_ISMEMBER( 
    ID_ MEMBER.ID%TYPE,
    PWD_ MEMBER.PWD%TYPE,
    RTVAL OUT NUMBER
)
IS
    FLAG NUMBER(1);
BEGIN

    SELECT COUNT(*) INTO FLAG FROM member WHERE ID= ID_;
    IF FLAG = 0 THEN
        RTVAL := -1;
    ELSE--아이디 일치
        SELECT COUNT(*) INTO FLAG FROM member WHERE ID= ID_ AND PWD= PWD_;
        IF FLAG = 0 THEN--비번 불일치
             RTVAL := 0;
        ELSE
             RTVAL := 1;
        END IF;
    END IF;
END;

 * 
 * 
 */
public class IsMemberProc extends IConnectImpl {
	
	public IsMemberProc(String url, String user, String password) {
		super(url, user, password);		
	}///////////
	@Override
	public void execute() throws Exception {
		//1]프로시저를 실행하기 위한 CallableStatement객체 얻기
		csmt = conn.prepareCall("{call SP_ISMEMBER(?,?,?)}");
		//2]파라미터 설정
		csmt.setString(1, getValue("아이디"));
		csmt.setString(2, getValue("비번"));
		csmt.registerOutParameter(3, Types.NUMERIC);
		//3]프로시저 실행-execute()
		csmt.execute();
		//4]out파라미터에 저장된 값 읽어 오기
		int codeValue = csmt.getInt(3);
		if(codeValue==-1) System.out.println("아이디가 일치하지 않아요");
		else if(codeValue==0) System.out.println("아이디는 일치하나 비번이 틀려요");
		else System.out.println("회원님 즐쇼핑하세요...");
	}//////execute
	public static void main(String[] args) throws Exception {
		new IsMemberProc(ORACLE_URL, "JDBC", "JDBC").execute();;
	}//////////////main

}/////////////////class
