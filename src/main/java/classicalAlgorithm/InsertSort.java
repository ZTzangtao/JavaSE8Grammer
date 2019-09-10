package classicalAlgorithm;

import java.util.Arrays;

/**
 * 插入排序
 *
 * @author zangtao
 * @create 2019 - 09 -10 17:14
 */
public class InsertSort {
    //插入排序的核心思想：维护一个有序区，把元素一个一个插入到有序区的适当位置，知道所有元素有序为止
    public static void insertSort(int[] arrary) {
        for (int i = 1; i < arrary.length; i++) {
            int insertValue = arrary[i];
            int j = i - 1;
            //从右向左比较元素的同时，进行元素复制
            for (; j >= 0 && insertValue < arrary[j]; j--) {
                arrary[j + 1] = arrary[j];
            }
            //insertValue的值插入适当的位置
            arrary[j + 1] = insertValue;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 4, 5, 48, 43, 21, 5, 21, 8};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
