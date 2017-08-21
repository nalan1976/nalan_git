//: concurrency/CaptureUncaughtException.java
import java.util.concurrent.*;

class ExceptionThread2 implements Runnable {
  public void run() {
    Thread t = Thread.currentThread();
    System.out.println("run() by " + t);
    System.out.println(
      "eh = " + t.getUncaughtExceptionHandler());
    throw new RuntimeException();
  }
}

class MyUncaughtExceptionHandler implements
Thread.UncaughtExceptionHandler {
  public void uncaughtException(Thread t, Throwable e) {
    System.out.println("caught " + e);
  }
}

class HandlerThreadFactory implements ThreadFactory {
  public Thread newThread(Runnable r) {
    System.out.println(this + " creating new Thread");
    Thread t = new Thread(r);
    System.out.println("created " + t);
    t.setUncaughtExceptionHandler(//将处理未捕获异常的句柄设置好
      new MyUncaughtExceptionHandler());
    System.out.println(
      "eh = " + t.getUncaughtExceptionHandler());
    return t;
  }
}

public class CaptureUncaughtException {
  public static void main(String[] args) {
    ExecutorService exec = Executors.newCachedThreadPool(
      new HandlerThreadFactory());
    exec.execute(new ExceptionThread2());
  }
}
/**
 * 我运行的的输出与代码提供的不同，具体如下：
 * "D:\Program Files\Java\jdk1.8.0_131\bin\java" "-javaagent:D:\Program Files\JetBrains\IntelliJ IDEA 2017.2\lib\idea_rt.jar=55668:D:\Program Files\JetBrains\IntelliJ IDEA 2017.2\bin" -Dfile.encoding=UTF-8 -classpath "D:\Program Files\Java\jdk1.8.0_131\jre\lib\charsets.jar;D:\Program Files\Java\jdk1.8.0_131\jre\lib\deploy.jar;D:\Program Files\Java\jdk1.8.0_131\jre\lib\ext\access-bridge-64.jar;D:\Program Files\Java\jdk1.8.0_131\jre\lib\ext\cldrdata.jar;D:\Program Files\Java\jdk1.8.0_131\jre\lib\ext\dnsns.jar;D:\Program Files\Java\jdk1.8.0_131\jre\lib\ext\jaccess.jar;D:\Program Files\Java\jdk1.8.0_131\jre\lib\ext\jfxrt.jar;D:\Program Files\Java\jdk1.8.0_131\jre\lib\ext\localedata.jar;D:\Program Files\Java\jdk1.8.0_131\jre\lib\ext\nashorn.jar;D:\Program Files\Java\jdk1.8.0_131\jre\lib\ext\sunec.jar;D:\Program Files\Java\jdk1.8.0_131\jre\lib\ext\sunjce_provider.jar;D:\Program Files\Java\jdk1.8.0_131\jre\lib\ext\sunmscapi.jar;D:\Program Files\Java\jdk1.8.0_131\jre\lib\ext\sunpkcs11.jar;D:\Program Files\Java\jdk1.8.0_131\jre\lib\ext\zipfs.jar;D:\Program Files\Java\jdk1.8.0_131\jre\lib\javaws.jar;D:\Program Files\Java\jdk1.8.0_131\jre\lib\jce.jar;D:\Program Files\Java\jdk1.8.0_131\jre\lib\jfr.jar;D:\Program Files\Java\jdk1.8.0_131\jre\lib\jfxswt.jar;D:\Program Files\Java\jdk1.8.0_131\jre\lib\jsse.jar;D:\Program Files\Java\jdk1.8.0_131\jre\lib\management-agent.jar;D:\Program Files\Java\jdk1.8.0_131\jre\lib\plugin.jar;D:\Program Files\Java\jdk1.8.0_131\jre\lib\resources.jar;D:\Program Files\Java\jdk1.8.0_131\jre\lib\rt.jar;E:\Develop\Java\Thinking in Java Fourth Edition Code\TIJ4-code\out\production\TIJ4-code" CaptureUncaughtException
 HandlerThreadFactory@7f31245a creating new Thread
 created Thread[Thread-0,5,main]
 eh = MyUncaughtExceptionHandler@6d6f6e28
 run() by Thread[Thread-0,5,main]
 eh = MyUncaughtExceptionHandler@6d6f6e28

 多了以下3行
 HandlerThreadFactory@7f31245a creating new Thread
 created Thread[Thread-1,5,main]
 eh = MyUncaughtExceptionHandler@4fc7e924

 caught java.lang.RuntimeException
 * */

/* Output: (90% match)
HandlerThreadFactory@de6ced creating new Thread
created Thread[Thread-0,5,main]
eh = MyUncaughtExceptionHandler@1fb8ee3
run() by Thread[Thread-0,5,main]
eh = MyUncaughtExceptionHandler@1fb8ee3
caught java.lang.RuntimeException
*///:~
