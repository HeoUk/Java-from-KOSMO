package io24.filter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectInputFileToMemory {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		//1]필터를 끼운 입력 스트림 생성
		ObjectInputStream ois =
				new ObjectInputStream(
						new FileInputStream("src/io24/filter/Object.txt"));
		//2]ois로 읽어서 Person타입에 저장
		Object obj=ois.readObject();
		if(obj instanceof Person) {
			Person person1 = (Person)obj;
			System.out.println(person1);
		}
		Person pe2 =(Person)ois.readObject();
		System.out.println(pe2);
		Person pe3 =(Person)ois.readObject();
		System.out.println(pe3);		
		//ois.readObject();//java.io.EOFException		
		ois.close();
	}//////////////////main

}/////////////////class
