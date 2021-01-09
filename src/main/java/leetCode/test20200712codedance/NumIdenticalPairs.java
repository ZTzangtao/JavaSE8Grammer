package leetCode.test20200712codedance;

/**
 * 5460. 好数对的数目
 *
 * @author Tommy
 * @date 2020/7/12 10:58 上午
 */
public class NumIdenticalPairs {

    public static void main(String[] args) {
        System.out.println(numIdenticalPairs(new int[]{1,2,3}));
        System.out.println(numIdenticalPairs(new int[]{1,2,3,1,1,3}));
    }


    /**
     * 输入：nums = [1,2,3,1,1,3]
     * 输出：4
     * 解释：有 4 组好数对，分别是 (0,3), (0,4), (3,4), (2,5) ，下标从 0 开始
     *
     * @param nums
     * @return
     */
    public static int numIdenticalPairs(int[] nums) {
        int n = 0;
        for(int i = 0; i < nums.length -1;i++){
            for(int j = i+1; j < nums.length - 1 -i;j++) {
                    if (nums[i] == nums[j + 1]) {
                        n++;
                    }
                }
        }
        return n;
    }


}
