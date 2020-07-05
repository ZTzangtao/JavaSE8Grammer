package classicalAlgorithm;

public class MergeSort {

    /** 归并排序主体函数 */
    public void sort(int[] A, int lo,int hi){
        if (lo>=hi){
            return;
        }
        int mid = lo + (hi - lo)/2;
        sort(A, lo, mid);
        sort(A , mid+1, hi);
        merge(A,lo,mid,hi);
    }

    private void merge(int[] nums, int lo, int mid, int hi) {
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
