package jdbc25.prepared;

import java.sql.SQLException;

import jdbc25.service.IConnectImpl;

public class SelectSQL extends IConnectImpl {

	public SelectSQL() {
		super(ORACLE_URL,"scott","scott");//혹은 connect(ORACLE_URL,"scott","scott");
	}
	@Override
	public void execute() throws Exception {
		//1]미리 쿼리문 준비
		//1-1]특정 문자로 시작하는 레코드 검색
		/*
		String sql="SELECT ename,TRIM(TO_CHAR(sal,'L99,999')) sal,job,"
				+ "TO_CHAR(hiredate,'YYYY.MM.DD') FROM emp WHERE ename "
				+ "LIKE ? || '%'  ORDER BY hiredate DESC ";*/
		//1-2]특정 문자로 끝나는 레코드 검색	
		/*
		String sql="SELECT ename,TRIM(TO_CHAR(sal,'L99,999')) sal,job,"
				+ "TO_CHAR(hiredate,'YYYY.MM.DD') FROM emp WHERE ename "
				+ "LIKE '%' || ?  ORDER BY hiredate DESC ";*/
		//1-3]특정 문자가 포함된 레코드 검색
		String sql="SELECT ename,TRIM(TO_CHAR(sal,'L99,999')) sal,job,"
				+ "TO_CHAR(hiredate,'YYYY.MM.DD') FROM emp WHERE ename "
				+ "LIKE '%' || ? || '%'  ORDER BY hiredate DESC ";
		//2]PreparedStatement객체 생성
		psmt = conn.prepareStatement(sql);
		
		//3]인파라미터 설정-인파라미터 있는 경우
		psmt.setString(1, getValue("찾는 문자열"));
		try {
			//4]쿼리실행
			rs = psmt.executeQuery();
			rs.last();
			while(rs.next()) {
				System.out.println(String.format("%-8s%-8s%-10s%s", 
						rs.getString(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4)
						));
			}
		}
		catch(SQLException e) {
			System.out.println("조회 쿼리 실행 오류:"+e.getMessage());
		}
		finally {
			//5]자원반납
			close();
		}
	}//////////execute
	public static void main(String[] args) throws Exception {
		new SelectSQL().execute();
	}///main

}//////////////class
