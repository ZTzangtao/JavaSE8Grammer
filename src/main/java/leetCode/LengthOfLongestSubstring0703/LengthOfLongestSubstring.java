package leetCode.LengthOfLongestSubstring0703;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * @author zangtao
 * @create 2019 - 07 -03 10:23
 */
public class LengthOfLongestSubstring {

    /**
     * abcabcbb 3   bbbb 1   pwwkew 3
     * <p>
     * 逐个检查所有的子字符串，看它是否不含有重复的字符。
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        //对s的判断
        if (s.length() < 1 || " ".equals(s)) {
            return 0;
        }

        List<String> strlist = new ArrayList<>();

        for (int i = 0; i < s.length() - 1; i++) {


        }


        return 0;
    }

    public static void main(String[] args) {
        String s = "dsjkhjhf";

        String ss = String.valueOf(s.charAt(s.length() - 1));

        System.out.println(ss);
    }

}
