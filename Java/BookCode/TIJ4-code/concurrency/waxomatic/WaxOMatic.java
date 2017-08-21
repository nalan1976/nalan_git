//: concurrency/waxomatic/WaxOMatic.java
// Basic task cooperation.
package concurrency.waxomatic;
import java.util.concurrent.*;
import static net.mindview.util.Print.*;

class Car {
  private boolean waxOn = false;
  public synchronized void waxed() {
    waxOn = true; // Ready to buff
    notifyAll();
  }
  public synchronized void buffed() {
    waxOn = false; // Ready for another coat of wax
    notifyAll();
  }
  public synchronized void waitForWaxing()
  throws InterruptedException {
    while(waxOn == false)
      wait();
  }
  public synchronized void waitForBuffing()
  throws InterruptedException {
    while(waxOn == true)
      wait();
  }
}

class WaxOn implements Runnable {
  private Car car;
  public WaxOn(Car c) { car = c; }
  public void run() {
    try {
      while(!Thread.interrupted()) {
        printnb("Wax On! ");
        TimeUnit.MILLISECONDS.sleep(200);
        print("WaxOn.run() before Waxed():" + System.nanoTime());
        car.waxed();
        print("WaxOn.run() after Waxed():" + System.nanoTime());
        car.waitForBuffing();
        print("WaxOn.run() after waitForBuffing():" + System.nanoTime());
      }
    } catch(InterruptedException e) {
      print("Exiting via interrupt");
    }
    print("Ending Wax On task");
  }
}

class WaxOff implements Runnable {
  private Car car;
  public WaxOff(Car c) { car = c; }
  public void run() {
    try {
      while(!Thread.interrupted()) {
        print("WaxOff.run() before waitForWaxing():" + System.nanoTime());
        car.waitForWaxing();
        print("WaxOff.run() after waitForWaxing():" + System.nanoTime());
        printnb("Wax Off! ");
        TimeUnit.MILLISECONDS.sleep(200);
        car.buffed();
        print("WaxOff.run() after buffed():" + System.nanoTime());
      }
    } catch(InterruptedException e) {
      print("Exiting via interrupt");
    }
    print("Ending Wax Off task");
  }
}

public class WaxOMatic {
  public static void main(String[] args) throws Exception {
    Car car = new Car();
    ExecutorService exec = Executors.newCachedThreadPool();
    exec.execute(new WaxOff(car));
    exec.execute(new WaxOn(car));
    TimeUnit.SECONDS.sleep(5); // Run for a while...
    exec.shutdownNow(); // Interrupt all tasks
  }
/**本结果记录时使用毫秒为单位，后改为纳秒
 * WaxOn.run() after Waxed():1502860572265
 //重新回到WaxOff停止的地方，继续执行
 WaxOff.run() after waitForWaxing():1502860572265
 Wax Off!
 //切换的太快了！！！后面的语句一句都没执行，就切到了被通知的线程
 WaxOn.run() after waitForBuffing():1502860572466
 Wax On! //while语句也执行了一句
 //再次回到WaxOff将没有执行完的语句执行完。
 //感觉被通知的线程先执行还是通知后的语句先执行没有办法保证
 WaxOff.run() after buffed():1502860572466
 WaxOff.run() before waitForWaxing():1502860572466

 WaxOn.run() before Waxed():1502860572666
 WaxOn.run() after Waxed():1502860572666

 WaxOff.run() after waitForWaxing():1502860572666
 Wax Off!
 WaxOff.run() after buffed():1502860572866
 */}

/* Output: (95% match)
Wax On! Wax Off! Wax On! Wax Off! Wax On! Wax Off! Wax On! Wax Off! Wax On! Wax Off! Wax On! Wax Off! Wax On! Wax Off! Wax On! Wax Off! Wax On! Wax Off! Wax On! Wax Off! Wax On! Wax Off! Wax On! Wax Off! Wax On! Exiting via interrupt
Ending Wax On task
Exiting via interrupt
Ending Wax Off task
*///:~
