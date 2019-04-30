package practice;

import java.util.Iterator;
import  java.lang.reflect.*;

public class CustomIteratorArray<Integer> implements Iterable<Integer>{
    private Integer[] values;     //store datas
    public CustomIteratorArray(Integer[] values){
        this.values = values;
    }

    @Override
    public Iterator<Integer> iterator() {
        Iterator<Integer> it = new Iterator<Integer>() {
            private int cur = 0;

            private boolean hasEven(Integer idx) {
                for (int i = idx; i < values.length; i++) {
//                if (values[i]%2 == 0) return true;
                    return true;
                }
                return false;
            }

            @Override
            public boolean hasNext() {
                if (cur < values.length && hasEven(cur)) return true;
                return false;
            }


            @Override
            public void remove() {

            }

            @Override
            public Integer next() {
                for (int i = cur; i < values.length; i++) {
//                if (values[i]%2 == 0) return values[i];
//                return null;
                    return values[i];
                }
                return null;
            }
        };
        return it;
    }
    public static void main(String[] args) {
        Integer[] numbers = new Integer[]{1, 2, 3, 4, 5};
        CustomIteratorArray arr = new CustomIteratorArray(numbers);

        for (Iterator it = arr.iterator(); it.hasNext(); ){
            System.out.println("the even is : "+ it.next());
        }

    }

}
