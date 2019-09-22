package OwnTest;

import java.util.ArrayList;
import java.util.List;

/**
 * 集合练习
 *
 * @author zangtao
 * @create 2019 - 09 -22 19:18
 */
public class ListTest {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        for (String item : list) {
            if ("2".equals(item)) {
                list.remove(item);
            }
        }
        list.forEach(System.out::println);
    }
}
