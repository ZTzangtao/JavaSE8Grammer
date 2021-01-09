package leetCode.TreeNodeTest;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author Tommy
 * @Date 2021/1/7 9:52 PM
 * @Version 1.0
 */
public class NodeMaxDepth {

    public static void main(String[] args) {

        TreeNode root2 = new TreeNode(9,null,null);
        TreeNode root4 = new TreeNode(15,null,null);
        TreeNode root5 = new TreeNode(7,null,null);
        TreeNode root3= new TreeNode(20,root4,root5);
        TreeNode root = new TreeNode(3,root2,root3);

        System.out.println(maxDepthBfs(root));
    }

    /**
     * 给定一个二叉树，找出其最大深度。
     *
     * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
     *
     * 说明: 叶子节点是指没有子节点的节点。
     *
     * 示例：
     * 给定二叉树 [3,9,20,null,null,15,7]，
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param root
     * @return
     */

    /**
     * Depth first search
     * DFS ( 深度优先搜索 ) 策略计算树的高度
     */
    public static int maxDepthDfs(TreeNode root) {
        if(root == null){
            return 0;
        }
        return 1 + Math.max(maxDepthDfs(root.left),maxDepthDfs(root.right));
    }

    /**
     * Breadth first search
     * 采用 BFS ( 广度优先搜索 ) 策略对二叉树按层遍历.
     * 实现 BFS 就要用到 '先进先出' 的队列了
     */
    public static int maxDepthBfs(TreeNode root) {

        if(root == null){
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        int res = 0;

        while(!queue.isEmpty()){

            int size = queue.size();
            while(size-- >0){
                TreeNode node = queue.poll();
                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }

            }
            res ++;

        }
        return res;

    }

}
