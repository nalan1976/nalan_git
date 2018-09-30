package net.jcip.examples;

import java.util.concurrent.*;

/**
 * TestHarness
 * <p/>
 * Using CountDownLatch for starting and stopping threads in timing tests
 *
 * @author Brian Goetz and Tim Peierls
 */
public class TestHarness {
    public long timeTasks(int nThreads, final Runnable task)
            throws InterruptedException {
        final CountDownLatch startGate = new CountDownLatch(1);
        final CountDownLatch endGate = new CountDownLatch(nThreads);

        for (int i = 0; i < nThreads; i++) {
            Thread t = new Thread() {
                public void run() {
                    try {
                        System.out.println("run thread : "  + "before await()");
                        startGate.await();
                        try {
                            System.out.println("run thread : "  + "before run()");
                            task.run();
                        } finally {
                            System.out.println("run thread : "  + "before endGate.countDown()");
                            endGate.countDown();
                        }
                    } catch (InterruptedException ignored) {
                    }
                }
            };
            t.start();
        }

        Thread.sleep(500);
        long start = System.nanoTime();
        System.out.println("main : "+ "before startGate.countDown()");
        startGate.countDown();
        endGate.await();
        System.out.println("all finished");
        long end = System.nanoTime();
        return end - start;
    }
}
