

public class NumberTest
{
	public static void main(String[] args)
	{

		testFloat();
		testCutoff();
		crossBorder();
		String s2 = new StringBuilder("ja")		.append("va").toString();
		System.out.println(s2.intern() == s2);

		String s1 = new StringBuilder("go")		.append("od").toString();
		System.out.println(s1.intern() == s1);

		String s3 = new StringBuilder("ja")		.append("vc").toString();
		System.out.println(s3.intern() == s3);



	}
	public static void crossBorder()
	{
		//小结：类似byte、short这样的基础数据，存储越界1个数值后会成为另一个方向的最大值，并单向循环
		short e = (short)-32769;//有效范围-32768~32767，此时值为32767
		System.out.println(e);

		e = (short)32768;//should be -32768
		System.out.println(e);

	}
		public static void testFloat()
	{
		float f = 3.4f;
//		double f = 3.4;
		System.out.printf("%.10f \n", f);//超出float精度后，最后几位会有无效数字
		//System.out.printf("%d\n", f);
	}
	public static void testCutoff()
	{
		float f = 356578275.1415f;
		int i = (int)f;
		System.out.printf("%d , %.10f \n", i, f);//超过8位数字，小数点前的有效数字也无法保证了，但不会出任何编译错误
		//System.out.printf("%d\n", f);
	}
}
