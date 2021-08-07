package bitree;

/*
    判断一棵二叉树是否是二叉搜索树
    https://leetcode-cn.com/problems/legal-binary-search-tree-lcci/
    没说没有负数，所以不能用标志值表示
    递归遍历的一种表示
    与BalanedBiTree对应着看
    这种类型题，一般递归比非递归耗时少
 */

import java.util.Stack;

public class LegalSearchBiTree {
    // solution 1
    /*public boolean isValidBST(TreeNode root) {
        return recur(root, null, null);
    }

    public boolean recur(TreeNode root, Integer preV, Integer posV) {
        if (root == null) {
            return true;
        }
        if ((preV != null && root.val <= preV) || (posV != null && root.val >= posV)) {
            return false;
        }
        if (!recur(root.left, preV, root.val) || !recur(root.right, root.val, posV)) {
            return false;
        }

        return true;
    }*/


    // solution 2 no recursion
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        // int preV = root.val;
        Integer preV = null;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.add(root);
                root = root.left;
            } else {
                TreeNode temp = stack.pop();
                //
                if (preV != null && preV >= temp.val) {
                    return false;
                }
                preV = temp.val;
                root = temp.right;
            }
        }
        return true;
    }
}
