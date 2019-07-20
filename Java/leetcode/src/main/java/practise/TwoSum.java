package practise;

import java.util.*;
import java.util.stream.Collectors;

public class TwoSum {
    public static int[] findTwoSum(int[] list, int sum) {
        //throw new UnsupportedOperationException("Waiting to be implemented.");
//        Set<Integer> set = new HashSet<>( Arrays.stream( list ).boxed().collect( Collectors.toList() ) );
/*          int[] ret = new int[2];
        for (int i = 0; i < list.length; i++){
            ret[0] = i;
            for (int j = i+1; j < list.length; j++){
                if (list[j] == (sum - list[i])) {
                    ret[1] = j;
                    return ret;
                }
            }
        }*/
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < list.length; i++){
            if (map.containsKey(list[i])){
                return new int[] {map.get(list[i]), i};
            }else{
                map.put(sum - list[i], i);
            }
        }

        return null;
    }

    public static void main(String[] args) {
        int[] indices = findTwoSum(new int[] { 3, 1, 5, 7, 5, 9 }, 10);
//        int[] indices = findTwoSum(new int[] { 8, 10, 5, 7, 5, 9 }, 10);
        if(indices != null) {
            System.out.println(indices[0] + " " + indices[1]);
        }
    }
}
