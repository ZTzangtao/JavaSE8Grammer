package classicalAlgorithm;

import java.util.Arrays;

/**
 * 快速排序
 *
 * 小辉算法
 * @author zangtao
 * @create 2019 - 08 -22 16:36
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = new int[]{4, 4, 5, 21, 8};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int startIndex, int endIndex) {
        //递归结束条件：startIndex 大于或等于 endIndex
        if (startIndex >= endIndex) {
            return;
        }

        //得到基准元素位置
        int pivotIndex = partitionBySingleSide(arr, startIndex, endIndex);

        //根据基准元素，分成两部分进行递归排序
        quickSort(arr, startIndex, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, endIndex);

    }

    /**
     * 双边循环实现快速排序，使用递归方式
     *
     * @param arr
     * @param startIndex
     * @param endIndex
     */
    private static int partition(int[] arr, int startIndex, int endIndex) {
        //取第一个位置（也可以选择随机位置）的元素作为基准元素
        int pivot = arr[startIndex];
        int right = startIndex;
        int left = endIndex;

        while (left != right) {
            //控制right指针比较并左移
            while (left < right && arr[right] > pivot) {
                right--;
            }

            //控制left指针比较并右移
            while (left < right && arr[left] <= pivot) {
                left++;
            }

            //交换left和right指针指向的元素
            if (left < right) {
                int p = arr[left];
                arr[left] = arr[right];
                arr[right] = p;
            }
        }
        //pivot和指针重合点交换
        arr[startIndex] = arr[left];
        arr[left] = pivot;

        return left;

    }

    /**
     * 单边循环实现快速排序，使用递归方式
     *
     * @param arr
     * @param startIndex
     * @param endIndex
     * @return
     */
    private static int partitionBySingleSide(int[] arr, int startIndex, int endIndex) {
        int pivot = arr[startIndex];
        int mark = startIndex;

        for (int i = startIndex + 1; i <= endIndex; i++) {
            if (arr[i] < pivot) {
                mark++;
                int p = arr[mark];
                arr[mark] = arr[i];
                arr[i] = p;
            }
        }

        arr[startIndex] = arr[mark];
        arr[mark] = pivot;
        return mark;

    }

}
