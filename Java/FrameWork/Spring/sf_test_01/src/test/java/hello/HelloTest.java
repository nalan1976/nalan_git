package hello;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloTest {
    @Test
    public void testHelloWorld() {
        //获取类路径的目录
        String s[] = System.getProperty("java.class.path").split(";");
        for (String string : s) {
            System.out.println(string);
        }
//1、读取配置文件实例化一个IoC容器
        ApplicationContext context =
                new ClassPathXmlApplicationContext("helloworld.xml");
//2、根据Bean id从容器中获取Bean，注意此处完全―面向接口编程，而不是面向实现‖
        HelloApi helloApi = context.getBean("hello", HelloApi.class);
//3、执行业务逻辑
        helloApi.sayHello();
    }
}