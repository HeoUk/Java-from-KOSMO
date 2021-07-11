package io24.file;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MajorMethodOfFile {
	//문]File클래스의 getName()과 같은 역할을 하는 
    //   나만의 메소드를 정의하자]
	private static String getName(String path) {
		int beginIndex=path.indexOf("/")!=-1 ? path.lastIndexOf("/")+1 : path.lastIndexOf("\\")+1 ;
		return path.substring(beginIndex);
	}
	public static void main(String[] args) {
		/*
		  \:디렉토리의 원도우식 표기법
		  /:디렉토리의 UNIX(LINUX)식 표기법
		*/
		String wExitFile="E:\\CCH\\Workspace\\Java\\JavaBasicApp\\src\\HelloWorld.java";
		String wNoExitFile="E:\\CCH\\NOEXIST.txt";
		String uRelativeDir="src/io24/node";
		String uAbsoluteDir="E:/CCH/NODIR";
		//1]File 객체 생성
		//1-1]파일에 대한 정보를 가진 File객체
		File fwExitFile = new File(wExitFile);
		File fwNoExitFile = new File(wNoExitFile);
		//1-2]디렉토리에 대한 정보를 가진 File객체
		File fuRelativeDir = new File(uRelativeDir);
		File fuAbsoluteDir = new File(uAbsoluteDir);
		//2]파일명 혹은 디렉토리명 얻기:String getName()
		System.out.println("fwExitFile의 파일명:"+fwExitFile.getName());
		System.out.println("fwNoExitFile의 파일명:"+fwNoExitFile.getName());
		System.out.println("fuRelativeDir의 디렉토리명:"+fuRelativeDir.getName());
		System.out.println("fuAbsoluteDir의 디렉토리명:"+fuAbsoluteDir.getName());
		System.out.println("[내가 만든 getName()메소드]");
		System.out.println("fwExitFile의 파일명:"+getName(wExitFile));
		System.out.println("fwNoExitFile의 파일명:"+getName(wNoExitFile));
		System.out.println("fuRelativeDir의 디렉토리명:"+getName(uRelativeDir));
		System.out.println("fuAbsoluteDir의 디렉토리명:"+getName(uAbsoluteDir));
		/*3] 파일 혹은 디렉토리 여부 판단:
	     boolean isFile() 혹은 boolean isDirectory()
	     isFile():파일이 아니거나 ,파일이 존재하지 않으면 
	              false반환.
		 isDirectory():디렉토리가 아니거나 ,
	                     디렉토리가 존재 하지 않으면 false반환.
		 */
		System.out.println(fwExitFile.isFile());
		System.out.println(fwNoExitFile.isFile());
		System.out.println(fuRelativeDir.isFile());
		System.out.println(fuRelativeDir.isDirectory());
		System.out.println(fuAbsoluteDir.isDirectory());
		//4]파일 혹은 디렉토리 존재 여부 판단:boolean exists()
		//※항상 존재 여부 판단후 파일인지 디렉토리인지 판단하자.
		if(fuRelativeDir.exists()) {
			if(fuRelativeDir.isFile()) System.out.println("파일이다");
			else System.out.println("디렉토리다");
		}
		System.out.println(fwExitFile.exists()? fwExitFile.isDirectory()?"디렉토리다":"파일이다":"존재하지 않는다");
		//5]파일 혹은 디렉토리의 상대경로(getPath()) / 
		//                   절대경로(getAbsolutePath()) 얻기 
		/*
		 * ※   자바 프로그램에서 상대경로로 표기하고 
		 *  절대 경로를 얻고자할때 주로 getAbsolutePath()사용
		 */
		System.out.println("fuRelativeDir의 상대경로:"+fuRelativeDir.getPath());
		System.out.println("fuRelativeDir의 절대경로:"+fuRelativeDir.getAbsolutePath());
		System.out.println("fuAbsoluteDir의 상대경로:"+fuAbsoluteDir.getPath());
		System.out.println("fuAbsoluteDir의 절대경로:"+fuAbsoluteDir.getAbsolutePath());
		//6]파일 혹은 디렉토리의 크기 얻기(단위:바이트) :long length()
		/*
		8bit     -> 1BYTE
		1024byte -> 1KB
		1024KB   -> 1MB
		1024MB   -> 1GB
		1024GB   -> 1TB		
		 */
		//디렉토리는 OS에 따라서 
		//0을 반환하거나 일부 크기를
		//반환 할 수도 있다. 파일은 존재하면 해당 크기를 반환
		//존재하지 않으면 0반환.
		/* length()메소드 사용시 크기가 0인경우
		 * -디렉토리(OS에 따라 다름)
		 * -파일형식이지만 파일이 존재 하지 않은경우
		 * -파일이 존재하지만 크기가 0인경우 
		 */
		//디렉토리 경우 XP는 무조건 0반환,WIN7는 크기 반환하지만 실제 크기는 아님
		System.out.println(fwExitFile.length()+"바이트");
		System.out.println(fwNoExitFile.length()+"바이트");
		System.out.println(fuRelativeDir.length()+"바이트");
		System.out.println(fuAbsoluteDir.length()+"바이트");
		//7]상위 부모경로 얻기:getParent()
		/*
		 * 주로 디렉토리에 적용하는데 파일객체를 생성시
		 * 상대경로든 절대경로든 여러 경로를 준 경우에 사용
     	 */	
		System.out.println(fwExitFile.getParent());
		System.out.println(fwNoExitFile.getParent());
		System.out.println(fuRelativeDir.getParent());
		System.out.println(fuAbsoluteDir.getParent());
		
		File fone = new File("file");
		System.out.println(fone.getParent());
		File ftwo= new File("parent","child");
		System.out.println(ftwo.getParent());
		ftwo = new File("parent/child");
		System.out.println(ftwo.getParent());
		//8]디렉토리 혹은 파일 삭제:
		//  boolean delete()-삭제 성공시 true,실패시 false
		System.out.println(fwNoExitFile.delete());
		File fexist = new File("E:/CCH/A.TXT");
		System.out.println(fexist.delete());
		//디렉토리는 안에 비어 있어야 삭제됨.
		System.out.println(fuRelativeDir.delete());
		System.out.println(new File("e:/cch/test").delete());
		//9]디렉토리 생성:boolean mkdir() /mkdirs();
	    //mkdir():부모 디렉토리 존재 하지 않으면 생성 실패
	    //mkdirs():부모 디렉토리까지 생성해줌.
		File fmkdir = new File("src/io24/node/temp");
		System.out.println(fmkdir.mkdir());
		File fmkdirs = new File("src/io24/node/nodir/temp");
		System.out.println(fmkdirs.mkdirs());
		//10]읽기/쓰기 가능 판단
		//윈도우계열 OS는 모든 파일이 디폴트로 실행가능
		File fcan = new File("e:/cch/can.txt");
		System.out.println(fcan.canRead()?"읽기가능":"읽기불가");
		System.out.println(fcan.canWrite()?"쓰기가능":"쓰기불가");
		System.out.println(fcan.canExecute()?"실행가능":"실행불가");
		/*11]파일 혹은 디렉토리의 최근 수정된 시간 얻기
		long lastModified():1970년 1월 1일 0시 0분 0초부터 현재까지 
		흘러온 시간을 1000분의 1초단위로 환산해서 long형으로 반환.*/
		long time=fcan.lastModified();
		SimpleDateFormat dateFormat =
				new SimpleDateFormat("yyyy-MM-dd a h:mm");
		String lastString=dateFormat.format(new Date(time));
		System.out.println("최근 수정된 시간:"+lastString);
		//12]파일 이름 변경:boolean renameTo(File dest)  
		//   src.renameTo(dest) src와 dest는 둘다 파일객체
		/*
		 * 같은 폴더 안:파일명 변경효과(rename)
		 * 다른 폴더 안으로:파일 이동 효과(cut and paste)
		 */		
		File fchange = new File("e:/cch/change.txt");
		File fmove = new File("e:/cch/change2.txt");
		System.out.println(fchange.renameTo(fmove));
		System.out.println(fmove.renameTo(new File("e:/cch/workspace/change3.txt")));
		/*13]파일목록 및 디렉토리목록 얻어 오기
		String[] list():해당 디렉토리안에 있는 파일 및 디렉토리명만
		File[] listFiles():해당 디렉토리안에 있는 파일 및 디렉토리에
		대한 파일객체 배열 반환
		*/
		String[] names=fuRelativeDir.list();
		System.out.println("[파일 및 디렉토리명만 반환]");
		for(String name:names) System.out.println(name);
		System.out.println("[파일객체 반환]");
		File[] files=fuRelativeDir.listFiles();
		for(File f:files) {
			//파일명 혹은 디렉토리명]
			String name=f.getName();
			//최근 수정된 시간]
			String lastModified = dateFormat.format(new Date(f.lastModified()));
			if(f.isFile()) System.out.print("파일명:"+name);
			else System.out.print("디렉토리명:"+name);
			System.out.println(",최근 수정된 시간:"+lastModified);
		}/////////
	}///////////main

	
}//////////////class
