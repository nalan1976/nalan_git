package com.nalan.learn.arithmetic.easy;
import java.util.Scanner;
/**question:
 * Determine whether an integer is a palindrome. Do this without extra space.
 * e.g: 12321   567898765       808
 *
 *
 *
 *no extra space means anything of the order greater than O(1) .
 Extra space would mean if the space can be expressed as a function of the length of the input.
 For eg. space could be O(n) if we store the n numbers while comparing arrays.

 * 从这个例子中学到：
 * 1）去掉数据的首位在很多情况下不可行，因为后面的可能是0
 * 2）将数值倒过来的固定写法(假设x为原始值)：rev = 10*rev + x%10
 * 3）解决数值倒过来的溢出问题的思路：减小循环次数
 *      1.有没有可能将循环i减小到i/2，或1/2 + 1的程度；
 *      2.有没有可能将循环减小到i-1的程度；
 * 4）scanner.nextInt()的用法
 * 5）without extra space到底是什么意思？
 * */
public class PalindromeNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int input = scanner.nextInt();
            //my solution is wrong
//            System.out.println(input + " is a palindrome? " + IsPalindrome(input));
            //perfect solution
//            System.out.println(input + " is a palindrome? " + isPalindromePerfect(input));
            //good solution
            System.out.println(input + " is a palindrome? " + isPalindromeGood(input));
        }
    }
    public static boolean isPalindromePerfect(int x){
        if (x<0 || (x!=0 && x%10==0)) return false;
        int rev = 0;
        //将循环i减小到i/2，或1/2 + 1的程度以避免溢出
        while (x>rev){
            rev = rev*10 + x%10;
            x = x/10;
        }
        //根据x为基数和偶数的不同情况进行判断
        return (x==rev || x==rev/10);
    }

    public static  boolean isPalindromeGood(int x){
        if (x < 0) return false;

        int p = x;
        int q = 0;

        while (p >= 10){//这个条件巧妙的限制了循环次数导致，后面的q的值始终会比x少一位，从而避免了溢出问题
            q *=10;
            q += p%10;
            p /=10;
        }
        //由于前面的限制，此处q与x去掉最后一位比；p与x最后一位比，同时成立这2个数才相等
        return q == x / 10 && p == x % 10;
    }
    //我的方案，想通过去掉头尾不断减小数的长度是不可行的，因为20102去掉头尾后已0开始，数据会有变化
    public static boolean IsPalindrome( int x ){
        if ( x < 0 )
            return false;

        while( x > 9){
            if( x%10 == getFirstNuber( x ) ){
                x = x/10;
                x = dropFirstNumber( x );
            }
            else{
                return false;
            }
        }
        return true;
    }
    public static final int getFirstNuber( int x ){
        while( x/10 >= 1 ){
           x  = x/10;
        }
        return x;
    }
    public static final int dropFirstNumber(int x){
        int d1 = 1;
        while(x / (10*d1) > 10 ){
            d1 = 10 * d1;
        }
        return x % (10 * d1);
    }
}
