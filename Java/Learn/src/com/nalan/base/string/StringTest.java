package com.nalan.base.string;

import java.util.LinkedList;
import java.util.List;

public class StringTest {
    public static void main(String[] args) throws Exception{
        short s1 = 1;
//        s1 = s1 + 1;//不能编译，Error:(6, 17) java: 不兼容的类型: 从int转换到short可能会有损失
        s1 += 1;//相当于s1 = (short)(s1 + 1);其中有隐含的强制类型转换
        testIntern();

        testConvert();
        //翻转字符串
        System.out.println(stringReverse("123456"));
        System.out.println(stringReverse2("123456"));
        System.out.println(stringReverseGood("123456"));//递归

        System.out.println("将GB2312编码的字符串转换为ISO-8859-1编码的字符串");//都是乱码？
        System.out.println(gb2312ConvertISO88591("将GB2312编码的字符串转换为ISO-8859-1编码的字符串"));//都是乱码？
        partition();
    }
    public static void testIntern(){
        String s1 = "Programming";
        String s2 = new String("Programming");
        String s3 = "Program";
        String s4 = "ming";
        String s5 = "Program" + "ming";
        String s6 = s3 + s4;
        System.out.println(s1 == s2);               //false 一个new出来在堆中，一个在常量池
        System.out.println(s1 == s5);               //true  两个都引用常量池中同一个地址
        System.out.println(s1 == s6);               //false s6中2个变量相加生成新的变量，在堆中
        System.out.println(s1 == s6.intern());  //true  intern方法会得到字符串对象在常量池中对应的版本的引用，所以是从常量池中返回同一引用
        System.out.println(s2 == s2.intern());  //false 一个是堆中变量的引用，一个是常量池中返回的引用
    }

    public static void testConvert() {
        String s1 = "1";
        Integer i1 = 2;
        Double d1 = 3.3;
        System.out.println(String.valueOf(i1));

        System.out.println(String.valueOf(3.3));
        System.out.println(String.valueOf(d1));

        System.out.println(Integer.valueOf(s1));
        System.out.println(Integer.parseInt(s1));
    }
    //使用LinkedList模拟栈的行为
    public static String stringReverse(String str){
        LinkedList list = new LinkedList<>();
        for(int i = 0; i < str.length(); i++ ){
            list.push(str.substring(i, i + 1));
        }
        StringBuilder strTemp = new StringBuilder(str.length());
        while(list.peek() != null){
            strTemp.append(list.pop());//用list.poll()也可以
        }
        return strTemp.toString();
    }
    //
    public static String stringReverse2(String str) {
/*        if(str == null || str.length() <= 1)
            return str;
        return stringReverse2(str.substring(1)) + str.charAt(0);*/
        final  StringBuilder strTemp = new StringBuilder(str.length());
        for(int i = str.length(); i> 0; i--) {
            strTemp.append(str.substring(i - 1, i));
        }
        return strTemp.toString();
    }
    //使用递归，非常巧妙
    public static String stringReverseGood(String str) {//nalan_*:recursion::*;
        if(str == null || str.length() <= 1)
            return str;
        return stringReverseGood(str.substring(1)) + str.charAt(0);
    }
    //将GB2312编码的字符串转换为ISO-8859-1编码的字符串
    public static String gb2312ConvertISO88591(String str) throws Exception{
        return new String(str.getBytes("GB2312"), "ISO-8859-1");
    }
    public static void partition(){

        for(int i = 0; i < 100; i++){
            String temp = "PARTITION day";
            temp += i;
            temp += " ";
            temp+= "VALUES LESS THAN (";
            temp+= i*7;
            temp+= "),";
            System.out.println(temp);
        }
    }
}
