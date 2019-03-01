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
	
}
