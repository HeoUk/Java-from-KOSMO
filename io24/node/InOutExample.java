package io24.node;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class InOutExample {

	public static void main(String[] args) throws IOException {
		//문]STDNodeInOut.java 파일의 내용을 읽어서
		//  모니터와 파일로 출력하여라.
		//  파일로 출력시 파일명은 STDNodeInOut.txt로 하자
		FileInputStream fis = new FileInputStream("src/io24/node/STDNodeInOut.java");
		FileOutputStream fos = new FileOutputStream("src/io24/node/STDNodeInOut.txt");
		int data;
		while((data=fis.read())!=-1) {
			fos.write(data);
			fos.flush();
			System.out.write(data);
		}
		fis.close();
		fos.close();
	}////////////main

}//////////////class
