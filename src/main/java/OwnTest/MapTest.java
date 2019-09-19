package OwnTest;

import java.util.HashMap;
import java.util.Map;

/**
 * map遍历
 *
 * @author zangtao
 * @create 2019 - 09 -17 14:56
 */
public class MapTest {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>(1);
        map.put("1", "");
        map.put("", "1");
        map.put("qq", "ww");
        map.put("", "2");
        map.put("1", null);

//        for (String key : map.keySet()){
//            System.out.println(key+map.get(key));
//        }
        //lambda遍历map
        map.forEach((key, value) -> System.out.println(key + "," + value));

    }

}
