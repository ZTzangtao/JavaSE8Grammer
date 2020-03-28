package OwnTest;

/**
 * 整数练习
 *
 * @author zangtao
 * @create 2019 - 09 -08 15:31
 */
public class IntegerTest {

    public static void main(String[] args) {
//        int i = 355;
//        int a = (i % 100) / 10;
//        //或者
//        int b = (i / 10) % 10;
//        System.out.println("该数的十位是:" + a);
//        System.out.println("该数的十位是:" + b);
//
//        Integer aa = 3;
//        Integer bb = 3;
//        Integer cc = 273;
//        Integer dd = 273;
//        System.out.println(aa.equals(bb));
//        System.out.println(cc.equals(dd));
//        System.out.println(aa == bb);
//        System.out.println(cc == dd);
        int i =1;
        int j = i++;
        if ((j> ++j) && (i++ == j)){
            j+= i;
        }
        System.out.println(j);


    }
}
