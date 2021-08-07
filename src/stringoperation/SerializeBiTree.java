package stringoperation;

import bitree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeBiTree {
    public String serialize(TreeNode root) {
        if (root == null) {
            return "[]";
        }

        Queue<TreeNode> qe = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        qe.add(root);
        sb.append("[");
        while (!qe.isEmpty()) {
            TreeNode temp = qe.poll();
            if (temp != null) {
                sb.append(temp.val + ",");
                qe.add(temp.left);
                qe.add(temp.right);
            } else {
                sb.append("null,");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("[]")) {
            return null;
        }
        String[] ds = data.substring(1, data.length() - 1).split(",");
        Queue<TreeNode> qe = new LinkedList<>();
        int i = 0;
        TreeNode root = new TreeNode(Integer.parseInt(ds[i++]));
        qe.add(root);
        while (!qe.isEmpty()) {
            TreeNode temp = qe.poll();
            if (!ds[i].equals("null")) {
                temp.left = new TreeNode(Integer.parseInt(ds[i]));
                qe.add(temp.left);
            }
            i++;
            if (!ds[i].equals("null")) {
                temp.right = new TreeNode(Integer.parseInt(ds[i]));
                qe.add(temp.right);
            }
            i++;
        }
        return root;
    }
}
