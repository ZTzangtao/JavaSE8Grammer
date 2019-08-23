package leetCode.LengthOfLongestSubstring0703;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * @author zangtao
 * @create 2019 - 07 -03 10:23
 */
public class LengthOfLongestSubstring {

    /**
     * 测试输出
     *
     * @param args
     */
    public static void main(String[] args) {
        String s = "dvsdfr";
//        System.out.println(lengthOfLongestSubstring(s));
//
//        s = "bbbbb";
//        System.out.println(lengthOfLongestSubstring(s));

        s = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s));

//        s = "";
//        System.out.println(lengthOfLongestSubstring(s));
//
//        s = " ";
//        System.out.println(lengthOfLongestSubstring(s));

    }

    /**
     * abcabcbb 3   bbbb 1   pwwkew 3
     *
     * 逐个检查所有的子字符串，看它是否不含有重复的字符。
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        //存无序不重复的集合
        Set<Character> set = new HashSet<>();
        int ans = 0;
        int i = 0;
        int j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;

    }

    /**
     * 判断一段字符串是否有重复
     *
     * @param s
     * @param start
     * @param end
     * @return
     */
//    public static boolean allUnique(String s, int start, int end) {
//        Set<Character> set = new HashSet<>();
//        for (int i = start; i < end; i++) {
//            Character ch = s.charAt(i);
//            if (set.contains(ch)){
//                return false;
//            }
//            set.add(ch);
//        }
//        return true;
//    }



}
