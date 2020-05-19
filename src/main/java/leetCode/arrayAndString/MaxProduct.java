package leetCode.arrayAndString;

import java.util.Arrays;

public class MaxProduct {

    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{3,-1,4}));
    }

    public static int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int imax = 1;
        int imin = 1;
        for (int i = 0;i<nums.length;i++){
            if (nums[i] <0){
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }
            imax = Math.max(imax * nums[i],nums[i]);
            imin = Math.min(imin * nums[i], nums[i]);

            max = Math.max(max,imax);
        }
        return max;

    }


}
