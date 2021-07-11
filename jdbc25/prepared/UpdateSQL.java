package jdbc25.prepared;

import java.sql.SQLException;

import jdbc25.service.IConnectImpl;

public class UpdateSQL extends IConnectImpl {

	@Override
	public void execute() throws Exception {
		//0]데이타베이스 연결
		connect(ORACLE_URL, "JDBC", "JDBC");
		//1]PreparedStatement객체 생성
		psmt = conn.prepareStatement("UPDATE member SET pwd=?,name=? WHERE id=?");
		//2]인파라미터 설정
		psmt.setString(3, getValue("수정하려고 하는 아이디"));
		psmt.setString(1, getValue("비번"));
		psmt.setString(2, getValue("이름"));
		try {
			//3]쿼리 실행
			System.out.println(psmt.executeUpdate()+"행이 수정되었어요");
		}
		catch(SQLException e) {
			System.out.println("수정시 오류:"+e.getMessage());
		}
		finally {
			//4]자원반납
			close();
		}
	}/////////execute
	public static void main(String[] args) throws Exception {		
		new UpdateSQL().execute();
	}//////////////main
}////////////////class
