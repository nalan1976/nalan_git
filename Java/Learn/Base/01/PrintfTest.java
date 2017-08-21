import java.util.*;

public class PrintfTest
{
	public static void main(String[] args)
	{
		System.out.printf("%tc\n", new Date());	
		System.out.printf("%1$s %2$tB %2$te,%2$tY\n", "Due date:", new Date());
		
		testVariableParam();
		
		Object[] str = new Object[]{new Integer(1), "Widgets", "end1"};
//		System.out.printf("%s", str.toString());
		System.out.printf("%s", str[2]);

	}
	public static void testVariableParam()
	{
		System.out.printf("%d %s %s\n", new Object[]{new Integer(1), "Widgets", "end1"});
	}
	static {
        System.out.print("1");
    }
}