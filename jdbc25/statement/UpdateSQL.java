package jdbc25.statement;

import jdbc25.service.IConnectImpl;

public class UpdateSQL extends IConnectImpl {

	//인자 생성자]
	public UpdateSQL(String url, String user, String password) {
		super(url,user,password);
	}	
	@Override
	public void execute() throws Exception {
		//1]쿼리 전송용 Statement객체 생성
		stmt=conn.createStatement();
		//1-1]쿼리문 작성
		String sql="UPDATE member SET name='수정명',pwd='8989' WHERE id='LEE'";
		//2]쿼리 실행
		System.out.println(stmt.executeUpdate(sql)+"행이 수정되었어요");
		//3]자원 반납
		close();
	}/////////////////execute
	public static void main(String[] args) throws Exception {
		new UpdateSQL(ORACLE_URL, "JDBC", "JDBC").execute();
	}//////////////main

}/////////////////class
