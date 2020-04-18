package MultiThread.concurrentTest;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author zangtao
 * @date 2020/4/18 20:25
 */
public class VolitailAtomicTest {

    public static volatile int num = 0;

    public static void increase(){
        num ++;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[10];
        for(int i = 0;i<threads.length; i++){
            threads[i] = new Thread(()->{
              for (int j = 0; j< 1000; j++){
                  increase();
              }
            });
        threads[i].start();
        }

        for (Thread t : threads){
            t.join();
        }
        System.out.println(num);
    }
}
