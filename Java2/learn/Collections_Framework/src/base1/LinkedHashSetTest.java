package base1;
import java.util.*;
//验证了LinkedHashSetT是按照存储顺序记录数据的
public class LinkedHashSetTest {
    public static void main(String[] args)
    {
        LinkedHashSet books = new LinkedHashSet();
        books.add("Java");
        books.add("LittleHann");
        System.out.println(books);

//删除 Java
        books.remove("Java");
//重新添加 Java
        books.add("Java");
        System.out.println(books);
    }
}
