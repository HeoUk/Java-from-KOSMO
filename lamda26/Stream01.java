package lamda26;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Vector;
import java.util.stream.Stream;

public class Stream01 {

	public static void main(String[] args) {
		System.out.println("[데이타 소스 : 배열]");
		String[] mountains = {"한라산","지리산","덕유산","치악산","비슬산"};
		Stream<String> stream1=Arrays.stream(mountains);
		stream1.forEach(x->System.out.println(x));//최종 연산후 스트림은 닫힌다
		/*
		System.out.println("[Arrays.sort()로 배열 정렬:원본 배열이 변경된다]");
		Arrays.sort(mountains);
		//stream1.forEach(x->System.out.println(x));//[x]
		for(String mountain:mountains) System.out.println(mountain);*/
		System.out.println("[스트림객체의 sorted()로 배열 정렬: 원본배열이 유지된다]");
		stream1=Arrays.stream(mountains);//스트림 객체 다시 생성
		stream1.sorted().forEach(x->System.out.println(x));//오름 차순
		System.out.println("[원본 배열 출력]");
		for(String mountain:mountains) System.out.println(mountain);
		//stream1.sorted();//[x]스트림이 닫혀서 오류.즉 최종연산중 하나인 forEach()실행후에는 Stream이 닫힌다
		System.out.println("[내림차순]");
		stream1=Arrays.stream(mountains);//스트림 객체 다시 생성
		stream1.sorted((x,y)->y.compareTo(x)).forEach(x->System.out.println(x));//내림차순
		System.out.println("[데이타 소스 : 컬렉션]");
		/*
		List<String> list = new Vector<String>();		
		list.add("치악산");
		list.add("지리산");
		list.add("덕유산");
		list.add("설악산");*/
		List<String> list = Arrays.asList("치악산","지리산","덕유산","설악산");
		System.out.println("[확장 FOR문 사용해서 출력]");
		for(String mountain:list) System.out.println(mountain);
		Stream<String> stream2=list.stream();
		System.out.println("[스트림객체의 메소드 사용해서 출력]");
		stream2.forEach(x->System.out.println(x));
		/*
		System.out.println("[정렬:Collections.sort()사용-원본 컬렉션이 변경됨]");
		Collections.sort(list);
		for(String mountain:list) System.out.println(mountain);*/
		System.out.println("[정렬:스트림객체의 sorted()사용-원본 컬렉션 불변]");
		stream2=list.stream();
		//stream2.sorted().forEach(x->System.out.println(x));//오름 차순
		stream2.sorted((x,y)->y.compareTo(x)).forEach(x->System.out.println(x));//내림차순
		System.out.println("[원본 컬렉션 출력]");
		for(String mountain:list) System.out.println(mountain);
		
	}/////////////main

}//////////class
