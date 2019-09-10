package classicalAlgorithm;

import java.util.Arrays;

/**
 * 希尔排序
 * 逐步分组进行粗调，在进行直接插入排序
 *
 * @author zangtao
 * @create 2019 - 09 -10 17:47
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] arr = new int[]{4, 4, 5, 48, 43, 21, 5, 21, 8};
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void shellSort(int[] array) {
        //希尔排序的增量
        int d = array.length;
        while (d > 1) {
            //使用希尔增量的方式，即每次折半
            d = d / 2;
            for (int x = 0; x < d; x++) {
                for (int i = x + d; i < array.length; i = i + d) {
                    int temp = array[i];
                    int j;
                    for (j = i - d; j >= 0 && array[j] > temp; j = j - d) {
                        array[j + d] = array[j];
                    }
                    array[j + d] = temp;
                }
            }
        }
    }

}
