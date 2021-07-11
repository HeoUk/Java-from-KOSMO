package console.academy;

public class AcademyApp {

	public static void main(String[] args) {
		//배열 사용]
		//AcademyLogic logic = new AcademyLogic();
		//컬렉션 사용]
		//AcademyCollectionLogic logic = new AcademyCollectionLogic();
		//컬렉션 사용-파일저장 추가(BufferedReader/PrintWriter사용]
		//AcademyCollectionFileRWLogic logic = new AcademyCollectionFileRWLogic();
		//컬렉션 사용-파일저장 추가(ObjectOutputStream/ObjectInputStream사용]
		AcademyCollectionObjectLogic logic = new AcademyCollectionObjectLogic();
		
		while(true) {
			//1.메인 메뉴 출력
			logic.printMainMenu();
			//2.메인메뉴 번호 입력받기
			int mainMenu = logic.getMenuNumber();
			//3. 메인메뉴에 따른 분기
			logic.seperateMainMenu(mainMenu);
			
		}
	}///////////////main

}////////////AcademyApp
