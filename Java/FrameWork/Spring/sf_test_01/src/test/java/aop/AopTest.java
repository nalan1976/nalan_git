package aop;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import hello.IHelloWorldService;
//import cn.javass.spring.chapter6.service.IPayService;
public class AopTest {
    @Test
    public void testHelloworld() {
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("aop_01.xml");
        IHelloWorldService helloworldService =
                ctx.getBean("helloWorldService", IHelloWorldService.class);
        helloworldService.sayHello();
    }
}
