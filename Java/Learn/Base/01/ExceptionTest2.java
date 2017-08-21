/*
 * 本例验证了
 * 1）测试异常捕获规则：自定义异常子类的异常能够被其父类捕获
 * 2）子类没有实现超类的构造，则编译器自动生成默认构造；但子类实现了任何构造，则编译器不再提供默认构造
 * 3）多catch时，必须按照范围由小到大，否则编译器报错
 * 4）静态方法中可以new静态类的对象
 * 5）main方法中同样可抛出异常，只是可以不用在函数定义中用throws声明（当然，也可声明）
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
