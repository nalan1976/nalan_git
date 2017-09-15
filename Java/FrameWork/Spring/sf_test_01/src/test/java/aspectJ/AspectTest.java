package aspectJ;

import hello.IHelloWorldService;
import hello.IIntroductionService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//import cn.javass.spring.chapter6.service.IPayService;
public class AspectTest {
    @Test
    public void testHelloworld() {
//        ApplicationContext ctx =
//                new ClassPathXmlApplicationContext("aspectJ.xml");
//
//        IIntroductionService introductionService =
//                ctx.getBean("helloWorldService", IIntroductionService.class);
//        introductionService.induct();
//        //advisor测试
//        helloworldService.sayAdvisorBefore("haha");

        System.out.println("======================================");
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("aspectJ.xml");
        IHelloWorldService helloworldService =
                ctx.getBean("helloWorldService", IHelloWorldService.class);
        helloworldService.sayAdvisorBefore("before");
        System.out.println("======================================");
    }
}
