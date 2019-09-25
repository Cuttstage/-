package threadPool;

import thread.ThreadRunnable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 缓冲线程池写法测试
 */
public class CachedThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i=0; i<5; i++) {
            executorService.execute(new ThreadRunnable());
        }
        executorService.shutdown();
    }
}
