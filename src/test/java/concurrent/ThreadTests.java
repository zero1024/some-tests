package concurrent;

import org.junit.Test;

public class ThreadTests {

    @Test
    public void testInterruptOnWait() throws InterruptedException {

        var lock = new Object();

        var thread1 = new Thread(() -> {
            System.out.println("Before the lock");
            synchronized (lock) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    System.out.println("Interrupt");
                }
            }
            System.out.println("After the lock");
        });
        thread1.start();

        Thread.sleep(5000);
//        synchronized (lock) {
//            lock.notify();
//        }
        thread1.interrupt();
        Thread.sleep(1000);

    }


}
