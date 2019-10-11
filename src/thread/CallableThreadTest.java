package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableThreadTest implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
        return 10;
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        CallableThreadTest callableThreadTest = new CallableThreadTest();
        FutureTask<Integer> futureTask = new FutureTask<>(callableThreadTest);

        Thread thread = new Thread(futureTask);
        thread.start();
//        Thread.sleep(1000);
        System.out.println(futureTask.get());
    }
}
