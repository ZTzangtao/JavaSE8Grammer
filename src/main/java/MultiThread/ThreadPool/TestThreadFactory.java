package MultiThread.ThreadPool;

import java.util.concurrent.*;

/**
 * @author zangtao
 * @date 2020/4/16 9:02
 */
public class TestThreadFactory {

    public static void main(String[] args) {

        //创建线程（并发）池，自动伸缩(自动条件线程池大小)
//        ExecutorService es =  Executors.newCachedThreadPool(new MyThreadFactory());
        ExecutorService es = new ThreadPoolExecutor(
                0,
                Integer.MAX_VALUE,
                60L,
                TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>(),
                new MyThreadFactory());

        //同时并发5个工作线程
        es.execute(new WorkRunnable());
        es.execute(new WorkRunnable());
        es.execute(new WorkRunnable());
        es.execute(new WorkRunnable());
        es.execute(new WorkRunnable());
        //指示当所有线程执行完毕后关闭线程池和工作线程，如果不调用此方法，jvm不会自动关闭
        es.shutdown();

        try {
            //等待线程执行完毕，不能超过2*60秒，配合shutDown
            es.awaitTermination(2*60, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

}
