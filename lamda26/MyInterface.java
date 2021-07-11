package lamda26;

//※함수형 인터페이스는 추상 메소드를 하나만 갖는다
//인터페이스에 @FunctionalInterface 어노테이션을 붙이면
//그 인터페이스는 함수형 인터페이스가 되서 무조건 추상메소드 하나만 가져여한다
@FunctionalInterface
public interface MyInterface {
	int calc(int a,int b);	
}////////////MyInterface
