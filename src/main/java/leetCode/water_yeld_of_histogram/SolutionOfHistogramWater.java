package leetCode.water_yeld_of_histogram;

/**
 * @Author Tommy
 * @Date 2021/3/9 10:12 PM
 * @Version 1.0
 */
public class SolutionOfHistogramWater {

    /*
    max{min{左max ， 右边max} - arr[i]  ， 0 }

     */
    public static int water2(int[] arr){
        if(arr == null || arr.length < 2){
            return 0;
        }
        int N = arr.length;
        int[] leftMaxs = new int[N];
        leftMaxs[0] = arr[0];
        for(int i = 1; i < N; i++){
            leftMaxs[i] = Math.max(leftMaxs[i - 1],arr[i]);
        }

        int[] rightMaxs = new int[N];
        rightMaxs[N - 1] = arr[N - 1];
        for(int i = N-2; i >= 0; i--){
            rightMaxs[i] = Math.max(rightMaxs[i + 1],arr[i]);
        }
        int water = 0;
        for (int i = 1; i < N - 1;i++){
            water += Math.max(Math.min(leftMaxs[i - 1],rightMaxs[i + 1]) - arr[i],0);
        }
        return water;
    }




    public static void main(String[] args) {
        System.out.println("此直方图的蓄水量为：" + trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }

    public static int trap(int[] arr){
        if(arr.length < 3){
            return 0;
        }
        int N = arr.length;
        //左指针
        int L = 1;
        //右指针
        int R = N - 2;
        //左边最大值
        int leftMax = arr[0];
        //右边最大值
        int rightMax = arr[N - 1];
        //纪录蓄水量
        int res = 0;
        //两端同时往中间移动
        while(L <= R){
            if(leftMax <= rightMax){
                //左侧最高值减去当前位置的值就是当前位置的蓄水量
                res += Math.max(0,leftMax - arr[L]);
                //更新左侧最大值
                leftMax = Math.max(leftMax,arr[L++]);
            }else{
                //右侧最高值减去当前位置的值就是当前位置的蓄水量
                res += Math.max(0,rightMax - arr[R]);
                //更新右侧最大值
                rightMax = Math.max(rightMax,arr[R--]);
            }
        }
        return res;

    }
}
