package OwnTest;

import org.junit.jupiter.api.Test;

/**
 * @author zangtao
 * @date 2020/4/18 23:53
 */
public class BitAndModulus {

    @Test
    public void bit(){
        int number = 547373634;
        int a = 564534734;
        long start = System.currentTimeMillis();
        for (int i = number;i>0; i++){
            a = a & i;
//            System.out.println("a:"+a);
        }
        long end = System.currentTimeMillis();
        System.out.println("耗费时间："+(end-start));
    }

    @Test
    public void modulus(){
        int number = 1000 * 10;
        int a = 1;
        long start = System.currentTimeMillis();
        for (int i = number;i>0; i++){
            a %= i;
        }
        long end = System.currentTimeMillis();
        System.out.println("耗费时间："+(end-start));
    }


}
