package common.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;



public class CommonUtilities {
	//[문자열이 숫자 형식이면 true,아니면 false반환]
	public static boolean isNumber(String value) {
		//System.out.println("문자열의 길이:"+value.length());		
		for(int i=0;i < value.length();i++) {
			//Character클래스의 메소드 사용	
			/*
			//방법1]isDigit 와 codePointAt 사용
			if(!Character.isDigit(Character.codePointAt(value, i)))  
				return false;
			//방법2]codePointAt()만 사용
			//int codeValue = Character.codePointAt(value, i);
			//if(!(codeValue>='0' && codeValue<='9')) return false;*/
			//String 클래스 사용
			if(!(value.codePointAt(i)>='0' && value.codePointAt(i) <='9')) 
				return false;
			
		}
		return true;
	}////////////////////////]
	//두 날짜 차이를 반환하는 메소드]
	//반환타입:long
	//매개변수:String타입의 두 날짜,날짜패턴,구분자(단위)
	public static long getDifferenceDates(
			String stFDate,
			String stSDate,
			String pattern,
			char delim) throws ParseException {
		//1]매개변수에 전달된 pattern으로 SimpleDateFormat객체생성
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		//2]String -> Date:parse()
		Date fDate = dateFormat.parse(stFDate);
		Date sDate = dateFormat.parse(stSDate);
		//3]시간차 구하기:getTime()
		long fTime = fDate.getTime();
		long sTime = sDate.getTime();
		long diff = sTime-fTime;
		//4]매개변수 delim에 따른 날짜 차이 반환
		switch(Character.toUpperCase(delim)) {
			case 'D':return diff/(24*60*60*1000);
			case 'H':return diff/(60*60*1000);
			case 'M':return diff/(60*1000);
			default:return diff/1000;
		}
	}
	
}////////////////class
