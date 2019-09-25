package thread;

/**
 * 接口runnable写法的测试
 */
public class ThreadRunnable implements Runnable {
    private static int num = 0;

    @Override
    public void run() {
        while (num < 100) {
            synchronized (ThreadRunnable.class) {
                System.out.println(num);
                num++;
            }
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new ThreadRunnable());
        thread.start();
    }
}
