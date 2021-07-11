package jdbc25.statement;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertSQLMore {
	//[멤버변수]
	private Connection conn;
	private Statement stmt;
	private static Scanner sc = new Scanner(System.in);
	//[생성자]
	public InsertSQLMore() {
		
		try {
			//1]JDBC용 오라클 드라이버를 메모리에 로딩
			Class.forName("oracle.jdbc.OracleDriver");
			//2]오라클에 연결시도:DriverManager의 getConnection()메소드로
			conn=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","JDBC","JDBC");
		}		
		catch (ClassNotFoundException e) {
			System.out.println("드라이버 클래스가 없어요. 드라이버 로딩 실패");
		}
		catch(SQLException e) {
			System.out.println("데이터 베이스 연결 실패");
		}
	}////////////////
	private void execute() {
		try {
			//3]쿼리 실행하기 위한  Statement객체 생성
			//  연결된 Connection객체로....
			stmt=conn.createStatement();
			while(true) {
				try {
					//3-1]쿼리문 작성
					String sql="INSERT INTO member(id,pwd,name) VALUES('"+getValue("아이디").toString()+"','"+getValue("비밀번호").toString()+"','"+getValue("이름").toString()+"')";
					//4]Statement계열 객체로 쿼리 실행
					/*
					 * 쿼리문이 DELETE/UPDATE/INSERT일때는 int executeUpdate()
					 * 쿼리문이 SELECT일때는 ResultSet executeQuery()호출
					 */	
				
					int affected=stmt.executeUpdate(sql);
					System.out.println(affected+"행이 입력되었어요");
				}
				catch(SQLException e) {
					System.out.println("INSERT 쿼리문 실행 오류:"+e.getMessage());
				}
				catch (NullPointerException e) {
					System.out.println("Disconnected from Oracle Database 11g Express Edition Release 11.2.0.2.0 - 64bit Production");
					break;
				}
			}///while
			
		}
		catch(SQLException e) {
			System.out.println("Statement객체 생성 실패");
		}
		finally {
			//5]자원반납
			close();
		}
	}//////////////////////	
	
	private void close() {
		try {
			if(stmt !=null) stmt.close();
			if(conn !=null) conn.close();
		}
		catch(SQLException e) {}
	}////////////////
	//[시용자 입력용 메소드]
	public static Object getValue(String message) {
		System.out.println(message+"를(을) 입력하세요?");
		String value = sc.nextLine();
		if("EXIT".equalsIgnoreCase(value)) {
			return null;
		}
		return value;
	}//////////////////////getValue
	public static void main(String[] args) {
		new InsertSQLMore().execute();
	}///////////////main

	


	

}/////////////////class
