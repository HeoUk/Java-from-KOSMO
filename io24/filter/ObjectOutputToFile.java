package io24.filter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectOutputToFile {

	public static void main(String[] args) throws IOException {
		//1]데이타 소스(메모리) 준비-입력 스트림 불필요
		Person pe1 = new Person("가길동", 20, "천호동");
		Person pe2 = new Person("나길동", 30, "잠실동");
		Person pe3 = new Person("다길동", 40, "석촌동");
		//2]필터를 끼운 출력 스트림 생성]
		ObjectOutputStream oos = 
				new ObjectOutputStream(
						new FileOutputStream("src/io24/filter/Object.txt"));
		//3]인스턴화된 객체를 oos로 출력
		oos.writeObject(pe1);
		oos.writeObject(pe2);
		oos.writeObject(pe3);
		//4]스트림 닫기
		oos.close();
	}/////////////main

}///////////class
