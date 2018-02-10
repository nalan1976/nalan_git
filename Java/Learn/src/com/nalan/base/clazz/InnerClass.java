package com.nalan.base.clazz;

public class InnerClass {
    class Inner {}
    //静态方法中没有this，也就是说没有所谓的外部类对象，因此无法创建内部类对象
    public static void foo() { new Inner(); }//Error:(6, 32) java: 无法从静态上下文中引用非静态 变量 this

    public void bar() { new Inner(); }

    public static void main(String[] args) {
        new InnerClass().new Inner();//正确的创建内部类实例的方法
    }
}
