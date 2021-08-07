package bitree;

/*
    求完全二叉树的节点个数
    https://leetcode-cn.com/problems/count-complete-tree-nodes/
    递归看抽象问题的能力
 */

public class CompleteBiTreeNodeCount {
    /*
        左右子树高度相等，那么左子树是满的，看右子树
        如果不等（而且是右子树小），那么看左子树
     */
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = countLevel(root.left);
        int right = countLevel(root.right);
        if (left == right) {
            return countNodes(root.right) + (int) Math.pow(2, left);
        } else {
            return countNodes(root.left) + (int) Math.pow(2, right);
        }
    }

    public int countLevel(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return countLevel(root.left) + 1;
    }

    // 普通二叉树求节点个数
    // 同样适用
    public int countNodeForBiTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return countNodeForBiTree(root.left) + countNodeForBiTree(root.right) + 1;
    }
}
