package classicalAlgorithm;

/**
 * 桶排序
 *
 * @author zangtao
 * @create 2019 - 08 -22 11:16
 */
public class BucketSort {

    public static void main(String[] args) {
        int[] a = new int[]{3, 7, 9, 10, 2, 4, 3, 4, 5, 5, 6, 2};

        int[] b = bucketSort(a);

        for (int i : b) {
            System.out.print(i + ",");
        }

    }

    public static int[] bucketSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }
        //确定数组里最大的数
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        //定义桶
        int[] bucket = new int[max + 1];

        for (int i = 0; i < arr.length; i++) {
            //桶数组此下标有数据，数值就加一
            bucket[arr[i]]++;
        }

        int i = 0;

        //每次进while不会 -1，比对完 -1
        for (int j = 0; j < bucket.length; j++) {
            while (bucket[j]-- > 0) {
                arr[i++] = j;
            }
        }
        return arr;

    }

}
