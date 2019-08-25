package ArrayTest;

/**
 * 数组练习
 *
 * @author zangtao
 * @create 2019 - 08 -25 17:26
 */
public class ArrayAddAndDelTest20190525 {

    private int[] array;
    private int size;

    public ArrayAddAndDelTest20190525(int capacity) {
        this.array = new int[capacity];
        size = 0;
    }

    public void insert(int element, int index) throws Exception {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("越界了！");
        }

        for (int i = size - 1; i >= index; i--) {
            array[i + 1] = array[i];
        }
        array[index] = element;
        size++;
    }

    public void output() {
        for (int i = 0; i < size; i++) {
            System.out.println(array[i]);
        }
    }

    public static void main(String[] args) throws Exception {
        ArrayAddAndDelTest20190525 arrayAddAndDelTest20190525 = new ArrayAddAndDelTest20190525(10);
        arrayAddAndDelTest20190525.insert(3, 0);
        arrayAddAndDelTest20190525.insert(7, 1);
        arrayAddAndDelTest20190525.insert(9, 2);
        arrayAddAndDelTest20190525.insert(5, 3);
        arrayAddAndDelTest20190525.insert(6, 1);
        arrayAddAndDelTest20190525.output();

    }


}
