import java.util.HashMap;
//解题前三名：https://leetcode.com/problems/two-sum/solution/
/**
 * 学习到：
 * 1）new一个需要返回的、直接初始化的数组不能加数组名
 * 2）HashMap的get和containsKey方法和其返回值
 * 3）
 * */
//我的：30ms
public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        int[] ret = new int[2];
        for(int i=0; i<nums.length; i++){
            int j = i + 1;
            while(j < nums.length){
                if(nums[j] == target-nums[i]){
                    ret[0] = i;
                    ret[1] = j;
                    return ret;
                }
                j++;
            }
        }
        return ret;
    }
//修改后，没什么变化
    public static int[] twoSum2(int[] nums, int target) {
        //int[] ret = new int[2];
        for(int i=0; i<nums.length; i++){
            int j = i + 1;
            while(j < nums.length){
                if(nums[j] == target-nums[i]){
                    //ret[0] = i;
                    //ret[1] = j;
                    return new int[] {i, j};
                }
                j++;
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    //8ms
    public static int[] twoSumGood(int[] nums, int target) {
        int[] ret = {-1, -1};
        //为什么选择HashMap？明白了
        HashMap<Integer, Integer> indexMap = new HashMap<>();
        int i = 0;
        for (int num : nums) {
            int diff = target - num;
            Integer index = indexMap.get(diff);
            if (index != null) {
                ret[0] = index;
                ret[1] = i;
                return ret;
            }
            indexMap.put(num, i++);
        }
        return ret;
    }
    //3ms，完全没看懂！！！
    public static int[] twoSumPerfect(int[] nums, int target) {
        int[] map = new int[16030];
        for (int i = 0; i < nums.length; i++) {
            int diff=target-nums[i]+5;
            if (diff < 0) continue;
            if(map[diff]>0){
                return new int[] {map[diff]-1,i};
            }
            map[nums[i]+5]=i+1;
        }
        throw null;
    }
    public static void main(String[] args) {
        int input[] = {1, 3, 7, 10, 290, 15,38, 48};
        int output[] = twoSum2(input, 45);
//        int output[] = twoSumGood(input, 45);
//        int output[] = twoSumPerfect(input, 45);
        System.out.println(output[0]+" "+output[1]);

    }
}
