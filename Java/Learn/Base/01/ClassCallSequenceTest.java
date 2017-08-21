/*
本单元测试了继承类的初始化顺序。
测试条件：
1）其中A为父类，B为子类
2）2类中均有静态区，非静态区和构造函数

则以下代码测试结论为：
当new子类对象时：
1）初始化顺序为：父类静态区->子类静态区->父类非静态区->父类构造函数->子类非静态区->子类构造函数
2）所有静态区只初始化1次，其它区域每次创建时均会按照以上顺序被初始化

 */
public class ClassCallSequenceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        A ab = new B();
        ab = new B();
	}

}
class A {

    static {
        System.out.print("1");
    }

    public A() {
        System.out.print("2");
        System.out.print(i);
    }
   private  final int i = 4;
}

class B extends A{

    static {
        System.out.print("a");
    }

    public B() {
        System.out.print("b");
        System.out.print(j);
    }
    private  final int j = 5;
}