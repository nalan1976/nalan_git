//: generics/ArrayMaker.java

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayMaker_Nalan<T> {
  private Class<T> kind;
  public ArrayMaker_Nalan(Class<T> kind) { this.kind = kind; }
  @SuppressWarnings("unchecked")
  T[] create(int size) {
    return (T[])Array.newInstance(kind, size);
  }
  public static void main(String[] args) {
    ArrayMaker_Nalan<String> stringMaker =
            new ArrayMaker_Nalan<String>(String.class);
    String[] stringArray = stringMaker.create(9);
    System.out.println(Arrays.toString(stringArray));

    //String[] newInstance should be what?
    System.out.println(Array.newInstance(String.class, 9));
  }
} /* Output:
[null, null, null, null, null, null, null, null, null]
//i added:String[] newInstance should be what?
[Ljava.lang.String;@1540e19d
*///:~
