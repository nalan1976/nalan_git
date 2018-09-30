package base1;

import java.util.*;
//import java.util.HashSet;

/**
 * 当向Set中添加对象时，首先调用此对象所在类的hashCode()方法，计算次对象的哈希值，此哈希值决定了此对象在Set中存放的位置；
 * 若此位置没有被存储对象则直接存储，若已有对象则通过对象所在类的equals()比较两个对象是否相同，相同则不能被添加。
 */
//类A的equals方法总是返回true,但没有重写其hashCode()方法。不能保证当前对象是HashSet中的唯一对象
class A
{
    public boolean equals(Object obj)
    {
        return true;
    }
}

//类B的hashCode()方法总是返回1,但没有重写其equals()方法。不能保证当前对象是HashSet中的唯一对象
class B
{
    public int hashCode()
    {
        return 1;
    }
}

//类C的hashCode()方法总是返回2,且有重写其equals()方法
class C
{
    public int hashCode()
    {
        return 2;
    }
    public boolean equals(Object obj)
    {
        return true;
    }
}
//类D什么都没有实现
class D
{
}
public class HashSetTest {
    public static void main(String[] args)
    {
        HashSet books = new HashSet();
        //分别向books集合中添加两个A对象，两个B对象，两个C对象
        books.add(new A());
        books.add(new A());

        books.add(new B());
        books.add(new B());

        books.add(new C());
        books.add(new C());

        books.add(new D());
        books.add(new D());
        System.out.println(books);
    }
}
