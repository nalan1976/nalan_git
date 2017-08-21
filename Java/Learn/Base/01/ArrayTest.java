/*
 * 本例验证了：
 * 1）数组声明时没有指向任何对象，所以没有长度，对象自动初始化为null；
 * 2）new以后长度length就已经固定，已经指向所分配的对象；
 * 3）基本数据new后初始化为0；
 * 4）初始化数组的语法
 */
class Weeble {} // A small mythical creature
public class ArrayTest {
		public static void main(String[] args) {
		// Arrays of objects:
		Weeble[] a; // Null handle
		Weeble[] b = new Weeble[5]; // Null handles
		Weeble[] c = new Weeble[4];
		System.out.println("数组c长度："+c.length);
		
		System.out.println("new之前此时c[0]=" + c[0]);
		for(int i = 0; i < c.length; i++)
			c[i] = new Weeble();
		System.out.println("new之后此时c[0]=" + c[0]);
		System.out.println("此时c[1]=" + c[1]);
		
		Weeble[] d = {
				new Weeble(), new Weeble(), new Weeble()
		};
		System.out.println("数组d直接使用大括号方式初始化，此时d[0]=" + d[0]);
		// Compile error: variable a not initialized:
		//!System.out.println("a.length=" + a.length);
		System.out.println("b.length = " + b.length);
		// The handles inside the array are
		// automatically initialized to null:
		for(int i = 0; i < b.length; i++)
			System.out.println("b[" + i + "]=" + b[i]);
		System.out.println("c.length = " + c.length);
		System.out.println("d.length = " + d.length);
		a = d;
		System.out.println("a.length = " + a.length);
		System.out.println("运行a=d后，此时a[0]=" + a[0]);
		// Java 1.1 initialization syntax:
		a = new Weeble[] {
				new Weeble(), new Weeble()
		};
		System.out.println("a.length = " + a.length);
		System.out.println("重新将a指向新建的对象，此时a[0]=" + a[0]);
		
		
		// Arrays of primitives:
		int[] e; // Null handle
		int[] f = new int[5];
		int[] g = new int[4];
		for(int i = 0; i < g.length; i++)
			g[i] = i*i;
		
		int[] h = { 11, 47, 93 };
		// Compile error: variable e not initialized:
		//!System.out.println("e.length=" + e.length);
		System.out.println("f.length = " + f.length);
		// The primitives inside the array are
		// automatically initialized to zero:
		for(int i = 0; i < f.length; i++)
			System.out.println("f[" + i + "]=" + f[i]);
		
		System.out.println("g.length = " + g.length);
		System.out.println("h.length = " + h.length);
		e = h;
		System.out.println("e.length = " + e.length);
		// Java 1.1 initialization syntax:
		e = new int[] { 1, 2 };
		System.out.println("e.length = " + e.length);
	}
}