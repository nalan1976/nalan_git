/*
 * �����ǽ��ַ�����GB2312תΪISO-8859-1����ת������ַ�����ӡ����������
 */
import java.io.*;

public class OptStrTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		encodeConversion();
	}

	public static void encodeConversion() {
		String s1 = "���";
		try {
			byte bt[] = s1.getBytes("GB2312");
			String s2 = new String(bt, "ISO-8859-1");	
			//Ϊ�˿��ĸ����������һ��ת��Ϊ2��
//			String s2 = new String(s1.getBytes("GB2312"), "ISO-8859-1");
			System.out.printf("%s", s2);//����
		}
		catch(UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}
