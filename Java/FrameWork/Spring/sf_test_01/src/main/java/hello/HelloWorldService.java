package hello;

public class HelloWorldService  implements IHelloWorldService {
    @Override
    public void sayHello() {
        System.out.println("============Hello World!");
    }
    @Override
    public void sayAdvisorBefore(String param) {
        System.out.println("============say " + param);
    }
}
