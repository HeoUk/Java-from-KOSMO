package jdbc25.etc;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import java.util.Vector;

import jdbc25.service.IConnectImpl;

public class ExecuteSQL extends IConnectImpl {
	
	public ExecuteSQL(String url, String user, String password) {
		super(url, user, password);		
	}///////////////
	@Override
	public void execute() throws Exception {
		while(true) {
			//1]쿼리문 준비
			String query = getQueryString();
			if("EXIT".equalsIgnoreCase(query.trim())) {
				System.out.println("Disconnected from Oracle Database 11g Express Edition Release 11.2.0.2.0 - 64bit Production");
				//자원반납]
				close();
				//프로그램 종료]
				System.exit(0);
			}////////
			
			//2]Statement계열 객체 생성-쿼리 실행용
			psmt = conn.prepareStatement(query);
			//3]쿼리 실행-boolean execute():쿼리문이 미정 임으로
			/*
			execute()는 쿼리문이 SELECT이면 true,그외 SQL문일때는 false반환.
			
			execute()메소드로 쿼리 실행후 쿼리문이 SELECT인 경우
			ResultSet에 담긴 결과를 가져오려면 Statement계열 객체의
			getResultSet()메소드 호출
			
			쿼리문이 INSERT/DELETE/UPDATE일때
			영향받은 행의 수를 반환 받을때는 
			getUpdateCount()메소드 호출
			*/
			try {
				boolean flag = psmt.execute();
				if(flag) {//쿼리문이 SELECT
					rs=psmt.getResultSet();
					ResultSetMetaData rsmd =rs.getMetaData();
					int columnCount = rsmd.getColumnCount();
					List<Integer> dashCount = new Vector<Integer>();
					for(int i=1;i <= columnCount ;i++) {
						//컬럼타입]
						int types=rsmd.getColumnType(i);
						//컬럼의 자리수]
						int length = rsmd.getPrecision(i);
						switch(types) {
							case Types.NCHAR:
							case Types.NVARCHAR:
								dashCount.add(length*2);break;
							case Types.TIMESTAMP:
							case Types.NUMERIC:
								dashCount.add(10);break;
							default:dashCount.add(length);	
						}//switch	
						//컬럼명 출력]						
						String coulumName = rsmd.getColumnName(i).length() >  dashCount.get(i-1) ?
								            rsmd.getColumnName(i).substring(0,dashCount.get(i-1)) :
								            rsmd.getColumnName(i);
						System.out.print(String.format("%-"+(dashCount.get(i-1)+1)+"s", coulumName));
					}//////////////for
					System.out.println();//줄바꿈
					//(-)DASH출력]
					for(Integer count:dashCount) {
						for(int i=0; i < count;i++) System.out.print("-");
						System.out.print(" ");
					}///////
					System.out.println();//줄바꿈
					//데이터 출력]
					while(rs.next()) {
						//각 컬럼값 뽑아오기]
						for(int i=1;i<=columnCount;i++) {
							int type = rsmd.getColumnType(i);	
							
							String columnValue;
							if(type==Types.TIMESTAMP)
								columnValue = rs.getDate(i).toString();						
							else
								columnValue = rs.getString(i);					
							System.out.print(
									String.format(
											"%-"+(dashCount.get(i-1)+1)+"s",
											columnValue==null?"":columnValue));
						}
						System.out.println();//줄바꿈
					}///////////////while
					
				}
				else {//기타 쿼리문
					//영향받은 행의 수 얻기]
					int affected=psmt.getUpdateCount();
					if(query.trim().toUpperCase().startsWith("UPDATE"))
						System.out.println(affected+"행이 수정되었어요");
					else if(query.trim().toUpperCase().startsWith("DELETE"))
						System.out.println(affected+"행이 삭제되었어요");
					else if(query.trim().toUpperCase().startsWith("INSERT"))
						System.out.println(affected+"행이 입력되었어요");
				}///else
				
			}///try
			catch(SQLException e) {
				System.out.println(e.getMessage());
			}////////////catch		
		}//while
	}///////////execute
	public static void main(String[] args) throws Exception {
		new ExecuteSQL(ORACLE_URL,"JDBC", "JDBC").execute();
	}/////////main

}///////////class
