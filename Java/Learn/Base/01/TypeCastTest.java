/*
 * ������ʾ����ֵ���ַ����໥�����ļ��ַ�ʽ
 */
public class TypeCastTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		num2String();
		string2num();
		boolean2String();
	}
	public static void boolean2String(){
		boolean b = false;
		System.out.printf("%b", b);
		System.out.printf(Boolean.toString(b));
		System.out.println(""+b);
	}
	public static void num2String() {
		String str = Integer.toString(1);
		String str2 = String.valueOf(2.02);
		//��������ַ����á�+������Ҳ��
		String str3 = ""+3.03;
		System.out.printf("%s, %s, %s\n", str, str2, str3);
	}
	public static void string2num() {
		int val = Integer.parseInt("4");
		double val2= Double.valueOf("5.05");
		System.out.printf("%d, %f\n", val, val2);
	}
}
