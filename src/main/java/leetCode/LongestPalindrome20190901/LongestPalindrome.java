package leetCode.LongestPalindrome20190901;

/**
 * 最长的回文子串
 *
 * @author zangtao
 * @create 2019 - 09 -01 17:59
 */
public class LongestPalindrome {


    public static void main(String[] args) {
        System.out.println(longestPalindrome("abajkdfhgsjkdfhbcbcbgiudfhgisdhf"));
    }

    /**
     * 暴力解法
     *
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        String ans = "";
        int max = 0;
        int len = s.length();
        String test;
        for (int i = 0; i < len; i++) {
            //挨个遍历
            for (int j = i + 1; j <= len; j++) {
                test = s.substring(i, j);
                if (isPalindromic(test) && test.length() > max) {
                    ans = s.substring(i, j);
                    max = Math.max(max, ans.length());
                }
            }
        }
        return ans;

    }

    /**
     * 判断字符串是否是回文
     *
     * @param s
     * @return
     */
    private static boolean isPalindromic(String s) {
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
