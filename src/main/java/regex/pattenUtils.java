package regex;

import java.util.regex.Pattern;

/**
 * @author zangtao
 * @date 2019/12/24 8:55
 */
public class pattenUtils {
    public static void main(String[] args) {
        //不可以输入汉字
        String isWord = "^[^\\u4e00-\\u9fa5]{0,}$";

        //只能输入数字和字母
        String numberFlag = "[\\da-zA-z]+";


        boolean flag = Pattern.matches(isWord,"w w 我");
        System.out.println("输入内容："+flag );




    }


}
