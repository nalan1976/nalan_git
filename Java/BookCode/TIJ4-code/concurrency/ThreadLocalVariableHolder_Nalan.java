//: concurrency/ThreadLocalVariableHolder.java
// Automatically giving each thread its own storage.
import java.util.concurrent.*;
import java.util.*;

class Accessor implements Runnable {
  private final int id;
  public Accessor(int idn) { id = idn; }
  public void run() {
    while(!Thread.currentThread().isInterrupted()) {
      ThreadLocalVariableHolder_Nalan.increment();
      System.out.println(this);
      Thread.yield();
    }
  }
  public String toString() {
    return "#" + id + ": " +
            ThreadLocalVariableHolder_Nalan.get();
  }
}

public class ThreadLocalVariableHolder_Nalan {
//    private Random rand = new Random(47);
  private  static  int value = (new Random(47)).nextInt(10000);
  protected synchronized Integer initialValue() {
    int temp =  (new Random(47)).nextInt(10000);
    System.out.printf("Init value2 is :%d\n", temp);
    return  temp;
//    return (new Random(47)).nextInt(10000);
  }
    /*
  private static Integer value =
        new ThreadLocal<Integer>() {
        private Random rand = new Random(47);
        protected synchronized Integer initialValue() {
          return rand.nextInt(10000);
        }
      };*/
  public synchronized static void increment() {
//    value.set(value.get() + 1);
    value++;
  }
  public static int get() {
    return value;
  }
  public static void main(String[] args) throws Exception {
    ExecutorService exec = Executors.newCachedThreadPool();
    for(int i = 0; i < 5; i++)
      exec.execute(new Accessor(i));
//    TimeUnit.MILLISECONDS.sleep(10);  // Run for a while
    TimeUnit.SECONDS.sleep(1);  // Run for a while
    exec.shutdownNow();         // All Accessors will quit
  }
} /* Output: (Sample)
#0: 9259
#1: 556
#2: 6694
#3: 1862
#4: 962
#0: 9260
#1: 557
#2: 6695
#3: 1863
#4: 963
...
*///:~
