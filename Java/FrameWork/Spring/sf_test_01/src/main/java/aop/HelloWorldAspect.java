package aop;

public class HelloWorldAspect {
    //前置通知
    public void beforeAdvice() {
        System.out.println("===========before advice");
    }
    //后置返回通知
    public void afterReturnAdvice(/*String str*/){
        System.out.println(/*str + */"nalan afterReturn advice=============");
    }
    //后置最终通知
    public void afterFinallyAdvice() {
        System.out.println("===========after finally advice");
    }
}
