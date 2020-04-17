package MultiThread.ThreadPool;

/**
 * @author zangtao
 * @date 2020/4/16 9:01
 */
public class WorkRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("complete a task");
    }
}
