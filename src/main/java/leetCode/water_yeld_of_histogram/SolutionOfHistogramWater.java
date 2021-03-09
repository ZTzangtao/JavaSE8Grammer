package leetCode.water_yeld_of_histogram;

/**
 * @Author Tommy
 * @Date 2021/3/9 10:12 PM
 * @Version 1.0
 */
public class SolutionOfHistogramWater {

    public static void main(String[] args) {
        System.out.println("此直方图的蓄水量为：" + trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }

    public static int trap(int[] height){
        if(height.length < 3){
            return 0;
        }
        //左指针
        int left = 0;
        //右指针
        int right = height.length - 1;
        //左边最大值
        int leftMax = height[left];
        //右边最大值
        int rightMax = height[right];
        //纪录蓄水量
        int res = 0;
        //两端同时往中间移动
        while(left < right){
            if(leftMax < rightMax){
                //左侧最高值减去当前位置的值就是当前位置的蓄水量
                res += leftMax - height[left++];
                //更新左侧最大值
                leftMax = Math.max(leftMax,height[left]);
            }else{
                //右侧最高值减去当前位置的值就是当前位置的蓄水量
                res += rightMax - height[right--];
                //更新右侧最大值
                rightMax = Math.max(rightMax,height[right]);
            }
        }
        return res;

    }
}
