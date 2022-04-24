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
}
