package OwnTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zangtao
 * @date 2019/12/30 9:29
 */
public class TheNumberOfNarcissusAlgorithm {
    /**
     * 水仙花数算法
      * @param args
     */
    public static void main(String[] args) {
        int i = 100,single,ten,hundred;
        List<Integer> list = new ArrayList<>();
        while (i <= 999){
             //个位  原数模上10
              single = i%10;
             //十位
              ten = i%100/10;
             //百位
              hundred = i / 100;
              if (Math.pow(single,3) + Math.pow(ten,3) + Math.pow(hundred,3) == i){
                         list.add(i);
                         i++;
              }else {
                  i++;
              }
        }
        list.forEach(System.out::println);
    }

}
