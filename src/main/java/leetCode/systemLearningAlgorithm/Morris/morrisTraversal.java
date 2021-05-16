package leetCode.systemLearningAlgorithm.Morris;

import leetCode.node.Node;

/**
 * @author zt
 */
public class morrisTraversal {

    public static void morris(Node head){
        if (head == null){
            return;
        }
        Node cur = head;
        Node mostRight = null;
        while (cur != null){
            //有没有左树
            mostRight = cur.left;
            //有左树
            if(mostRight != null){
                //先找到cur左树上的真实的最右节点
                while (mostRight.right != null && mostRight.right != cur){
                    mostRight = mostRight.right;
                }
                //从while中出来，mostRight一定是cur左树上的最右节点
                if (mostRight.right == null){
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                }else {
                    //mostRight.right--> 一定是指向cur
                    mostRight.right = null;
                }
            }
            cur = cur.right;
        }
    }




}
