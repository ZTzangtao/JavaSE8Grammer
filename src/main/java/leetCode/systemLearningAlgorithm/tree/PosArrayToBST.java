package leetCode.systemLearningAlgorithm.tree;

import java.util.ArrayList;

/**
 * @Author Tommy
 * @Date 2021/4/22 10:16 PM
 * @Version 1.0
 */
public class PosArrayToBST {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int v) {
            value = v;
        }
    }

    public static Node posArrayToBST2(int[] posArr) {
        return process2(posArr, 0, posArr.length - 1);
    }

    public static Node process2(int[] posArr, int L, int R) {
        if (L > R) {
            return null;
        }

        Node head = new Node(posArr[R]);
        if (L == R) {
            return head;
        }
        int M = L - 1;
        int left = L;
        int right = R - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (posArr[mid] < posArr[R]) {
                M = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        head.left = process1(posArr, L, M);
        head.right = process1(posArr, M + 1, R - 1);
        return head;
    }


    public static Node posArrayToBST1(int[] posArr) {
        return process1(posArr, 0, posArr.length - 1);
    }

    //O(n^2)
    public static Node process1(int[] posArr, int L, int R) {
        if (L > R) {
            return null;
        }

        Node head = new Node(posArr[R]);
        if (L == R) {
            return head;
        }
        //精髓设置
        int M = L - 1;
        for (int i = L; i < R; i++) {
            if (posArr[i] < posArr[R]) {
                M = i;
            }
        }
        head.left = process1(posArr, L, M);
        head.right = process1(posArr, M + 1, R - 1);
        return head;
    }

    //for test
    //自动生成搜索二叉树
    public static Node generateRandomBST(int min, int max, int N) {
        if (min > max) {
            return null;
        }
        return createTree(min, max, 1, N);
    }

    private static Node createTree(int min, int max, int level, int N) {
        if (min > max || level > N) {
            return null;
        }
        Node head = new Node(random(min, max));
        head.left = createTree(min, head.value - 1, level + 1, N);
        head.right = createTree(head.value - 1, max, level + 1, N);
        return head;
    }

    private static int random(int min, int max) {
        return min + (int) (Math.random() * (max - min + 1));
    }

    public static void pos(Node head, ArrayList<Integer> posList) {
        if (head != null) {
            pos(head.left, posList);
            pos(head.right, posList);
            posList.add(head.value);
        }
    }

    public static int[] getBSTPosArray(Node head) {
        ArrayList<Integer> posList = new ArrayList<>();
        pos(head, posList);
        int[] ans = new int[posList.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = posList.get(i);
        }
        return ans;
    }

    public static void printTree(Node head) {
        System.out.println("Binary Tree:");
        printInOrder(head, 0, "H", 17);
        System.out.println();
    }

    private static void printInOrder(Node head, int height, String to, int len) {
        if (head == null) {
            return;
        }
        printInOrder(head.right, height + 1, "v", len);
        String val = to + head.value + to;
        int lenM = val.length();
        int lenL = (len - lenM) / 2;
        int lenR = len - lenM - lenL;
        val = getSpace(lenL) + val + getSpace(lenR);
        System.out.println(getSpace(height * len) + val);
        printInOrder(head.left,height+1,"^",len);


    }

    private static String getSpace(int num) {
        String space = " ";
        StringBuffer buf = new StringBuffer("");
        for (int i = 0; i < num; i++) {
            buf.append(space);
        }
        return buf.toString();
    }

    public static boolean isSameValueStructure(Node head1,Node head2){
        if(head1 == null && head2 != null){
            return false;
        }
        if (head1 != null && head2 == null){
            return false;
        }
        if (head1 == null && head2 == null){
            return true;
        }
        return head1.value == head2.value && isSameValueStructure(head1.left,head2.left)
                && isSameValueStructure(head1.right,head2.right);
    }

    public static void main(String[] args) {
        int min = 0;
        int max = 12;
        int level = 4;
        Node head = generateRandomBST(min, max, level);
        int[] pos = getBSTPosArray(head);
        printTree(head);
        printTree(posArrayToBST1(pos));
        printTree(posArrayToBST2(pos));
        System.out.println(isSameValueStructure(head,posArrayToBST1(pos)));
        System.out.println(isSameValueStructure(head,posArrayToBST2(pos)));

        int testTimes = 3;
        System.out.println("test begin,time time : " + testTimes);
        for(int i = 0;i<testTimes;i++){
            head = generateRandomBST(min,max,level);
            pos= getBSTPosArray(head);
            if(!isSameValueStructure(head,posArrayToBST1(pos)) || !isSameValueStructure(head,posArrayToBST2(pos))){
                System.out.println("Oops!");

            }
        }
        System.out.println("test finish");
    }
}
