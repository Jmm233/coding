package bitree;

import org.junit.Test;

import java.util.Stack;

/*
    二叉树的遍历
 */
public class traverse01 {
    public void firstOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.println(root.val);
        firstOrder(root.left);
        firstOrder(root.right);
    }

    /*
    其他两种遍历递归方式差不多
     */

    public void noRecurFirstOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            System.out.println(temp.val);
            if (temp.right != null) {
                stack.add(temp.right);
            }
            if (temp.left != null) {
                stack.add(temp.left);
            }
        }
    }

    public void noRecurInOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.add(root);
                root = root.left;
            } else {
                // 输出
                TreeNode temp = stack.pop();
                System.out.println(temp.val);
                root = temp.right;
            }
        }
    }

    public void noRecurPostOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> help = new Stack<>();
        stack.add(root);
        while (!stack.empty()) {
            TreeNode temp = stack.pop();
            help.add(temp);
            if (temp.left != null) {
                stack.add(temp.left);
            }
            if (temp.right != null) {
                stack.add(temp.right);
            }
        }
    }

    @Test
    public void ttest() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        noRecurInOrder(root);
    }
}
