package method05;

public class CallByRefExample {
	
	public static void main(String[] args) {
		double [][] scores = {
				{100,100,100,0,0},
				{90,90,90,0,0},
				{95,95,95,0,0}};
		//총점 및 평균을 설정하는 메소드 호출
		setTotalNAverage(scores);
		//출력]
		print(scores);
	}////////////main
	static void print(double[][] scores) {
		String[] title = {"국어","영어","수학","총점","평균"};
		for(int i=0;i < scores.length;i++) {
			System.out.printf("[%d번째 학생 성적]",i+1);
			for(int k=0;k < scores[i].length;k++) {
				System.out.printf("%s:%.0f ",title[k],scores[i][k]);
			}
			//줄바꿈
			System.out.println();
		}
		
	}//////////////print
	static void setTotalNAverage(double [][] scores) {
		for(int i=0;i < scores.length;i++) {
			//총점 구하기]
			for(int k=0;k < 3;k++) {
				scores[i][3]+=scores[i][k];
			}
			//평균 구하기
			scores[i][4]=scores[i][3]/3.0;
		}		
	}/////////////////////////

}///////////////class
