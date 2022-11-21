package 二叉树;

import java.util.ArrayList;
import java.util.List;

/**
 * Create By 王嘉浩
 * Time 2022-11-20 13:35
 */
public class _700_二叉搜索树中的搜索 {

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;

        if (root.val > val) {
            return searchBST(root.left, val);
        }

        if (root.val < val) {
            return searchBST(root.right, val);
        }
        return root;
    }
}
