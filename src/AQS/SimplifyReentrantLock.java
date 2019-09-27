package AQS;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 重写lock
 */
public class SimplifyReentrantLock implements Lock {

    private final Sync sync = new Sync();

    /**
     * AQS的子类Sync
     * ASQ框架，内部为实现对应的锁机制，而reentlock就是从AQS的子类，利用的师一个QUEUE来实现公平锁
     */
    private static class Sync extends AbstractQueuedSynchronizer {

        @Override
        protected boolean isHeldExclusively() {
            //是否处于占用状态
            return getState() == 1;
        }

        @Override
        protected boolean tryAcquire(int arg) {
            //当状态为0是获取锁
            //unsafe中的方法，直接操作内存，将比较和设置同时设置下来
            if (compareAndSetState(0, 1)) {
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        @Override
        protected boolean tryRelease(int arg) {
            //释放锁，将状态设置为0
            if (getState() == 0) {
                throw new IllegalMonitorStateException();
            }
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }

        Condition newCondition() {
            return new ConditionObject();
        }

    }

    @Override
    public void lock() { sync.acquire(1); }

    @Override
    public void unlock() { sync.release(1); }

    @Override
    public Condition newCondition() { return sync.newCondition(); }

    @Override
    public boolean tryLock() { return sync.tryAcquire(1); }

    @Override
    public void lockInterruptibly() throws InterruptedException { }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }
}
