package exception21;

public class Club {
	void entrance(String clothes,int age) throws NotGoodAppearanceException{
		if("남루".equals(clothes)) {
			throw new NotGoodAppearanceException();
		}
		else if("정장".equals(clothes) && age < 20) {
			throw new NotGoodAppearanceException("나이가 너무 어려요");
		}
		else if("정장".equals(clothes) && age > 40) {
			throw new NotGoodAppearanceException("나이가 너무 많아요");
		}
		System.out.println("입장하세요...즐...");
	}
}
