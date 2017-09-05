package com.nalan.learn.arithmetic.easy;
/**question:Write a function to find the longest common prefix string amongst an array of strings.
 **从本例中学到：
 * 1）怎样判断字符串无效或为空    if (strs == null || strs.length == 0) return "";
 * 2）集合contains()、retainAll()和clear()方法的使用、String类型charAt方法的使用
 * 3）字符串数组可以使用下标
 * 4）横向和纵向查找
 * 5）还有很多优秀算法见：https://leetcode.com/problems/longest-common-prefix/solution/
 * */
import java.util.*;

public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        Set st = new HashSet();
        Set stTemp = new HashSet();


        for(int i = 1; i <= strs[0].length(); i++)
            st.add(strs[0].substring(0, i));

        for (String s : strs){
            if (s.length() == 0) return "";

            for(int j = 1; j <= s.length(); j++)
                if(st.contains(s.substring(0, j))) stTemp.add(s.substring(0, j));

            st.retainAll(stTemp);
            stTemp.clear();
        }

        Iterator<String> it = st.iterator();
        String ret = "";
        String ret2 = "";

        while(it.hasNext()) {
            ret2 = it.next();
            if(ret2.length() > ret.length())    ret = ret2;
        }

        return ret;
    }

    public static void main(String[] args) {
        String[] input = {"str1234", "str1ing", "str1str123"};
//        String[] input = {"","","","","","",};
//        String[] input = {"a"};
        System.out.println(longestCommonPrefix(input));
        System.out.println(longestCommonPrefix_First(input));
        System.out.println(longestCommonPrefix_Second(input));
    }
    public static String longestCommonPrefix_First(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        return prefix;
    }
    public static String longestCommonPrefix_Second(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        for (int i = 0; i < strs[0].length() ; i++){
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j ++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c)
                    return strs[0].substring(0, i);
            }
        }
        return strs[0];
    }
}
