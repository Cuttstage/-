package synchron;

/**
 * synchronized锁对应的对象测试
 */
public class SynchronizedExample1 {
    public void func() {
        synchronized (this) {
            for (int i = 0; i < 100; i++) {
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {

    }
}
