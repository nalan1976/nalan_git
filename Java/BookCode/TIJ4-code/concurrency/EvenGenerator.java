//: concurrency/EvenGenerator.java
// When threads collide.

public class EvenGenerator extends IntGenerator {
  private int currentEvenValue = 0;
  public int next() {
    ++currentEvenValue; // Danger point here!
    ++currentEvenValue;
//            2099 not even!
//            2101 not even!
//            2097 not even!
//            2095 not even!
//    currentEvenValue += 1;
//    currentEvenValue += 1;
//    1833 not even!
//            1837 not even!
//            1835 not even!
//    currentEvenValue += 2;//难道JDK1.8对+=优化过了？这一句好像原子操作一样在多线程中半天不会出错
//    currentEvenValue = currentEvenValue + 2;

    return currentEvenValue;
  }
  public static void main(String[] args) {
    EvenChecker.test(new EvenGenerator());
  }
} /* Output: (Sample)
Press Control-C to exit
89476993 not even!
89476993 not even!
*///:~
