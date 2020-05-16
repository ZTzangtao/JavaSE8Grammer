package leetCode.z_convert;

/**
 * 将字符串里面的数字转成int类型
 *
 *  DFA算法
 */
public class Atoi {

    public static void main(String[] args) {

        System.out.println(myAtoi("djhsd54645ndvsv"));

    }

    public static int myAtoi(String str) {
        str = str.trim();

        if("".equals(str)){
            return 0;
        }

        if (!Character.isDigit(str.charAt(0))
                && str.charAt(0)!= '-' && str.charAt(0) != '+' ){
            return 0;
        }
        long ans = 0L;
        boolean neg = str.charAt(0) == '-';
        int i = !Character.isDigit(str.charAt(0)) ? 1 : 0;
        while(i < str.length() && Character.isDigit(str.charAt(i)) ){
            ans = ans * 10 + (str.charAt(i++) - '0');
            if (!neg && ans > Integer.MAX_VALUE){
                ans = Integer.MAX_VALUE;
                break;
            }

            if (neg && ans > 1L + Integer.MAX_VALUE){
                ans = 1L + Integer.MAX_VALUE;
                break;
            }

        }


        return neg ? (int) -ans : (int) ans;
    }


}
