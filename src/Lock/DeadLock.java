package Lock;

public class DeadLock {
    public static Object lock1 = 0;
    public static Object lock2 = 0;

    public static void main(String[] args) {
        MyThread1 myThread1 = new MyThread1();
        MyThread2 myThread2 = new MyThread2();

        myThread1.start();
        myThread2.start();
    }


}
