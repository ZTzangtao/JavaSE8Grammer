package leetCode.arrayAndString;


import java.util.Arrays;

/**
 * @author zangtao
 * @date 2020/4/9 8:36
 */
public class Anagram {
    public static void main(String[] args) {
        System.out.println(isAnagram("qxcxvvqweqwe","qxcxvvqweqwe"));
    }

    public static boolean isAnagram(String s ,String t){
        if(s.length() != t.length()){
            return false;
        }
        int[] count = new int[26];
        for (int i = 0; i< s.length();i++){
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        for (int i : count){
            if (i != 0){
                return false;
            }
        }

        return true;
    }

}
