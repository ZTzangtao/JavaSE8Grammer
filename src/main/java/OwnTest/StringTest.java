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

//            System.out.println(getByBit(5, 3));
        //~60的源码是 1100 0011
        //~60的补码是 1011 1101   （等于-61）
        System.out.println(~60);
        String str = "a,b,c,,";
        String[] ary = str.split(",");
        System.out.println(ary.length);
        method(null);

    }

    private static void method(String param) {
        switch (param) {
            // 肯定不是进入这里
            case "sth":
                System.out.println("it's sth");
                break;
            // 也不是进入这里
            case "null":
                System.out.println("it's null");
                break;
            // 也不是进入这里
            default:
                System.out.println("default");
        }

    }

    /**
     * 求二进制下标是0还是1
     *
     * @param targetNum 目标整数
     * @param bitNum    下标位数
     * @return
     */
    private static int getByBit(int targetNum, int bitNum) {
        //按位右移运算bitNum个位置
        //之后和0000 00001 比较第0位，相同则是1，不同则是0
        return targetNum >> (bitNum - 1) & 1;
    }


}
