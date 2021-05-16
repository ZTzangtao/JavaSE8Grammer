package leetCode.systemLearningAlgorithm.Morris;

import leetCode.node.Node;

/**
 * @author zt
 */
public class morrisTraversal {

    /**
     * morris序(原始)
     *
     * @param head
     */
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

    /**
     * 中序遍历
     * @param head
     */
    public static void morrisMid(Node head){
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
            System.out.println(cur.value + " ");
            cur = cur.right;
        }
        System.out.println();
    }

    /**
     * 先序遍历
     * @param head
     */
    public static void morrisPre(Node head){
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
                    System.out.println(cur.value + "");
                    cur = cur.left;
                    continue;
                }else {
                    //mostRight.right--> 一定是指向cur
                    mostRight.right = null;
                }
            }else {
                System.out.println(cur.value + "");
            }
            cur = cur.right;
        }
        System.out.println();
    }

    /**
     * 后序遍历
     *
     * @param head
     */
    public static void morrisPos(Node head){
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
                    printEdge(cur.left);
                }
            }
            cur = cur.right;
        }
        printEdge(head);
        System.out.println();
    }

    private static void printEdge(Node head) {
        Node tail  = reverseEdge(head);
        Node cur = tail;
        while(cur != null){
            System.out.println(cur.value + "");
            cur = cur.right;
        }
        reverseEdge(tail);
    }

    private static Node reverseEdge(Node from) {
        Node pre = null;
        Node next = null;
        while(from != null){
            next = from.right;
            from.right = pre;
            pre = from;
            from = next;
        }
        return pre;
    }

    /**
     * 判断一个树是不是搜索二叉树
     *
     * @param head
     * @return
     */
    public static boolean isBST(Node head){
        if (head == null){
            return true;
        }
        Node cur = head;
        Node mostRight = null;
        Integer pre = null;
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
           if(pre!= null && pre >= cur.value){
                return false;
           }
           pre = cur.value;
            cur = cur.right;
        }
       return true;
    }



}
