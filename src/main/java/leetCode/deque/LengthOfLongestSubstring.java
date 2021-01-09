package leetCode.deque;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @Author Tommy
 * @Date 2021/1/9 10:46 PM
 * @Version 1.0
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

    /**
     * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
     *
     * 输入: "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }

        //初始化返回值
        int max = 0;
        //初始化队列
        Queue<Character> queue = new LinkedList<>();

        Set<Character> exist  = new HashSet<>();

        for (int i = 0; i<s.length();i++){
            char c = s.charAt(i);

            while(exist.contains(c)){
                exist.remove(queue.poll());
            }

            exist.add(c);

            queue.add(c);
            max = Math.max(queue.size(),max);

        }

        return max;
    }

}
