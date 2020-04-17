package MultiThread.ThreadPool;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zangtao
 * @date 2020/4/16 8:45
 */
public class MyThreadFactory implements ThreadFactory {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    @Override
    public Thread newThread(Runnable r) {
        int c = atomicInteger.incrementAndGet();
        System.out.println("create no " + c + " Threads");
        //通过计数器，可以更好的管理线程
        return new WorkThread(r, atomicInteger);
    }
}
