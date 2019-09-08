package XiaoHuiAlgorithm;

import java.util.Stack;

/**
 * 利用栈来实现队列
 *
 * @author zangtao
 * @create 2019 - 09 -08 14:43
 */
public class TwoStackToQueue20190908 {

    public static void main(String[] args) {
        TwoStackToQueue20190908 stackQueue = new TwoStackToQueue20190908();
        stackQueue.enQueue(1);
        stackQueue.enQueue(2);
        stackQueue.enQueue(3);
        System.out.println(stackQueue.deQueue());
        System.out.println(stackQueue.deQueue());
        stackQueue.enQueue(4);
        System.out.println(stackQueue.deQueue());
        System.out.println(stackQueue.deQueue());
    }


    private Stack<Integer> stackA = new Stack<>();
    private Stack<Integer> stackB = new Stack<>();

    /**
     * 入队操作
     *
     * @param element 入队的元素
     */
    public void enQueue(int element) {
        stackA.push(element);
    }

    public Integer deQueue() {
        if (stackB.isEmpty()) {
            if (stackA.isEmpty()) {
                return null;
            }
            transfer();
        }
        return stackB.pop();
    }

    private void transfer() {
        while (!stackA.isEmpty()) {
            stackB.push(stackA.pop());
        }
    }

}
