package interview;

/**
 * @Author Tommy
 * @Date 2023/12/30 16:41
 * @Version 1.0
 */
public class AlternatePrintNumber {

    public static void main(String[] args) {
        PrintClass printClass = new PrintClass();

        Thread t1 = new Thread(printClass);
        Thread t2 = new Thread(printClass);
       t1.setName("A: ");
       t2.setName("B: ");
       t1.start();
       t2.start();
    }

}


class PrintClass implements Runnable {
    static int i = 0;
    static final int n = 100;
    @Override
    public void run() {
        synchronized (this) {
            while(i <= n) {
                System.out.println(Thread.currentThread().getName() + i++);
                notify();
                try {
                    Thread.sleep(5);
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}