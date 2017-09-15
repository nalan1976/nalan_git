package aop;
/**
 * 从本例中学到：
 * 1）从同一个bean中通过不同接口类型取出的bean是同一个引用；
 * */
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import hello.IHelloWorldService;
import hello.IIntroductionService;
//import cn.javass.spring.chapter6.service.IPayService;
public class AopTest {
    @Test
    public void testHelloworld() {
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("aop_01.xml");
        IHelloWorldService helloworldService =
                ctx.getBean("helloWorldService", IHelloWorldService.class);
        helloworldService.sayHello();
        System.out.println(helloworldService);
    //引入新接口测试
        IIntroductionService introductionService =
                ctx.getBean("helloWorldService", IIntroductionService.class);
        introductionService.induct();
        System.out.println(introductionService);
        //advisor测试
        helloworldService.sayAdvisorBefore("haha");
    }
}
