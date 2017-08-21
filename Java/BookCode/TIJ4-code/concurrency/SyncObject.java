//: concurrency/SyncObject.java
// Synchronizing on another object.
import static net.mindview.util.Print.*;
/**
 * 在这个例子中我必须把循环数改大一点，否则没法出现不同步问题
 * 把g()锁定对象换为this就出现的同步的状态
* */
class DualSynch {
  private Object syncObject = new Object();
  public synchronized void f() {
    for(int i = 0; i < 135; i++) {
      print("f()");
      Thread.yield();
    }
  }
  public void g() {
    synchronized(syncObject) {
      for(int i = 0; i < 135; i++) {
        print("g()");
        Thread.yield();
      }
    }
  }
}

public class SyncObject {
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

/* Output: (Sample)
g()
f()
g()
f()
g()
f()
g()
f()
g()
f()
*///:~
