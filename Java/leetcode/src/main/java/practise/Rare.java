package practise;

import java.util.*;
public class Rare {
    public static int nthMostRare(int[] elements, int n) {
        //throw new UnsupportedOperationException("Waiting to be implemented.");

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < elements.length; ++i){
            if(map.containsKey(elements[i])){
                map.put(elements[i], map.get(elements[i]) + 1);
            }else{
                map.put(elements[i], 1);
            }
        }

/*        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            //题目要求是第二个最少的数，不是个数等于2的数
            if(n == entry.getValue()){
                return entry.getKey();
            }
        }*/
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        });

        return list.size() > n ? list.get(n - 1).getKey() : -1;
    }

    public static void main(String[] args) {
        int x = nthMostRare(new int[] { 5, 4, 3, 2, 1, 5, 4, 3, 2, 5, 4, 3, 5, 4, 5 }, 2);
        System.out.println(x);
    }
}