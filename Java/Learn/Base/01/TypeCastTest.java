/*
 * 本例显示了数值与字符串相互串换的几种方式
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
		//数字与空字符串用“+”相连也可
		String str3 = ""+3.03;
		System.out.printf("%s, %s, %s\n", str, str2, str3);
	}
	public static void string2num() {
		int val = Integer.parseInt("4");
		double val2= Double.valueOf("5.05");
		System.out.printf("%d, %f\n", val, val2);
	}
}
