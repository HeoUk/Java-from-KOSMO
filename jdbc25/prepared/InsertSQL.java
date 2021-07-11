package jdbc25.prepared;

import java.sql.Date;
import java.sql.SQLException;

import jdbc25.service.IConnectImpl;

public class InsertSQL extends IConnectImpl {

	
	
	public InsertSQL(String url, String user, String password) {
		super(url, user, password);		
	}////////////
	@Override
	public void execute() throws Exception {
		//1]쿼리문 미리 준비
		//1-1]인파라미터(?)가 없는 쿼리문
		//String sql ="INSERT INTO member VALUES('KIM1','1234','김길동1',SYSDATE)";
		//1-2]인파라미터(?)가 있는 쿼리문
		String sql ="INSERT INTO member VALUES(?,?,?,?)";
		
		//2]쿼리실행을 위한 Statement계열 객체 생성
		/*
	    PreparedStatement객체는 객체 생성시 미리 쿼리문을 준비해서
	    Connection객체의 prepareStatement(쿼리문)메소드의 인자로 
	        전달해야 한다. 
	     
     	- PreparedStatement객체 생성시 전달된 쿼리문을 먼저
       	  parsing하기때문에 실행시에는 바로 실행한다.
                   그럼으로 실행시에는 쿼리문을 전달할 필요가 없다.
		 */
		psmt = conn.prepareStatement(sql);
		//3]쿼리 실행-실행시 쿼리문 전달 불필요
		//3-1]인파라미터가 없는 쿼리문
		//    -인파라미터 설정 불필요.바로 실행하면 됨.
		//3-2]인파라미터가 있는 쿼리문-실행전 반드시 값을 설정
		//?(인파라미터)
		/*
		쿼리 실행전에 값에 해당하는 부분을 ?처리한 경우
		값을 설정해줘야 함.
		
		?(인파라미터)는 쿼리문의 값에 해당하는 부분에만
		넣어줘야 한다.
		
		-인 파라미터를 설정할때는 PreparedStatement객체의
		setXXXX(파라미터인덱스,설정할 값)메소드로 설정한다
		예]			
		Oracle의 자료형이 NUMBER 라면 setInt(),
		                  char/varchar2 ->setString()
		
		
		자료형에 상관없이 setString()설정가능
		즉 ResultSet객체로 값을 읽어오는 getXXXX()메소드와 사용법이
		동일하다.			
		 */
		//3-2]인파라미터 설정
		psmt.setString(1, getValue("아이디"));
		psmt.setString(2, getValue("비번"));
		psmt.setString(3, getValue("이름"));
		//날짜를 문자열로 설정시]
		//psmt.setString(4, getValue("가입일"));
		//날짜를 java.sql.Date타입으로 설정시]
		Date date = new Date(new java.util.Date().getTime());
		psmt.setDate(4, date);
		
		try {
			System.out.println(psmt.executeUpdate()+"행이 입력되었습니다");
		}
		catch(SQLException e) {
			System.out.println("입력시 오류:"+e.getMessage());
		}
		finally {
			//4]자원 반납
			close();
		}
	}/////////////execute
	public static void main(String[] args) {
		try {
			new InsertSQL(ORACLE_URL,"JDBC", "JDBC").execute();
		} 
		catch(Exception e) {
			System.out.println("오류:"+e.getMessage());
		}
	}/////////main

}////////////class
