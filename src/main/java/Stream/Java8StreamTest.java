package Stream;

import java.text.Collator;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author: Tommy
 * @DATE: 2022/4/24
 */
public class Java8StreamTest {

    public static void main(String[] args) {
        map2FlatMap();
    }

    /**
     * sorted
     *
     * 排序 默认是从小到大排序
     */
    public static void sorted(){
        List<String> strings = Arrays.asList("abc","","bc","efg","abcd","","jkl");
        List<String> mapList = strings.stream().sorted().collect(Collectors.toList());
        System.out.println(mapList);
        //-----------------汉字排序---------------------------------
        List<String> strings2 = Arrays.asList("你好","张三","李四","王五","阿萨","的是","去么");
        List<String> mapList1 = strings2.stream().sorted(Collections.reverseOrder(Collator.getInstance(Locale.CHINA))).collect(Collectors.toList());
        System.out.println(mapList1);

    }


    /**
     * map
     *
     * 对流中所有元素做统一处理
     */
    public static void map(){
        List<String> strings = Arrays.asList("abc","","bc","efg","abcd","","jkl");
        List<String> mapList = strings.stream().map(c -> c.concat("_zz") ).collect(Collectors.toList());
        System.out.println(mapList);
    }

    /**
     * flatMap  流的扁平化处理
     *
     * 使用flatMap方法的效果是: 各个数组并不是分别映射成一个流，而是映射成流的内容。
     * 所使用的map(Arrays::stream)时生成的单个流都被合并起来，即扁平化为一个流。
     */
    public static void flatMap(){
        List<String> strings = Arrays.asList("abc","","bc","efg","abcd","","jkl");
        List<Character> flatMapList = strings.stream().flatMap(c -> Java8StreamTest.getCharacterByString(c)).collect(Collectors.toList());
        System.out.println(flatMapList);
    }

    public static void map2FlatMap(){
        List<String> string1 = Arrays.asList("abc","","bc","efg","abcd","","jkl");
        Stream<Character> flatMapped = string1.stream().flatMap(c -> Java8StreamTest.getCharacterByString(c));
        // 解析： flatMap
        //1、先是 [a,b,c]的流，然后[b,c]
        //2、扁平化，变成一个 [a,b,c,b...k,l] 扁平化操作
        flatMapped.forEach(c-> System.out.print(c));

        List<String> string2 = Arrays.asList("abc","","bc","efg","abcd","","jkl");
        Stream<Stream<Character>> mapped = string2.stream().map(Java8StreamTest::getCharacterByString);
        mapped.forEach(c-> c.forEach(s-> System.out.println(s)));
    }


    public static Stream<Character> getCharacterByString(String str){
        List<Character> characterList = new ArrayList<>();
        for(Character character : str.toCharArray()){
            characterList.add(character);
        }
        return characterList.stream();
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

    /**
     * limit 取前几个
     *
     * longer than maxSize in length.
     */
    public static void limit(){
        List<String> strings = Arrays.asList("abc","","bc","efg","abcd","","jkl");
        List<String> limitList = strings.stream().limit(2).collect(Collectors.toList());
        System.out.println(limitList);
    }

    /**
     * skip 过滤掉流中的前n个
     *
     * n – the number of leading elements to skip
     */
    public static void skip(){
        List<String> strings = Arrays.asList("abc","","bc","efg","abcd","","jkl");
        List<String> skipList = strings.stream().skip(2).collect(Collectors.toList());
        System.out.println(skipList);
    }
}
