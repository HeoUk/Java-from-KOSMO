package jdbc25.statement;

import jdbc25.service.IConnectImpl;

public class SelectSQL extends IConnectImpl {
	@Override
	public void execute() throws Exception {
		//1]데이타베이스 연결
		connect(ORACLE_URL, "scott", "scott");
		try {
			//2]Statement 객체 생성
			stmt = conn.createStatement();
			//3]쿼리문 작성
			//3-1]여러개 레코드(행:row)를 반환하는 SELECT문
			//String sql="SELECT * FROM emp ORDER BY hiredate DESC";
			//3-2]한 개의 레코드를 반환하거나 0개의 레코드를
			//    반환하는 경우 - 주로 PK로 검색하는 경우
			//String sql="SELECT * FROM emp WHERE empno="+getValue("사원번호");
			//3-3]무조건 레코드 하나 반환하는 경우-그룹함수 사용시
			//String sql="SELECT AVG(sal) FROM emp";
			//3-4]LIKE 연산자를 포함한  SELECT문
			/*
			 * 자바코드에서 like연산자 사용법
			 * ※[PreparedStatement객체 사용시]
			 * -오라클
			 *  
			 *  LIKE '%A%' :A로 시작하거나 A로끝나거나 A가 중간에 포함되거나
			 *  LIKE '%A' :A로 끝나는 경우
			 *  LIKE 'A%' :A로 시작
			 *  
			 * -자바
			 *  LIKE  '%' || 'A' || '%'
			 *  LIKE '%' || 'A'
			 *  LIKE 'A' || '%'
			 * 
			 */
			//String sql="SELECT * FROM emp WHERE ename LIKE '%S%'";
			//String sql="SELECT * FROM emp WHERE ename LIKE '%' || 'S' || '%'";
			//값을 받자
			//String sql="SELECT * FROM emp WHERE ename LIKE '%"+getValue("찾는 문자열")+"%'";
			String sql="SELECT * FROM emp WHERE ename LIKE '%' || '"+getValue("찾는 문자열")+"' || '%'";
			//4]쿼리 실행
			rs=stmt.executeQuery(sql);
			/*
			SELECT문 실행시 실행결과는 ResultSet타입의 객체에
			저장됨. 최초 커서는 첫번째 레코드 바로 위에 가 있다.
			ResultSet객체의 next()메소드로 커서를 아래로 이동시키면서
			더이상 꺼내올 레코드가 없을때까지 반복하면서 추출			
			
			ResultSet객체의 getXXX()계열 메소드로
			해당 레코드의 각 컬럼에 저장된 값을 읽어 온다.
			예를들면
			
		  	----------------------+------------------------------
		     ORACLE자료형          |       ResultSet
		     ---------------------+----------------------------
		     NUMBER               |     getInt(인덱스 혹은 컬럼명)
		     ---------------------+-------------------------------
		     CHAR/NCHAR           |
		     VARCHAR2/NVARCHAR2   |     getString(인덱스 혹은 컬러명)
		     ---------------------+---------------------------------
		     DATE                 |     getDate(인덱스 혹은 컬러명)
		     ---------------------+---------------------------------
		 	 인덱스는 SQL에서는 1부터 시작
		            ※단,ORACLE의 자료형에 상관없이 getString(인덱스 혹은 컬러명)
		            으로 읽어와도 무방하다.			     
			 */
			/*
			
			 * 오라클에 저장된 데이타가 없는 경우 즉 null 인 경우			 * 
			 * rs.getInt(인덱스번호 혹은 컬럼명) 는 0 반환
			 * rs.getString(인덱스번호 혹은 컬럼명)는 null 반환
			 */
			//3-1]여러개 레코드를 반환하는 경우	
		
			while(rs.next()) {//더 이상 꺼내올 레코드가 없을때까지 반복
				int empno = rs.getInt(1);
				String ename = rs.getString("ENAME");
				String job = rs.getString("JOB");
				//int comm = rs.getInt("comm");//값이 없는 경우 0반환
				String comm=rs.getString("comm")==null? "" : rs.getString("comm");
				//오라클의 Date타입을 getDate()로 가져오는 경우]
				//-년월일만 반환
				//java.sql.Date hiredate = rs.getDate(5);
				//오라클의 Date타입을 getString()로 가져오는 경우]
				//-시분초까지 반환.	
				String hiredate =rs.getString(5).substring(0,10);
				
				System.out.println(
						String.format("%-5d%-10s%-10s%-15s%s",
								empno,ename,job,comm,hiredate));
			}/////////////////while
			//3-2]한 개의 레코드를 반환하거나 0개의 레코드를
			//    반환하는 경우
			/*
			if(rs.next()) {
				System.out.println(
						String.format("%-5s%-10s%-10s%-15s%s",
						rs.getString(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(7)==null?"":rs.getString(7),
						rs.getDate(5)));
			}////if*/
			//3-3]무조건 레코드 하나 반환하는 경우
			//rs.next();
			//System.out.println("평균 연봉:"+rs.getFloat(1));
			
		}
		catch(Exception e) {
			System.out.println("오류발생:"+e.getMessage());
		}
		finally {
			//4]자원반납
			close();
		}		
	}////////////////execute
	public static void main(String[] args) throws Exception {
		new SelectSQL().execute();
	}//////////////main
}/////////////////class
