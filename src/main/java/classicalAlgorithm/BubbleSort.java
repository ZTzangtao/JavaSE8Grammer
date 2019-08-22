package classicalAlgorithm;

/**
 * 冒泡排序
 *
 * @author zangtao
 * @create 2019 - 08 -08 18:04
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] a = new int[]{3, 7, 9, 10, 2, 4, 3, 4, 5, 5, 6, 2};

        int[] b = Sort(a);

        for (int i : b) {
            System.out.print(i + ",");
        }

    }

    private static int[] Sort(int[] a) {
        int t;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                //第二层J判断
                if (a[j] > a[j + 1]) {
                    t = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = t;
                }
            }
        }

        return a;
    }

}
