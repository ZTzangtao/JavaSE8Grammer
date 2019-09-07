package OwnTest;

/**
 * 字符串练习
 *
 * @author zangtao
 * @create 2019 - 09 -06 17:07
 */
public class StringTest {

    public static void main(String[] args) {
//        String str1 = "string" + 1 + 1;
//
//        String str2 = 1 + 1 + "string";
//
//        System.out.println( str2 );
        try {
            System.out.println(getByBit(5, 3));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static int getByBit(int targetNum, int bitNum) {
        return targetNum >> (bitNum - 1) & 1;
    }


}
