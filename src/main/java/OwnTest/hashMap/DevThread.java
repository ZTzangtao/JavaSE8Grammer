package OwnTest.hashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zangtao
 * 查看Hashmap多线程情况下死锁
 *
 * @date 2020/4/19 0:12
 */
public class DevThread implements Runnable {

    private static Map<Integer,Integer> map = new HashMap<>(2);
    private static AtomicInteger atomicInteger = new AtomicInteger();

    @Override
    public void run() {
        while (atomicInteger.get() < 10000000){
            map.put(atomicInteger.get(),atomicInteger.get());
            atomicInteger.incrementAndGet();
        }
    }
}
