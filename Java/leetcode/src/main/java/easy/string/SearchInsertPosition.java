package easy.string;
/**
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

 You may assume no duplicates in the array.

 Example 1:

 Input: [1,3,5,6], 5
 Output: 2
 Example 2:

 Input: [1,3,5,6], 2
 Output: 1
 Example 3:

 Input: [1,3,5,6], 7
 Output: 4
 Example 1:

 Input: [1,3,5,6], 0
 Output: 0
 通过此例学到：
 1）JUnit基本用法，TestNG人家说比JUnit还要好一些
 2）复习了二分法查找算法
 3）重建了leetcode目录，复习了git的用法
* */
public class SearchInsertPosition {
    public static int searchInsert(int[] nums, int target) {
        int i = 0;
        for ( ; i <nums.length; i++){
            if (nums[i] >= target) return i;
        }
        return i;
    }
    public static int searchInsertBinary(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;
        //注意循环条件是<=
        while (low <= high/* && nums[low] <= nums[high]*/){//与传统二分法比较值不同
            mid =  (low + high) >>> 1;//无符号右移
            if (nums[mid] > target){
                high--;
            }else if (nums[mid] < target){
                low++;
            }else{
                return mid;
            }
        }
        return low;
    }
}
