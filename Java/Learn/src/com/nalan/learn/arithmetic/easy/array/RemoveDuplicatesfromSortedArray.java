package com.nalan.learn.arithmetic.easy.array;

/**
 * Given a sorted array, remove the duplicates in-place such that each element appear only once and return the new length.
 * <p>
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * <p>
 * Example:
 * <p>
 * Given nums = [1,1,2],
 * <p>
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
 * It doesn't matter what you leave beyond the new length.
 * 从中学到：
 * 1）虽然在leetcode上只击败了3.22%的solution，但只修改了一次就执行正确还是有一些成就感的，具体收获如下：
 *      a）每个变量、循环变量的明确意义和状态变更情况如果都考虑清楚了，那么代码成功率还是有一定保障的（虽然效率还没有）；
 *      b）测试案例要针对每个可能出现的边界、异常情况和程序分支作出设计，对通过最终测试有极大的帮助；
 * 2）稍长的代码段可用函数实现，不方便用函数的也要把代码段出入参，实现功能模拟思考清楚，对最终结果也会有很大帮助
 * 3）print和printf的区别：printf才支持格式化输出，如%d, %s等参数
 * 4）自己的实现之所以效率低，是因为使用的算法太笨重，而不是现实的技巧有问题；
 */
public class RemoveDuplicatesfromSortedArray {
    public static void main(String[] args) {
        int sortArray[] = {1, 1, 1, 2, 2, 2, 3, 3, 3, 5, 5, 5, 5, 10, 10, 10, 12, 12, 12, 12};
//        int sortArray[] = {1, 1, 2};
//        removeDuplicates(sortArray);
        removeDuplicates1(sortArray);
        for (int i = 0; i < sortArray.length; ++i) {
            System.out.println(sortArray[i]);
        }
    }

    public static int removeDuplicates(int[] nums) {
        int length = nums.length;   //最外层循环次数：初始为数组长度；一旦有重复的数，在将数组前置重排后，其值不断减小
        int retLength = nums.length;    //函数返回的数组最终的有效长度

        for (int i = 0; i < length; ++i) {
            int moveStep = 0;   //移动步长：即从当前位置向后有几个重复值，将当前位置+此值作为数组索引copy即可；
            for (int j = i; j < length; ++j) {//j point the index for the position of the same number
                if (j + 1 < length && nums[j + 1] == nums[i]) {    //当前位置后面一个值与当前值相同
                    retLength -= 1; //返回长度-1
                    moveStep += 1;  //移动步长+1
                    continue;   //进行下一次循环，即当前位置向后移动一位
                } else {    //此时，当前位置后面一个值与当前值不相同，本次小循环（判断相邻值相同的逻辑）结束
                    break;
                }
            }
            //judge need move
            if (moveStep > 0) { //移动步长不为0，则相邻位有相同的值
                for (int k = i + 1; k < length; ++k) {
                    if (k < length && k + moveStep < length) {
                        nums[k] = nums[k + moveStep];
                    }else{
                        break;
                    }
                }
                length -= moveStep;
            }
        }
        System.out.printf("return length is : %d\n", retLength);
        return retLength;
    }
/**使用2个指针
 * Since the array is already sorted, we can keep two pointers ii and jj, where ii is the slow-runner while jj is the fast-runner.
 * As long as nums[i] = nums[j]nums[i]=nums[j], we increment jj to skip the duplicate.

 When we encounter nums[j] \neq nums[i]nums[j]≠nums[i],
 the duplicate run has ended so we must copy its value to nums[i + 1]nums[i+1]. i  is then incremented and we repeat the same process again until jj reaches the end of array.
 * */
    public static int removeDuplicates1(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
