package OwnTest.algorithm;

/**
 * @Author: Tommy
 * @DATE: 2022/3/31
 */
public class algorithm {

    public TreeNode removeNode(TreeNode root, int x){
        if (root == null) {
            return null;
        }
        // 找到X节点
        if(x > root.val){
            root.right = removeNode(root.right, x);
        }else if(x < root.val){
            root.left = removeNode(root.left, x);
        }else {
            if(root.left == null){
                return root.right;
            }
            if(root.right == null){
                return root.left;
            }
            TreeNode node = root.right;
            while(node.left != null){
                node = node.left;
            }
            node.left = root.left;
            root = root.right;
        }
        return root;
    }


}
