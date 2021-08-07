package bitree;

/*
    判断一棵二叉树是否是平衡二叉树
    https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof/
    与LegalSearchBiTree对应着看，两者不能用一个方法，一个是自顶向下，一个是由下至顶
 */
public class BalancedBiTree {
    public boolean isBalanced(TreeNode root) {
        return recur(root) != -1;
    }

    public int recur(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = recur(root.left);
        if (left == -1) {
            return -1;
        }
        int right = recur(root.right);
        if (right == -1) {
            return -1;
        }
        if (Math.abs(left - right) > 1) {
            return -1;
        } else {
            return Math.max(left, right) + 1;
        }
    }
}
