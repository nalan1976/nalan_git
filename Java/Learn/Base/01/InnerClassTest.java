import java.io.*;

public class InnerClassTest
{
    class Inner {}

	//静态方法中没有this，也就是说没有所谓的外部类对象，因此下面的语句编译错误，无法创建内部类对象
   // public static void foo() { new Inner(); }
    public void bar() { new Inner(); }

	public static void main(String[] args)
	{
		//在静态方法中创建内部类对象，可以如下写
		new InnerClassTest().new Inner();

		System.out.println("end");

	}


    private static String readDataFromConsole(String prompt) {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = null;
    try {
        System.out.print(prompt);
        str = br.readLine();

    } catch (IOException e) {
        e.printStackTrace();
    }
    return str;
    }
	public static void string2Int()
	{
		//字符串转化为整数的2种方式
		String s = "12345";
		int i;

		i = Integer.parseInt(s);
		System.out.println(i);

		i = Integer.valueOf(s).intValue();
		System.out.println(i);


	}
		public static void testCompare()
	{
        String s1 = "Programming";
        String s2 = new String("Programming");
        String s3 = "Program";
        String s4 = "ming";
        String s5 = "Program" + "ming";
        String s6 = s3 + s4;

        System.out.println(s1 == s2);//false s2是重现生成的字符串对象，与s1不同
        System.out.println(s1 == s5);//true 2个连接的字符串与常量池中的是同一引用？
        System.out.println(s1 == s6);//false
        System.out.println(s1 == s6.intern());//true
        System.out.println(s2 == s2.intern());//false




		/* result
		false
		true
		false
		true
		false
		*/

	}
	public static void testCutoff()
	{

	}
}
