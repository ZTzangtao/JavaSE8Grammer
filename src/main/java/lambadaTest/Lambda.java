package lambadaTest;

import java.util.*;

/**
 * @author zangtao
 */
public class Lambda {

    public static void main(String[] args) {
        String[] atp = {"Rafael", "Novak", "Stanislas", "David", "Roger", "Andy","Tomas", "Juan"};
        List<String> players =  Arrays.asList(atp);
        // 增强for循环
        for (String player : players) {
            System.out.print(player + "; ");
        }
        // 使用 lambda 表达式以及函数操作(functional operation)
        players.forEach((player) -> System.out.println(player + "; "));
        // 在 Java 8 中使用双冒号操作符(double colon operator)
        players.forEach(System.out::println);
        //map和set本身是无顺序的
        Map<String,String> map = new HashMap<>(1);
        map.put("test","map");
        map.put("lambda","stimulate");
        map.put("just","do!");
        map.forEach((k,v)->{
            if (k.equals("test")){
                map.put("test","map1");
            }
            System.out.println(k);
            System.out.println(v);
        });

        map.forEach((k,v)->{
            System.out.println(k);
            System.out.println(v);
        });

        Set<String> set = new HashSet<>();
        set.add("just");
        set.add("do");
        set.add("it~~~~~~");
        set.forEach(System.out::println);
    }

}
