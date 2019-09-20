package leetCode.MutiThread20190831;

import java.util.concurrent.CountDownLatch;

/**
 * 按序打印
 *
 * @author zangtao
 * @create 2019 - 08 -31 16:45
 * <p>
 * 三个不同的线程将会共用一个 Foo 实例。
 * <p>
 * 线程 A 将会调用 one() 方法
 * 线程 B 将会调用 two() 方法
 * 线程 C 将会调用 three() 方法
 * 请设计修改程序，以确保 two() 方法在 one() 方法之后被执行，three() 方法在 two() 方法之后被执行。
 */
public class Foo {

    private CountDownLatch second = new CountDownLatch(1);

    private CountDownLatch third = new CountDownLatch(1);

    public Foo() {

    }

    /**
     * first 线程会释放 first 屏障，而 second 线程会释放 second 屏障。
     * <p>
     * Java 中，我们使用线程等待的方式实现执行屏障，使用释放线程等待的方式实现屏障消除。具体代码如下：
     *
     * @param printFirst
     * @throws InterruptedException
     */
    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        second.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        second.await();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        third.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
        third.await();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }

}



