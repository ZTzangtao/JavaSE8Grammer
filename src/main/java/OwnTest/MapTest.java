package OwnTest;

import java.util.HashMap;
import java.util.Iterator;
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

        //不建议这样使用
        for (String key : map.keySet()) {
            System.out.println(key + map.get(key));
        }
        //lambda遍历map （推荐）
        map.forEach((key, value) -> System.out.println(key + "," + value));

        Iterator map1it = map.entrySet().iterator();
        while (map1it.hasNext()) {
            Map.Entry<String, String> entry = (Map.Entry<String, String>) map1it.next();
            System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());
        }

        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());
        }
    }

}
