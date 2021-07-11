package io24.node;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;

/*
파일로부터 한 문자씩 읽어서 모니터에 출력
데이타 소스:파일
            노드 스트림:FileReader(문자 기반)
     
데이타 목적지:모니터
			 노드 스트림:System.out (바이트 기반) 
			 브릿지 스트림:OutputStreamWriter
 
*/
public class FileReaderToMonitor {

	public static void main(String[] args) throws IOException {
		//1]입력 스트림 생성
		FileReader fr = new FileReader("src/io24/node/KeyboardWriter.txt");
		//2]출력 스트림 생성
		//PrintStream out = System.out;
		int data;
		//fr로 읽고 out으로 출력-한글깨짐
		/*
		while((data=fr.read())!=-1) {//파일의 끝에 도달하면 -1
			out.write(data);
			out.flush();
		}*/
		//3]브릿지 스트림으로 1바이트 씩 출력 스트림으로 내보내는
		//  데이타를 문자단위로 변환
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		//4]fr로 읽고 osw로 출력
		while((data=fr.read())!=-1) {//파일의 끝에 도달하면 -1
			osw.write(data);
			osw.flush();
		}
		//5]스트림 닫기
		fr.close();

	}/////////////main

}//////////////class
