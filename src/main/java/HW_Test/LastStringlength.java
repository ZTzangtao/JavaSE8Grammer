package HW_Test;

/**
 * @Author Tommy
 * @Date 2024/1/10 20:19
 * @Version 1.0
 */
public class LastStringlength {

    public static void main(String[] args) {
        System.out.println(lastStringLength("hello nowcoder"));
    }
    public static int lastStringLength (String s) {
        String[] arr = s.split("\\s+");
        return arr[arr.length - 1].length();
    }
}
