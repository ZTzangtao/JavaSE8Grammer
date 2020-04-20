package OwnTest.hashMap;

/**
 * @author zangtao
 * @date 2020/4/19 0:16
 */
public class MapDeadLock {

    public static void main(String[] args) {
        for(int i = 0;i<10;i++){
            new Thread(new DevThread()).start();
        }
    }
}
