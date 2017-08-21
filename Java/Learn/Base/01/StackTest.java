/*
 * 本例演示了基本stack的用法push和pop
 * 注意：压栈时可以将与空字符连接去掉
 */

import java.util.Stack;
public class StackTest {
static String[] months = {
"January", "February", "March", "April",
"May", "June", "July", "August", "September",
"October", "November", "December" };

public static void main(String[] args) {
	Stack stk = new Stack();
	for(int i = 0; i < months.length; i++)
		stk.push(months[i] + " ");//可以将与空字符连接去掉
	System.out.println("stk = " + stk);
	// Treating a stack as a Vector:
	stk.addElement("The last line");
	System.out.println(
	"element 5 = " + stk.elementAt(5));
	System.out.println("popping elements:");
	while(!stk.empty())
		System.out.println(stk.pop());
}
} 