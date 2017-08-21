/*
 * 本例是将字符串由GB2312转为ISO-8859-1，但转换后的字符串打印出来是乱码
 */
import java.io.*;

public class OptStrTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		encodeConversion();
	}

	public static void encodeConversion() {
		String s1 = "你好";
		try {
			byte bt[] = s1.getBytes("GB2312");
			String s2 = new String(bt, "ISO-8859-1");	
			//为了看的更清楚，将这一句转化为2句
//			String s2 = new String(s1.getBytes("GB2312"), "ISO-8859-1");
			System.out.printf("%s", s2);//乱码
		}
		catch(UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}
