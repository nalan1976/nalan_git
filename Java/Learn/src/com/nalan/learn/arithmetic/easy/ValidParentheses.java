package com.nalan.learn.arithmetic.easy;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Scanner;
/**question:
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 *
 *
 * 从此例中学到：
 * 1）字符串中怎样用字符写foreach循环：for (char c : s.toCharArray())
 * 2）
 * */
//入栈时就配好对，出栈时与右边的括号不匹配就返回false
public class ValidParentheses {
    public static boolean isValid_good(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        while (true){
            String input = scn.nextLine();
            //"()[]{}(())([{}])";
            System.out.println("the result is :" + isValid(input));
            System.out.println("the result is :" + isValid_good(input));
        }

    }
//我的方案考虑了可能有其它字符在其中，还是没完全看懂题，浪费了！
    public static boolean isValid(String s) {
        LinkedList<Integer> lst = new LinkedList();

        for(int i = 0; i < s.length(); i++){
            switch (s.charAt(i)){
                case '(':
                    {lst.push(1);}
                    break;
                case '{':
                    {lst.push(2);}
                    break;
                case '[':
                    {lst.push(3);}
                    break;
                case ')':
                    if (lst.isEmpty() || lst.poll() != 1)  return false;
                    break;
                case '}':
                    if (lst.isEmpty() || lst.poll() != 2)  return false;
                    break;
                case ']':
                    if (lst.isEmpty() || lst.poll() != 3)  return false;
                    break;
                default:
                    continue;
            }
        }
        if(lst.isEmpty())
            return true;
        else
            return false;
    }
}
