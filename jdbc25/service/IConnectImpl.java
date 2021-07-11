package jdbc25.service;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class IConnectImpl implements IConnect {
	//[멤버변수]
	public Connection conn;
	public ResultSet rs;
	public Statement stmt;
	public PreparedStatement psmt;
	public CallableStatement csmt;
	
	private Scanner sc = new Scanner(System.in);
	
	
	//[static블락]
	static {		
		try {
			//드라이버 로딩]
			Class.forName(ORACLE_DRIVER);
		} 
		catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:"+e.getMessage());
		}
	}////////////////	
	//[기본 생성자]
	public IConnectImpl() {}
	//[인자 생성자]
	public IConnectImpl(String url, String user, String password) {
		//데이타 베이스 연결]
		connect(url,user,password);
	}////////////////
	//데이타베이스 연결하는 메소드]	
	@Override
	public void connect(String url, String user, String password) {
		try {
			conn=DriverManager.getConnection(url, user, password);
		} 
		catch (SQLException e) {
			System.out.println("데이타베이스 연결실패:"+e.getMessage());
		}		
	}//////////////connect	
	//쿼리 실행 메소드]
	@Override
	public void execute() throws Exception {}
	@Override
	public void close() {
		try {
			if(rs !=null) rs.close();
			if(stmt !=null) stmt.close();
			if(psmt !=null) psmt.close();
			if(csmt !=null) csmt.close();
			if(conn !=null) conn.close();
		}
		catch(SQLException e) {}
		
	}//////////////
	@Override
	public String getValue(String message) {
		System.out.println(message+"를(을) 입력하세요?");
		String value = sc.nextLine();
		if("EXIT".equalsIgnoreCase(value)) {
			close();//데이타베이스 연결끊기(자원반납)]
			System.out.println("프로그램 종료!!!");
			System.exit(0);
		}
		return value;
	}//////////////////getValue
	@Override
	public String getQueryString() {
		System.out.print("SQL>");
		return sc.nextLine();
	}//////////////////

}//////////////////
