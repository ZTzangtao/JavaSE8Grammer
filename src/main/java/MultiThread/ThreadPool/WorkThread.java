package MultiThread.ThreadPool;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zangtao
 * @date 2020/4/16 8:58
 */
public class WorkThread extends Thread {
    /**
     * 线程执行目标
     */
    private Runnable target;
    private AtomicInteger counter;

    public WorkThread(Runnable target, AtomicInteger counter) {
        this.target = target;
        this.counter = counter;
    }

    @Override
    public void run() {
        try {
            target.run();
        } finally {
            int c = counter.getAndDecrement();
            System.out.println("terminate no " + c + " Threads");
        }
    }
}
