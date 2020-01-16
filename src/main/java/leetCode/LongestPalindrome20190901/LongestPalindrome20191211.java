package leetCode.LongestPalindrome20190901;


/**
 * 回文最长字符串（动态规划）
 *
 * @author zangtao
 * @date 2019/12/11 8:24
 */
public class LongestPalindrome20191211 {

    public static String longestPalindrome(String s) {
        if ("".equals(s)){
            return "";
        }
        //原始字符串 origin
        String origin = s;
        //字符串反转 reverse
        String reverse = new StringBuilder(s).reverse().toString();
        //字符串长度 length
        int length = s.length();
        //创建二维数组
        int[][] arr = new int[length][length];
        //
        int maxLen = 0;
        int maxEnd = 0;
        for (int i = 0; i < length;i++){
            for (int j=0;j < length;j++){
                if (origin.charAt(i) == reverse.charAt(j)){
                    if (i==0 || j==0){
                        arr[i][j] = 1;
                    } else {
                        arr[i][j] = arr[i - 1][j - 1] + 1;
                    }
                }
                if (arr[i][j] > maxLen){
                    int beforeRev = length -1 -j;
                    //做个判断，下标是否对应
                    if (beforeRev + arr[i][j] - 1 == i){
                        maxLen = arr[i][j];
                        //以i位置
                        maxEnd = i;
                    }
                }
            }
        }
        return s.substring(maxEnd - maxLen + 1,maxEnd + 1);
    }

    public static void main(String[] args) {
         System.out.println(longestPalindrome("abc435cba"));
    }


}
