package MultiThread.Test;

/**
 * @Author: Tommy
 * @DATE: 2022/9/7
 * @Description: 一个线程打印字母，一个线程打印数字，控制台依次输出 A1 B2 C3 ...... Z26
 */
public class AlternatePrint {

    public static void main(String[] args) {
        // 互斥体
        final Object mutex = new Object();

        //字母线程
        Thread alphabet = new Thread(new Runnable() {
            @Override
            public void run() {
                // 依次打印字母 A-Z
                for (int i = 65; i <= 90; i++) {
                    try {
                        synchronized (mutex) {
                            System.out.print((char) i);
                            // 线程唤醒
                            mutex.notify();
                            // 线程等待
                            mutex.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                synchronized (mutex) {
                    mutex.notify();
                }
            }
        });
        // 数字线程
        Thread digit = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 26; i++) {
                    try {
                        synchronized (mutex) {
                            System.out.print(i + " ");
                            // 线程唤醒
                            mutex.notify();
                            // 线程等待
                            mutex.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        alphabet.start();
        digit.start();
    }

}
