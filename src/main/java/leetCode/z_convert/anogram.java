package leetCode.z_convert;

public class anogram {

    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        int[] count = new int[26];
        for(int i = 0; i<s.length();i++){
            System.out.println(s.charAt(i));
            System.out.println(s.charAt(i) - 'a');
            int x = 'z' - 'b';
            System.out.println(x);
            count[s.charAt(i) - 'a'] ++;
            count[t.charAt(i) - 'a'] --;
        }

        for (int i : count){
            if (i != 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        isAnagram("qweqwe","qweqwe");
    }

}
