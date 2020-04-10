package NodeTest;

/**
 * @author zangtao
 * @date 2020/4/6 22:56
 */
public class BinaryTree<T extends Comparable> {

    private class Node<T> {
        /**
         * 存放Comparable，可以比较大小
         */
        private Comparable<T> data;
        /**
         * 保存父节点
         */
        private Node parent;
        /**
         * 保存左节点
         */
        private Node left;
        /**
         * 保存右节点
         */
        private Node right;

        /**
         * 构造方法直接负责进行数据的存储
         * @param data
         */
        public Node(Comparable<T> data){
            this.data = data;
        }

        public void addNode(Node newNode){
            if (newNode.data.compareTo((T)this.data) <= 0){
                //比当前节点数据小
                if(false){

                }
            }
        }

    }



    private Node root;

}
