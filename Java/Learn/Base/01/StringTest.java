//import java.lang.System.in;
import java.io.*;

public class StringTest
{
	public static void main(String[] args)
	{

		string2Int();
		testCompare();
	//��ȡ�ⲿ����
   	//     String str = readDataFromConsole("Please input string��");
   	//     System.out.println("The information from console��" + str);
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
		//�ַ���ת��Ϊ������2�ַ�ʽ
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

        System.out.println(s1 == s2);//false s2���������ɵ��ַ���������s1��ͬ
        System.out.println(s1 == s5);//true 2�����ӵ��ַ����볣�����е���ͬһ���ã�
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
