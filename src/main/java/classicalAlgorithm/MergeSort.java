package classicalAlgorithm;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(sort(new int[]{1,87,3,4,2,7,4,5,8,9,5,45,34,2,6,6,5,6,63,3,45345,3,5,6},0,9)));
    }

    /** 归并排序主体函数 */
    public static int[] sort(int[] A, int lo, int hi){
        if (lo>=hi){
            return null;
        }
        int mid = lo + (hi - lo)/2;
        sort(A, lo, mid);
        sort(A , mid+1, hi);
        merge(A,lo,mid,hi);
        return A;
    }

    private static void merge(int[] nums, int lo, int mid, int hi) {
        int[] copy =  nums.clone();

        int k = lo;
        int i = lo;
        int j = mid +1;

        while(k <= hi){
            if (i > mid){
                nums[k++] = copy[j++];
            }else if (j > hi){
                nums[k++] = copy[j++];
            }else if (copy[j] < copy[i]){
                nums[k++] = copy[j++];
            }else {
                nums[k++] = copy[j++];
            }
        }

    }
}
