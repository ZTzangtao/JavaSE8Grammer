package HW_Test;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @Author Tommy
 * @Date 2022/2/20 5:00 PM
 * @Version 1.0
 */
public class mutiArray {

    //3-3-3-3-4-4-5-5-6-7-8-9-10-J-Q-K-A
    //4-5-6-7-8-8-8


    public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            while (in.hasNextLine()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
                String handCard = in.nextLine();
                String outCard = in.nextLine();
                if(handCard == null || outCard == null){
                    return;
                }
                String[] handCardArray = handCard.split("-");
                String[] outCardArray = outCard.split("-");


                Set<String> handSet = new HashSet<>();
                for(int i = 0; i < handCardArray.length; i++){
                    handSet.add(handCardArray[i]);
                }

                Set<String> outSet = new HashSet<>();
                for(int i = 0; i < outCardArray.length; i++){
                    outSet.add(outCardArray[i]);
                }



            }
        }

//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        while (in.hasNextLine()) {
//            String str = in.nextLine();
//            int s = str.length();
//            char[] strArray = str.toCharArray();//wfew
//            char s1 = strArray[0];
//            char s2 = strArray[1];
//
//        }
//    }


    public static boolean isSxhNum(int i){
            int a = i % 10;
            int b = i / 100;
            int c = i % 100 / 10;
            return i == (a * a * a) + (b * b * b) + (c * c * c);
        }



        // private final static int BASE = 16;
    //  private static Map<Character, Integer> map = new HashMap<Character, Integer>(){
    //        {
    //            put('0', 0);
    //            put('1', 1);
    //            put('2', 2);
    //            put('3', 3);
    //            put('4', 4);
    //            put('5', 5);
    //            put('6', 6);
    //            put('7', 7);
    //            put('8', 8);
    //            put('9', 9);
    //            put('a', 10);
    //            put('b', 11);
    //            put('c', 12);
    //            put('d', 13);
    //            put('e', 14);
    //            put('f', 15);
    //            put('A', 10);
    //            put('B', 11);
    //             put('C', 12);
    //            put('D', 13);
    //            put('E', 14);
    //            put('F', 15);
    //
    //        }
    //    };
    //    public static int getDecimal(String number) {
    //        int res = 0;
    //        for (char ch : number.toCharArray()) {
    //            res = res * BASE + map.get(ch);
    //        }
    //        return res;
    //    }
    //
    //    public static void main(String[] args) {
    //        Scanner in = new Scanner(System.in);
    //        // 注意 hasNext 和 hasNextLine 的区别
    //        while (in.hasNextInt()) { // 注意 while 处理多个 case
    //            String s = in.nextLine();
    //            int res = getDecimal(s.substring(2));
    //            System.out.println(res);
    //        }
    //    }
}
