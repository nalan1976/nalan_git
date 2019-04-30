package com.nalan.learn.arithmetic.easy.array;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Given an array and a value, remove all instances of that value in-place and return the new length.
 * <p>
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * <p>
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 * <p>
 * Example:
 * <p>
 * Given nums = [3,2,2,3], val = 3,
 * <p>
 * Your function should return length = 2, with the first two elements of nums being 2.
 * 从本例中学到：
 * 1）++在变量前，哪怕在return语句中也是有效的；
 * 2）2个类似的问题，只要条件有一点点不同，可能算法设计上就会有差异，必须思考全面
 * 3）Arrays的asList()方法 可以将 数组转为List 但是，这个数组类型必须是 引用类型的，如果是8种基本数据类型就不可以
 * 4）java同时声明两个变量并初始化的方式与C不用，逗号表达式要分别初始化
 * 5）在头/尾进行交换也是常用的操作数组的技巧
 * 6）不能轻易受已有观念的影响，如果长时间没有进展，可以考虑从头再来，反而可能是最快的方法
 */
public class RemoveElement {
    public static void main(String[] args) {
        int val = 3;
//        Integer input[] = {3, 3, 3, 3, 1, 3, 4, 3, 3, 5, 9, 3};
//        Integer input[] = {3, 4};
//        Integer input[] = {4, 3};
//        Integer input[] = {4, 3, 4};
//        Integer input[] = {4, 3, 3, 4};
//        Integer input[] = {3, 3};
//        Integer input[] = {4, 4};
//        Integer input[] = {3};
        Integer input[] = {4};

        //test Arrays.asList()++++++
        List lst = Arrays.asList(input);//nalan_*:hugeHole:asList:*; Arrays的asList()方法 可以将 数组转为List 但是，这个数组类型必须是 引用类型的，如果是8种基本数据类型就不可以
        System.out.println("arrays length is : " + lst.size());
        for (Iterator it = lst.iterator(); it.hasNext(); ) {
            System.out.println(it.next().toString());

        }
//        System.out.println(Arrays.asList(input).contains(val));
        System.out.printf("%d is contained in input is : %d\n", val, Arrays.asList(input).contains(val) ? 1 : 0);
        //end test

//        System.out.printf("return new length is : %d\n", removeElement(input, val));
        System.out.printf("return new length is : %d\n", removeElement2(input, val));

        for (int i = 0; i < input.length; ++i) {
            System.out.println(input[i]);
        }
    }

    public static int removeElement(Integer[] nums, int val) {
        //判断一个数组中是否包含一个指定值用collects的相关方法？contains？
        if (nums == null) return 0;
        int pos = 0;
        for ( int diff = pos; diff < nums.length; diff++) {
            if (nums[diff] != val) {
                nums[pos] = nums[diff];
                pos++;
            }
        }
        return pos;
    }
    public static int removeElement2(Integer[] nums, int val) {
        if (nums == null) return 0;

        int swap = 0;
        int pos = 0;
        int tail = nums.length - 1;
        for ( ; pos < tail+1; ){
            if (nums[pos] == val){
                swap = nums[pos];
                nums[pos] = nums[tail];
                nums[tail] = swap;
                if (nums[pos] != val){
                    pos++;
                }
                tail--;
            }
            else{
                pos++;
            }
        }
        return pos;
    }
}
