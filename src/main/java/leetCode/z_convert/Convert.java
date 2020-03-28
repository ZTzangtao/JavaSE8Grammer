package leetCode.z_convert;

/**
 * @author zangtao
 * @date 2020/3/28 10:59
 */
public class Convert {
    /**
     * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
     *
     * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
     *
     * L   C   I   R
     * E T O E S I I G
     * E   D   H   N
     * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
     *
     * 请你实现这个将字符串进行指定行数变换的函数：
     *
     * string convert(string s, int numRows);
     * 示例 1:
     *
     * 输入: s = "LEETCODEISHIRING", numRows = 3
     * 输出: "LCIRETOESIIGEDHN"
     * 示例 2:
     *
     * 输入: s = "LEETCODEISHIRING", numRows = 4
     * 输出: "LDREOEIIECIHNTSG"
     * 解释:
     *
     * L     D     R
     * E   O E   I I
     * E C   I H   N
     * T     S     G
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/zigzag-conversion
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public String zigZagConversion(String s,int numRows){
        if(s == null || s.length() == 0 || numRows <= 1){
            return s;
        }
        StringBuilder[] array = new StringBuilder[numRows];
        for(int i = 0; i < array.length; i++){
            array[i] = new StringBuilder();
        }
        int dir = 1;
        int index = 0;
        for(char c :s.toCharArray()){
            array[index].append(c);
            index += dir;
            if(index == 0 || index == numRows -1){
                dir = -dir;
            }
        }
        StringBuilder result = new StringBuilder();
        for(int i = 0;i<array.length;i++){
            result.append(array[i]);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Convert convert = new Convert();
        System.out.println(convert.zigZagConversion("LEETCODEISHIRING",4));
    }

}
