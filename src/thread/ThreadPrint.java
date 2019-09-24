package thread;

/**
 * 多线程轮流打印
 * 一对应的volatile变量来控制对应的线程顺序
 */
public class ThreadPrint {
    private volatile int i = 0;
    private Thread thread1, thread2, thread3;
    private volatile int flag = 0;

    public class Thread1 implements Runnable{
        @Override
        public void run() {
            while (i < 100) {
                if (flag == 0) {
                    System.out.println(this.getClass().getName()+": "+i);
                    i++;
                    flag = 1;
                }
            }
        }
    }

    public class Thread2 implements Runnable{
        @Override
        public void run() {
            while (i < 100) {
                if (flag == 1) {
                    System.out.println(this.getClass().getName()+": "+i);
                    i++;
                    flag = 2;
                }
            }
        }
    }

    public class Thread3 implements Runnable{
        @Override
        public void run() {
            while (i < 100) {
                if (flag == 2) {
                    System.out.println(this.getClass().getName()+": "+i);
                    i++;
                    flag = 0;
                }
            }
        }
    }

    public void runThread() {
        thread1 = new Thread(new Thread1());
        thread2 = new Thread(new Thread2());
        thread3 = new Thread(new Thread3());

        thread1.start();;
        thread2.start();
        thread3.start();
    }



}
