//: concurrency/SyncObject.java
// Synchronizing on another object.
import static net.mindview.util.Print.*;
/**
 * 在这个例子中验证了：
 * 1）一个类中2个不同的对象不会构成同步；
 * 2）空byte数组可以作为同步对象
 * */
class DualSynch {
  private Object syncObject = new Object();
  private byte syncObjectTwo[] = new byte[0];
  public synchronized void f() {
    synchronized(syncObjectTwo) {
      for(int i = 0; i < 135; i++) {
        print("f()");
        Thread.yield();
      }
    }
  }
  public void g() {
    synchronized(syncObjectTwo) {
      for(int i = 0; i < 135; i++) {
        print("g()");
        Thread.yield();
      }
    }
  }
}

public class SyncObject_Nalan {
  public static void main(String[] args) {
    final DualSynch ds = new DualSynch();
    new Thread() {
      public void run() {
        ds.f();
      }
    }.start();
    ds.g();
  }
}


