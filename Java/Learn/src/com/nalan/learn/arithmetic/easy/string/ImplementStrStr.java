package com.nalan.learn.arithmetic.easy.string;

import java.util.HashMap;
import java.util.Map;

/**
 * *Implement strStr().

 Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

 Example 1:

 Input: haystack = "hello", needle = "ll"
 Output: 2
 Example 2:

 Input: haystack = "aaaaa", needle = "bba"
 Output: -1

 从中学到：
 1）用JUnit测试确实比自己写的要方便，应该坚决使用；
 2）使用正则表达式进行字符查找/替换是必备技能；
 3）当实现的极为复杂时，极大的可能是方法走偏了，尤其是已知的算法题；
 4）出现上述情况时，一个办法是用充分的测试用例进行调试，可能是解决问题的一个方法（虽然方法不好）；
 5）当通过不断测试+调试通过的代码，极有可能没有什么可读性。只能通过：
    a）在函数说明上写清楚函数的目的，及其出入参数和含义，一定要写清楚，给将来可能的重构提供尽可能多的线索；
    b）判断的逻辑在程序中也应尽量注释清楚
 */
public class ImplementStrStr {
    public static void main(String[] args) {
        Map<String, String> input = new HashMap();
//        input.put("mississippi", "issipi");
//        input.put("ddd", "dddd");
        input.put("d", "");
//        input.put("", "a");
//        input.put("", "");
//        input.put("aaabb", "aab");
//        input.put("c", "c");
//        input.put("hello", "he");
//        input.put("hello1", "ll");
//        input.put("hello2", "lo2");
//        input.put("hello3", "hello3");
//        input.put("aaaaa", "bba");
//        input.put("aaabbb", "abb");
//        input.put("a", "b");

        for (Map.Entry<String, String> entry : input.entrySet()){//nalan_*:Map:iterate:*;
            System.out.println("input haystack is : " + entry.getKey() + ", and needle is : " +entry.getValue());
//            System.out.println("Output is : " + strStr(entry.getKey(), entry.getValue()));
            System.out.println("Output is : " + strStr1(entry.getKey(), entry.getValue()));
        }
    }
    public static int strStr(String haystack, String needle) {
        if (needle.equals("")) return 0;
        if (haystack.equals("") && !needle.equals("")
                || needle.equals("") && !haystack.equals("")
                || haystack.length() < needle.length()) return -1;

        int pNeedle = 0;//指向needle的索引
        int retIdx = 0; //返回满足条件的第一个索引值，若无返回-1
        /*tag的值为：每次haystack中与needle第一个字母相同的索引位置+1，一旦验证其后续字母不相同，则i循环从此位置重新开始遍历
        * */
        int tag = 0;

        for (int i = 0; i < haystack.length(); ){
            if (pNeedle < needle.length() && needle.charAt(pNeedle) == haystack.charAt(i)){
                if (pNeedle == 0){//如果指向needle的开始位置，说明tag值需要重新确定
                    tag = i + 1;
                }
                pNeedle++;
                if (pNeedle == needle.length()){
                    retIdx = i - needle.length() + 1;   //能够正常匹配的情况，一定要执行这一句
                    break;
                }
                else{
                    retIdx = -1;    //有一种情况是input.put("mississippi", "issipi")，没有匹配完成，如果不置为无效，返回会出错
                }
            }
            else if (tag != 0){//本次查找中，至少已经发现与needle头一位相同的字符（但后续字符又不同）
                pNeedle = 0; //一旦haystack中的字符与needle中不同，则重置所有变量
                retIdx = 0;
                i = tag;
                tag = 0;
                continue;
            }
            i++;
        }
        if (pNeedle == 0 || (needle.length() == 1 && retIdx == 0 && haystack.charAt(0) != needle.charAt(0))){
            return -1;
        }
        return retIdx;
    }
/*思路简洁，看了真让人惭愧，自己写的就是垃圾，从中学到：
1）for循环还有这种用法，可以不指定退出条件，在运行体中穷尽各种情况自行退出；
2）给定字符串比较时，长度关系的变化也是重要的思考点之一；

* */
    public static int strStr1(String haystack, String needle) {
        for (int i = 0; ; i++) {    //haystack指示器
            for (int j = 0; ; j++) {//needle指示器
                if (j == needle.length()) return i; //能够走到needle结束，则已经找到了相同的字符串
                if (i + j == haystack.length()) return -1;//haystack已经走过的长度+needle的长度等于haystack长度，已经没有可能找到匹配项
                if (needle.charAt(j) != haystack.charAt(i + j)) break;//一旦发现字符不匹配，则跳出当前for循环，重新执行外部循环
            }
        }
    }
}
