package OwnTest.algorithm;

/**
 * @Author: Tommy
 * @DATE: 2022/3/31
 */
public class TreeNode {
    int val;

    TreeNode left;

    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(){}

    TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
