package lambadaTest;

/**
 * 返回当前相同字符串
 *
 * @author zangtao
 * @create 2019 - 05 -23 9:31
 */
public class testStr {

    public static void main(String[] args) {
        //要求输出  "fl"
        String[] strs = new String[]{"flow","flowers","flaw"};
        if (strs.length == 0){
            return;
        }

        if (strs.length == 1){
            System.out.println(strs[0]);
            return;
        }


        //初始化最小字符串的长度
        int minxLength = strs[0].length();

        //初始化最小字符串
        String minStr = strs[0];

        //这一步操作找出长度最小字符串和它的长度
        for(String str : strs){

            if (str.length() == 1){
                System.out.println(str);
                return;
            }

            if(str.length() < minxLength){
                minxLength = str.length();
                minStr = str;
            }
        }

        int i = 0;

        StringBuffer stringBuffer = new StringBuffer();
        //开始冲了
        for(int j = 0; j < minxLength; j++ ){

            String s = minStr.substring(j,j+1);

            for (int k = 0; k < strs.length;k++ ){

                if ( !strs[k].substring(j,j+1).equals(s) ){
                    i++;
                }
            }
            if (i == 0){
                stringBuffer.append(s);
            }

        }
        System.out.println(stringBuffer);

    }
}
