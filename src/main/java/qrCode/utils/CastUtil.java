package qrCode.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CastUtil {

	public static Date toDate(String str) throws Exception {
		if(str!=null) {
			Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str);
			return date;
		}else {
			return null;
		}
	}
	
	public static Date toDateT(String str) throws Exception {
		if(str!=null) {
			str = str.replace('T', ' ');
			str = str +":00";
			Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str);
			return date;
		}else {
			return null;
		}
	}
	public static void main(String[] args) throws Exception {
		System.out.println(CastUtil.toDateT("2015-09-24T13:59"));
		//System.out.println("2015-09-24T13:59".replace('T', ' '));
	}
}
