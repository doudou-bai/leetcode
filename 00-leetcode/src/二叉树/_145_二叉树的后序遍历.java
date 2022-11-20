package 二叉树;

import java.util.ArrayList;
import java.util.List;

/**
 * Create By 王嘉浩
 * Time 2022-11-19 20:01
 */
public class _145_二叉树的后序遍历 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postorder(root, list);
        return list;
    }
    public void postorder(TreeNode root, List<Integer> list) {
        if (root == null) return;

        if (root.left != null) {
            postorder(root.left, list);
        }
        if (root.right != null) {
            postorder(root.right, list);
        }
        list.add(root.val);
    }
}
