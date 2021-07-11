package io24.filter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/*
문]파일(BufferInOutFileToFile.java)로 부터 입력받아서
파일(BufferInOutFileToFile.txt)로 출력하자.
(단,노드 스트림은 바이트 기반을 사용)		
그리고 문자 기반의 필터 스트림(BufferedReader/PrintWriter)을 통해
필터링하자.
*/
public class BufferRWFileToFile {

	public static void main(String[] args) throws IOException {
		//1]입력 스트림 생성
		BufferedReader br =
				new BufferedReader(
						new InputStreamReader(
								new FileInputStream("src/io24/filter/BufferInOutFileToFile.java")));
		
		//2]출력 스트림 생성
		PrintWriter pw = new PrintWriter(
				new FileOutputStream("src/io24/filter/BufferInOutFileToFile.txt"),true);
		//3]br로 읽어서  pw로 출력
		String data;
		while((data=br.readLine()) != null) pw.println(data);
		//4]스트림닫기
		br.close();
		pw.close();
	}///////////main

}////////////////class
