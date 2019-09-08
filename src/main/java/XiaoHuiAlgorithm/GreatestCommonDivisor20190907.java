package XiaoHuiAlgorithm;

/**
 * 获取最大公约数
 *
 * @author zangtao
 * @create 2019 - 09 -07 18:03
 */
public class GreatestCommonDivisor20190907 {

    public static void main(String[] args) {
        System.out.println(gcd(100, 80));
    }

    public static int gcd(int a, int b) {
        if (a == b) {
            return a;
        }
        if ((a & 1) == 0 && (b & 1) == 0) {
            return gcd(a >> 1, b >> 1) << 1;
        } else if ((a & 1) == 0 && (b & 1) != 0) {
            return gcd(a >> 1, b);
        } else if ((a & 1) != 0 && (b & 1) == 0) {
            return gcd(a, b >> 1);
        } else {
            int big = a > b ? a : b;
            int small = a < b ? a : b;
            return gcd(big - small, small);
        }
    }

}
