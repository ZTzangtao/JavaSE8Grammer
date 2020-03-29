package leetCode.IntegerReverse;

/**
 * @author zangtao
 * @date 2020/3/29 9:58
 */
public class IntegerReverse {

    /**
     * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
     *
     * 示例 1:
     *
     * 输入: 123
     * 输出: 321
     *  示例 2:
     *
     * 输入: -123
     * 输出: -321
     * 示例 3:
     *
     * 输入: 120
     * 输出: 21
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/reverse-integer
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param x
     * @return
     */
    public int reverse(int x) {
        if (x == Integer.MIN_VALUE){
            return 0;
        }
        int neg = x < 0 ? -1 : 1;
        x *= neg;
        int ret = 0;
        while (x > 0){
            int n = ret;
            n *= 10;
            n += x% 10;
            x /= 10;
            if (n / 10 != ret){
                return 0;
            }
            ret = n;
        }
        return ret * neg;

    }

    public static void main(String[] args) {
        IntegerReverse integerReverse = new IntegerReverse();
        System.out.println(integerReverse.reverse(-1534236469));
    }

}
