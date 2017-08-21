//import java.util.*;
//import java.lang.Integer;

public class EqualsTest
{
	public static void main(String[] args)
	{
		testAutoWapping();
	}

	public static void testAutoWapping()
	{
		//-128~127 is the range of autowapping, otherelse only use "equals" to compare the two object of Interger
		Integer a = 128;
		Integer b = 128;		
//		Integer a = 127;
//		Integer b = 127;
		
		if(a == b)
			System.out.println("`==` is work");
		
		if (a.equals(b))
			System.out.println("equals is work");		
	}
}