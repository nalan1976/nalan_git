

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
		//С�᣺����byte��short�����Ļ������ݣ��洢Խ��1����ֵ����Ϊ��һ����������ֵ��������ѭ��
		short e = (short)-32769;//��Ч��Χ-32768~32767����ʱֵΪ32767
		System.out.println(e);

		e = (short)32768;//should be -32768
		System.out.println(e);

	}
		public static void testFloat()
	{
		float f = 3.4f;
//		double f = 3.4;
		System.out.printf("%.10f \n", f);//����float���Ⱥ����λ������Ч����
		//System.out.printf("%d\n", f);
	}
	public static void testCutoff()
	{
		float f = 356578275.1415f;
		int i = (int)f;
		System.out.printf("%d , %.10f \n", i, f);//����8λ���֣�С����ǰ����Ч����Ҳ�޷���֤�ˣ���������κα������
		//System.out.printf("%d\n", f);
	}
}
