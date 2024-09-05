package staticUtil;

import java.util.concurrent.locks.*;

public class DeadLock {

    
    private static Lock A = new ReentrantLock();
    private static Lock B = new ReentrantLock();

    public static void Deadlock() {

        new Thread(() -> {
            try {
                A.lock();
                Thread.sleep(5000);
                B.lock();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                A.unlock();
                B.unlock();
            }
            System.out.println("Thread A and B locks");
        }).start();

    
        new Thread(() -> {
            try {
                B.lock();
                Thread.sleep(3000);
                A.lock();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                B.unlock();
                A.unlock();
            }
            System.out.println("Thread A and B locks");
        }).start();
    }
}
