package MultiThread.ThreadExtendsMethod;

/**
 * 多线程练习
 *
 * @author zangtao
 * @create 2019 - 08 -30 18:38
 */
public class TestMutiThread extends Thread {
    private int count = 10;

    @Override
    public void run() {
        while (true) {
            // 打印 Count 变量
            System.out.println(count + "");
            // 使count 变量 自减 ，当自减为0时，退出循环
            if (--count == 0) {
                return;
            }
        }
    }

    public static void main(String[] args) {
        new TestMutiThread().start();
    }
}
