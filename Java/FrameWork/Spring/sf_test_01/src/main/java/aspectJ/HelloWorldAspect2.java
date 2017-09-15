package aspectJ;
import hello.IHelloWorldService;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

//定义切面
@Aspect
public class HelloWorldAspect2 {
    //定义切入点
    @Pointcut(value="execution(* hello..*.sayAdvisorBefore(..)) && args(param)",
            argNames = "param")
    public void beforePointcut(String param) {}
    //定义通知
    @Before(value = "beforePointcut(param)", argNames = "param")
    public void beforeAdvice(String param) {
        System.out.println("===========before advice param:" + param);
    }

}
