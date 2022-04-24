package Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: Tommy
 * @DATE: 2022/4/24
 */
public class Java8StreamTest {

    public static void main(String[] args) {
        filter();
        distinct();
    }

    /**
     * filter
     *
     * 过滤集合中不符合条件的元素
     */
    public static void filter(){
        List<String> strings = Arrays.asList("abc","","bc","efg","abcd","","jkl");
        List<String> filterList = strings.stream().filter(str -> str.contains("f")).collect(Collectors.toList());
        System.out.println(filterList);
    }

    /**
     * distinct
     *
     * 返回一个元素各异（根据流所生成元素的hashCode和equals方法实现）的流
     */
    public static void distinct(){
        List<String> strings = Arrays.asList("abc","","bc","efg","abcd","","jkl");
        List<String> filterList = strings.stream().distinct().collect(Collectors.toList());
        System.out.println(filterList);
        //-------------------------------------------------------
        List<User> users = new ArrayList<>();
        users.add(new User(1,"z"));
        users.add(new User(1,"z"));
        users.add(new User(2,"s"));
        List<User> usersList = users.stream().distinct().collect(Collectors.toList());
        System.out.println(usersList);

    }

}
