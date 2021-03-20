package leetCode.systemLearningAlgorithm.BEPRT;

/**
 * @author zt
 */
public class FindMinKth {
    /**
     * 在一个无序数组中，怎么求第K小的数     bfprt : 不用概率的方式，也能收敛到O(N),意思就是 严格big O(n)
     */
    //利用概率，非bfprt
    public static int process2(int[] arr,int L, int R, int index){
        // L == R == Index
        if (L == R){
            return arr[L];
        }
        //不止一个数  L + [0,R - L]
        int pivot = arr[L + (int)(Math.random() * (R - L  + 1))];

//        int[] range =int
        return 1;
    }


}
