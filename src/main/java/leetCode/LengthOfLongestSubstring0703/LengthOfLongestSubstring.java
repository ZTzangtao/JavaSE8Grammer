package leetCode.LengthOfLongestSubstring0703;

import java.util.Arrays;
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
    public static int lengthOfLongestSubstring(String s) {
        //过滤
        if (s.length() < 1) {
            return 0;
        }

        if (s.equals(" ")) {
            return 1;
        }
        //初始化数组
        String[] strNum = new String[s.length()];
        //初始化结果
        int result = 0;
        //初始化单个字符串
        String singleStr = null;

        List<String> strList = null;

        String[] strNum2 = null;

        //暴力循环从左往右
        for (int i = 0; i < s.length(); i++) {

            if (i + 1 <= s.length()) {
                singleStr = s.substring(i, i + 1);
            } else {
                break;
            }
            //转list
            strList = Arrays.asList(strNum);

            if (!strList.equals(singleStr)) {
                strNum[i] = singleStr;
            } else {
                //记录一下个数
                if (strList.size() > result) {
                    result = strList.size();
                }

                int index = getIndex(strNum, singleStr);

                strNum2 = new String[s.length()];

                System.arraycopy(strNum, index + 1, strNum2, 3, 3);

//                strlist.add(singleStr);

//            }
            }

        }
        return 0;
    }

    /**
     * 数组求索引
     *
     * @param arr
     * @param value
     * @return
     */
    public static int getIndex(String[] arr, String value) {

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        //如果未找到返回-1
        return -1;
    }


    public static void main(String[] args) {
        String s = "dvsdfr";
        s = s.substring(6, 7);
        System.out.println(s);
//        System.out.println(lengthOfLongestSubstring( s ) );
    }

}
