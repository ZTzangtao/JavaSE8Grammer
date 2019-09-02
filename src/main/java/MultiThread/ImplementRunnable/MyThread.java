package MultiThread.ImplementRunnable;

/**
 * 实现runnable接口的方式
 *
 * @author zangtao
 * @create 2019 - 09 -02 18:10
 */
public class MyThread implements Runnable {

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.run();
        System.out.println("main方法里面的");
    }

    @Override
    public void run() {
        System.out.println("实现接口的方式");
    }
}
