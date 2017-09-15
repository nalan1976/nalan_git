package hello;

public class IntroductiondService  implements IIntroductionService {
    public IntroductiondService() {
    }

    @Override

    public void induct() {
        System.out.println("=========introduction");
    }
}
