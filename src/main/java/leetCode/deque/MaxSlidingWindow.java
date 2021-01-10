package leetCode.deque;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author Tommy
 * @Date 2021/1/10 10:24 PM
 * @Version 1.0
 */
public class MaxSlidingWindow {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7},3)));
    }


    /**
     * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
     *
     * 返回滑动窗口中的最大值。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/sliding-window-maximum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * 示例 1：
     *
     * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
     * 输出：[3,3,5,5,6,7]
     * 解释：
     * 滑动窗口的位置                最大值
     * ---------------               -----
     * [1  3  -1] -3  5  3  6  7       3
     *  1 [3  -1  -3] 5  3  6  7       3
     *  1  3 [-1  -3  5] 3  6  7       5
     *  1  3  -1 [-3  5  3] 6  7       5
     *  1  3  -1  -3 [5  3  6] 7       6
     *  1  3  -1  -3  5 [3  6  7]      7
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/sliding-window-maximum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow(int[] nums,int k){
        int len = nums.length;
        if (len == 0){
            return nums;
        }
        int arr[] = new int[len -k + 1];
        int arr_index = 0;
        //单调递增的双向队列
        Deque<Integer> deque = new LinkedList<>();
        for(int i = 0; i < k; i++){
            while (!deque.isEmpty() && deque.peekLast() < nums[i]){
                deque.removeLast();
            }
            deque.offerLast(nums[i]);
        }

        //存到数组里，队头元素
        arr[arr_index++] = deque.peekFirst();
        //移动窗口
        for (int j = k; j < len; j++){
            if(nums[j - k] == deque.peekFirst()){
                deque.removeFirst();
            }
            while (!deque.isEmpty() && deque.peekLast() < nums[j]){
                deque.removeLast();
            }
            deque.offerLast(nums[j]);
            arr[arr_index++] = deque.peekFirst();
        }
        return arr;


    }

}
