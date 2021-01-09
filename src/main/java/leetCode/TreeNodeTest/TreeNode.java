package leetCode.TreeNodeTest;

/**
 * @Author Tommy
 * @Date 2021/1/7 9:54 PM
 * @Version 1.0
 */
public class TreeNode {

    int val;

    TreeNode left;

    TreeNode right;

    public TreeNode() {

    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }

}
