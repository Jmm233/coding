package bitree;

import java.util.Stack;

/*
    二叉搜索树节点间的最小距离
    https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/
 */
public class MinmumDistanceInBST {
    public int minDiffInBST(TreeNode root) {
        int ans = Integer.MAX_VALUE;
        int preV = -1;
        Stack<TreeNode> stack = new Stack<>();

        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.add(root);
                root = root.left;
            } else {
                TreeNode temp = stack.pop();
                if (preV == -1) {
                    preV = temp.val;
                } else {
                    ans = Math.min(temp.val - preV, ans);
                    preV = temp.val;
                }
                root = temp.right;
            }
        }
        return ans;
    }

}
