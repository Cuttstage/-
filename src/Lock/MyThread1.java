package Lock;

public class MyThread1 extends Thread {
    @Override
    public void run() {
        synchronized (DeadLock.lock1) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (DeadLock.lock2) {

            }
        }
    }
}
