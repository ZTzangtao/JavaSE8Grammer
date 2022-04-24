package Stream;

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
    }

    /**
     * filter
     */
    public static void filter(){
        List<String> strings = Arrays.asList("abc","","bc","efg","abcd","","jkl");
        List<String> filterList = strings.stream().filter(str -> str.contains("f")).collect(Collectors.toList());
        System.out.println(filterList);
    }

}
