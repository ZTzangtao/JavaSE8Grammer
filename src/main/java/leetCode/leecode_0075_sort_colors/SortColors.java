package leetCode.leecode_0075_sort_colors;

/**
 * @Author Tommy
 * @Date 2021/1/26 10:44 PM
 * @Version 1.0
 */
public class SortColors {

    public static void main(String[] args) {

    }

    public static void sortColors(int[] nums){

        int len = nums.length;

        if (len < 2) {
            return;
        }

        // all in[0,p0)  == 0
        // all in[p0,i)  == 1
        // all in(p2,len -1]  == 2
        int p0 = 0;
        int i = 0;
        int p2 = len - 1;

        while(i<=p2){
            if (nums[i] == 0){
                swap(nums,i,p0);
                p0++;
                i++;
            }else if(nums[i] == 1){
                i++;
            }else {
                swap(nums,i,p2);
                p2--;
            }

        }




    }

    private static void swap(int[] nums,int index1, int index2){
        int temp = nums[index1];

        nums[index1] = nums[index2];

        nums[index2] = temp;
    }
}
