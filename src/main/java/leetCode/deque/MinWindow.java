package leetCode.deque;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @Author Tommy
 * @Date 2021/1/11 10:35 PM
 * @Version 1.0
 */
public class MinWindow {

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC","ABC"));
    }


    /**
     * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
     *
     * 注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：s = "ADOBECODEBANC", t = "ABC"
     * 输出："BANC"
     * 示例 2：
     *
     * 输入：s = "a", t = "a"
     * 输出："a"
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/minimum-window-substring
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     */
    static Map<Character,Integer> ori = new HashMap<>();

    static Map<Character,Integer> cnt = new HashMap<>();



    public static String minWindow(String s, String t) {

        int tLen = t.length();
        for(int i = 0; i<tLen; i++){
            char c = t.charAt(i);
            ori.put(c,ori.getOrDefault(c,0) + 1);
        }

        int l = 0, r = -1;
        int len = Integer.MAX_VALUE, ansL = -1, ansR = -1;

        int sLen = s.length();

        while(r < sLen){
            ++r;
            if(r< sLen && ori.containsKey(s.charAt(r))){
                cnt.put(s.charAt(r),cnt.getOrDefault(s.charAt(r),0) + 1);
            }
            while(check() && 1 <= r){
                if(r-l+1 <len){
                    len = r-l+1;
                    ansL = l;
                    ansR = l + len;
                }
                if(ori.containsKey(s.charAt(l))){
                    cnt.put(s.charAt(l),cnt.getOrDefault(s.charAt(l),0) - 1);
                }
                ++l;
            }

        }
    return ansL == -1 ? "" : s.substring(ansL,ansR);

    }

    private static boolean check() {
        Iterator iter = ori.entrySet().iterator();
        while (iter.hasNext()){
            Map.Entry entry = (Map.Entry) iter.next();
            Character key = (Character) entry.getKey();
            Integer val = (Integer) entry.getValue();

            if (cnt.getOrDefault(key,0) < val){
                return false;
            }
        }
        return true;
    }


}
