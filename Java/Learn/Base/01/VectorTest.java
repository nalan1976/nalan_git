/*
 * 本例演示了：
 * 1）Vector和枚举的基本用法
 * 2）
 * 注意：本例会有运行时异常
 */
import java.util.*;
class Cat2 {
private int catNumber;
Cat2(int i) {
catNumber = i;
}
void print() {
System.out.println("Cat number " +catNumber);
}
}
class Dog2 {
private int dogNumber;
Dog2(int i) {
dogNumber = i;
}
void print() {
System.out.println("Dog number " +dogNumber);
}
}
public class VectorTest {
	public static void main(String[] args) {
	Vector cats = new Vector();
	
	Enumeration e = cats.elements();
	System.out.println(""+e.hasMoreElements());//
	
	for(int i = 0; i < 7; i++)
		cats.addElement(new Cat2(i));
	// Not a problem to add a dog to cats:
	cats.addElement(new Dog2(7));

	while(e.hasMoreElements())
		((Cat2)e.nextElement()).print();
	// Dog is detected only at run-time

	}
}