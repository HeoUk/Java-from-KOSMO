package jdbc25.prepared;

import java.sql.SQLException;

import jdbc25.service.IConnectImpl;

public class DeleteSQLMore extends IConnectImpl {

	@Override
	public void execute() throws Exception {
		//0]데이타베이스 연결
		connect(ORACLE_URL, "JDBC", "JDBC");
		//1]PreparedStatement객체 생성
		psmt = conn.prepareStatement("DELETE member WHERE id=?");
		while(true) {
			//2]인파라미터 설정
			psmt.setString(1, getValue("삭제할 아이디"));		
			try {
				//3]쿼리 실행
				System.out.println(psmt.executeUpdate()+"행이 삭제되었어요");
			}
			catch(SQLException e) {
				System.out.println("삭제시 오류:"+e.getMessage());
			}
		}///while
		
	}/////////execute
	public static void main(String[] args) throws Exception {		
		new DeleteSQLMore().execute();
	}//////////////main
}////////////////class
