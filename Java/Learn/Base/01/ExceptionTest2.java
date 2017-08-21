/*
 * ������֤��
 * 1�������쳣��������Զ����쳣������쳣�ܹ����丸�ಶ��
 * 2������û��ʵ�ֳ���Ĺ��죬��������Զ�����Ĭ�Ϲ��죻������ʵ�����κι��죬������������ṩĬ�Ϲ���
 * 3����catchʱ�����밴�շ�Χ��С���󣬷������������
 * 4����̬�����п���new��̬��Ķ���
 * 5��main������ͬ�����׳��쳣��ֻ�ǿ��Բ����ں�����������throws��������Ȼ��Ҳ��������
 */

import java.lang.Exception;

public class ExceptionTest2 {
	private static class ExampleA extends Exception{
			public  ExampleA() {
				super();
			}
			public ExampleA(String s) {
				super(s);
			}
	}
	private static class ExampleB extends ExampleA{
		public  ExampleB() {
			super();
		}
		public ExampleB(String s) {
			super(s);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {	
			testCatchRule();
			int i = 1/0;
//			throw new ExampleB();
		}catch(Exception e) {
			System.out.println("main catch the exception");
		}

	}
	public static void testCatchRule() throws Exception{
		try {
//			throw new ExampleB();
		    throw new ExampleB("b");
		} catch(ExampleA e){
		    System.out.println("ExampleA");
		} catch(Exception e){
		    System.out.println("Exception");
		}		
	}
}
