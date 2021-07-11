package jdbc25.service;

public interface IConnect {
	//[멤버 상수]
	String ORACLE_DRIVER="oracle.jdbc.OracleDriver";
	String ORACLE_URL="jdbc:oracle:thin:@127.0.0.1:1521:xe";
	//[추상 메소드]
	void connect(String url,String user,String password);
	void execute() throws Exception;
	void close();
	String getValue(String message);
	String getQueryString();
	
}
