package 二叉树;

import java.util.ArrayList;
import java.util.List;

/**
 * Create By 王嘉浩
 * Time 2022-11-19 19:48
 */
public class _144_二叉树的前序遍历 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorder(root, list);
        return list;
    }

    public void preorder(TreeNode root, List<Integer> res) {
        if (root == null) return;
        res.add(root.val);
        if (root.left != null) {
            preorder(root.left, res);
        }
        if (root.right != null) {
            preorder(root.right, res);
        }
    }
}
