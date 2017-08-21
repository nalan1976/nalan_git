//: holding/ModifyingArraysAsList.java
import java.util.*;

public class ModifyingArraysAsList {
  public static void main(String[] args) {
    Random rand = new Random(47);
    Integer[] ia = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
    List<Integer> list1 =
      new ArrayList<Integer>(Arrays.asList(ia));//重新创建对象，不会打乱ia数组的顺序
    System.out.println("Before shuffling: " + list1);
    Collections.shuffle(list1, rand);
    System.out.println("After shuffling: " + list1);
    System.out.println("array: " + Arrays.toString(ia));//array: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

    System.out.printf("List ClassName is:" + Arrays.asList(ia).getClass());//我添加的
    System.out.println();

    List<Integer> list2 = Arrays.asList(ia);//直接将ia数组指向list2对象，对list2的更变会影响到ia数组
    System.out.println("Before shuffling: " + list2);
    Collections.shuffle(list2, rand);
    System.out.println("After shuffling: " + list2);
    System.out.println("array: " + Arrays.toString(ia));//array: [9, 1, 6, 3, 7, 2, 5, 10, 4, 8]

    //我添加的list1可以remove但list2不行
    //!list2.remove(1);//运行时抛出异常UnsupportedOperationException
    //!System.out.println("array: " + Arrays.toString(ia));
  }
} /* Output:
Before shuffling: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
After shuffling: [4, 6, 3, 1, 8, 7, 2, 5, 10, 9]
array: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
Before shuffling: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
After shuffling: [9, 1, 6, 3, 7, 2, 5, 10, 4, 8]
array: [9, 1, 6, 3, 7, 2, 5, 10, 4, 8]
*///:~
