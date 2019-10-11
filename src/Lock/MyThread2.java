package Lock;

public class MyThread2 extends Thread {
    @Override
    public void run() {
        synchronized (DeadLock.lock2) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (DeadLock.lock1) {

            }
        }
    }
}
