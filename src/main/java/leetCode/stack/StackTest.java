package leetCode.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author zangtao
 * @date 2020/4/21 13:50
 */
public class StackTest {

    public static int[] dailyTemperatures(int[] T){
        int[] ans = new int[T.length];
        Stack<Integer> stack = new Stack();
        for(int i = T.length - 1;i >= 0; --i){
            while (!stack.isEmpty() && T[i] >= T[stack.peek()]){
                stack.pop();
            }
            ans[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{2,5,3,8,5,2,1,9,0})));
    }

}
