package leetCode.TreeNodeTest;


import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author Tommy
 * @Date 2021/1/12 10:54 PM
 * @Version 1.0
 */
public class MinTreeDepth {

    /**
     *给定一个二叉树，找出其最小深度。
     *
     * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
     *
     * 说明：叶子节点是指没有子节点的节点。
     * 输入：root = [3,9,20,null,null,15,7]
     * 输出：2
     * 示例 2：
     *
     * 输入：root = [2,null,3,null,4,null,5,null,6]
     * 输出：5
     *
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     */
    /**
     * DFS
     *
     * 分别计算其左右子树的最小叶子节点深度。这样就将一个大问题转化为了小问题，可以递归地解决该问题
     * @param root
     * @return
     */
    public static int minDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        if (root.left == null && root.right == null){
            return 1;
        }
        int min_depth = Integer.MAX_VALUE;

        if (root.left != null){
            min_depth = Math.min(minDepth(root.left),min_depth);
        }
        if (root.right != null){
            min_depth = Math.min(minDepth(root.right),min_depth);
        }

        return min_depth + 1;
    }

    /**
     * 广度优先
     *
     * 当我们找到一个叶子节点时，直接返回这个叶子节点的深度。广度优先搜索的性质保证了最先搜索到的叶子节点的深度一定最小。
     * @param root
     * @return
     */
    public static int minDepthBFS(TreeNode root) {
        if (root ==  null){
            return 0;
        }

        Queue<QueueNode> queue = new LinkedList<>();

        queue.offer(new QueueNode(root,1));

        while (!queue.isEmpty()){
            QueueNode nodeDepth = queue.poll();
            TreeNode node =  nodeDepth.getNode();
            int depth = nodeDepth.getDepth();
            if (node.left == null && node.right == null){
                return depth;
            }
            if (node.left != null){
                queue.offer(new QueueNode(node.left,depth + 1));
            }

            if (node.right != null){
                queue.offer(new QueueNode(node.right,depth + 1));
            }
        }
        return 0;
    }

}
