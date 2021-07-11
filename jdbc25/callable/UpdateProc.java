package jdbc25.callable;

import java.sql.Types;

import jdbc25.service.IConnectImpl;

/*
create or replace PROCEDURE SP_UP_MEMBER(
    ID_ IN MEMBER.ID%TYPE,
    PWD_ MEMBER.PWD%TYPE,
    NAME_ MEMBER.NAME%TYPE,
    RTVAL OUT CHAR

)
IS
BEGIN

    UPDATE member SET pwd = PWD_ , name=NAME_
    WHERE id=ID_;

     IF SQL%FOUND THEN
        RTVAL := 'SUCCESS';
        COMMIT;
    ELSE
        RTVAL :='FAIL : NOT FOUND ID:' || ID_;
    END IF;    

    EXCEPTION
        WHEN OTHERS THEN
            ROLLBACK;
            RTVAL :='FAIL : TOO MUCH VALUE';

END;

 */
public class UpdateProc extends IConnectImpl {
	
	public UpdateProc() {
		super(ORACLE_URL,"JDBC","JDBC");		
	}
	@Override
	public void execute() throws Exception {
		//1]프로시저를 실행하기 위한 CallableStatement객체 얻기
		csmt = conn.prepareCall("{call SP_UP_MEMBER(?,?,?,?)}");
		//2]파라미터 설정
		csmt.setString(1, getValue("수정하려고 하는 아이디"));
		csmt.setString(2, getValue("비밀번호"));
		csmt.setString(3, getValue("이름"));
		csmt.registerOutParameter(4,Types.CHAR);
		//3]프로시저 실행-execute()
		csmt.execute();
		//4]out파라미터에 저장된 값 읽어 오기
		System.out.println(csmt.getString(4).trim());
		//5]자원반납
		close();
	}/////////execute
	public static void main(String[] args) throws Exception {
		new UpdateProc().execute();
	}/////////main

}/////////////class
