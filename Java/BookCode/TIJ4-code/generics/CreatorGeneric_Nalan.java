//: generics/CreatorGeneric_Nalan.java

abstract class GenericWithCreate<T> {
//  final T element;//若不打印验证信息，则此变量完全没有必要模板的一部分
  GenericWithCreate() {  }
  abstract T create();
}

class X {}

class Creator extends GenericWithCreate<X> {
  X create() { return new X(); }
//  void f() {
//    System.out.println(element.getClass().getSimpleName());
//  }
}

public class CreatorGeneric_Nalan {
  public static void main(String[] args) {
    Creator c = new Creator();
    System.out.print(c);
//    c.f();
  }
} /* Output:
X
*///:~
