package MultiThread.ThreadExtendsMethod;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * 多线程练习
 *
 * @author zangtao
 * @create 2019 - 08 -30 18:38
 */
public class TestMutiThread extends Thread {
    private int count = 10;

    @Override
    public void run() {
        while (true) {
            // 打印 Count 变量
            System.out.println(count + "");
            // 使count 变量 自减 ，当自减为0时，退出循环
            if (--count == 0) {
                return;
            }
        }
    }

    public static void main(String[] args) {
        Supplier<String> i = ()-> "Car";
        Consumer<String> c = x-> System.out.print(x.toLowerCase());
        Consumer<String> d = x-> System.out.print(x.toUpperCase());
        c.andThen(d).accept(i.get());
        System.out.println();
//        Integer x = 3;
//        Integer y = null;
//        try {
//            System.out.println(Integer.compareUnsigned(x,3) == 0 || Integer.compareUnsigned(y,0) == 0);
//        }catch (Exception ex){
//            System.out.println(ex.getClass().toString());
//        }
//
//        try{
//            System.out.println(y.compareTo(null)== 0 || true);
//        }catch (Exception ex){
//            System.out.println(ex.getClass().toString());
//        }



//        new TestMutiThread().start();

//        BufferedReader in = new BufferedReader(new InputStreamReader("zzz"));
//        BufferedReader inss = new BufferedReader("");
//        BufferedReader insss = new BufferedReader(new File("dd"));
//        BufferedReader ins = new BufferedReader(new FileReader("zzz"));
//        FileReader input = new FileReader("");

//        Set<String> set = new LinkedHashSet<>();
//        set.add("3");
//        set.add("1");
//        set.add("3");
//        set.add("2");
//        set.add("3");
//        set.add("1");
//        set.forEach(s-> System.out.print(s+"-"));


//        List<String> list = Arrays.asList("dog","over","good");
//        System.out.println(list.stream()
//                .reduce(new String(), (s1,s2) -> s1 + s2.charAt(0),(c1,c2) -> c1 += c2));

//        System.out.println(list.stream()
//                .reduce(new Character(), (Character s1,s2) -> s1 + s2.charAt(0),(c1,c2) -> c1 += c2));
//        list.stream().reduce((x1,x2) -> x1.length() > x2.length() ? x1 :x2).ifPresent(System.out::println);
//        list.stream().reduce((x1,x2) -> x1.length() ==3?  x1 :x2).ifPresent(System.out::println);
//
//        System.out.println(
//                list.stream().reduce(new String(), (x1,x2) -> {if (x1.equals("dog")) return x1; return x2; })
//        );

//        ResourceBundle bundle = ResourceBundle.getBundle("Messages", new Locale("zh", "CN"));

    }


}
