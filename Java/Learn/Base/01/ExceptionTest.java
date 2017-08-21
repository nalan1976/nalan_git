/*本例测试：
 * 1）测试异常返回规则
//方法一旦定义了抛出已检测异常，则调用此方法的地方必须try/catch，否则无法编译通过
//方法定义处的异常名与catch处的异常名必须匹配，或者catch处的异常是方法定义处的超类（？）
//若catch语句中再次抛出异常，则执行完匹配的finally语句后返回调用者
 * 
*/
import java.lang.Exception;

public class ExceptionTest
{

	
	public static void main(String[] args) 
	{
		//测试异常返回规则
		System.out.printf("begin\n");
		try{
			testE();
		}
		catch(RuntimeException e){
		
			System.out.printf("catch\n");
		
		}
		finally {
		 	System.out.printf("finally\n");
		}
		

/*
 * 类ExampleA继承Exception，类ExampleB继承ExampleA		
 */
//		

	}
	
	public static void testE() throws ArithmeticException
	{
		System.out.printf("enter testE()\n");
		try{
			testE2();
		}
		catch(RuntimeException e){
			System.out.printf("catch two\n");
			int i = 1/0;
		}
		finally {
		 	System.out.printf("finally two\n");
		}
		
		int i = 1/0;
	}
	public static void testE2() throws ArithmeticException
	{
		System.out.printf("enter testE two()\n");
		int i = 1/0;
	}	
}