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


        //以下是第二个例子的测试
        HelloApi bean1 = context.getBean("bean1", HelloApi.class);
        bean1.sayHello();

        HelloApi bean2 = context.getBean("bean2", HelloApi.class);
        bean2.sayHello();


        //以下是第三个例子的测试
//获取根据参数索引依赖注入的Bean
        HelloApi byIndex = context.getBean("byIndex", HelloApi.class);
        byIndex.sayHello();
//获取根据参数类型依赖注入的Bean
        HelloApi byType = context.getBean("byType", HelloApi.class);
        byType.sayHello();
//获取根据参数名字依赖注入的Bean
        HelloApi byName = context.getBean("byName", HelloApi.class);
        byName.sayHello();

        //以下是第四个例子的测试
        HelloApi bean = context.getBean("bean", HelloApi.class);
        bean.sayHello();
        //以下是HelloApiDecorator例子的测试
        //通过构造器方式注入
        HelloApi helloApi1 = context.getBean("helloApi1", HelloApi.class);
        helloApi1.sayHello();
//通过setter方式注入
        HelloApi helloApi2 = context.getBean("helloApi2", HelloApi.class);
        helloApi2.sayHello();

//aop


    }
}