package 二叉树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.cn/problems/invert-binary-tree/
 * Create By 王嘉浩
 * Time 2022-11-19 19:27
 */
public class _226_翻转二叉树 {
    /**
     * 前序遍历进行翻转
     * @param root
     * @return
     */
   /* public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        //交换元素
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        //递归调用方法 把node 的左子树传入进去
        invertTree(root.left);
        //递归调用方法 把node 的右子树传入进去
        invertTree(root.right);

        //返回根节点
        return root;
    }*/

    /**
     * 后序遍历进行翻转
     * @param root
     * @return
     */
    /*public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        //递归调用方法 把node 的左子树传入进去
        invertTree(root.left);
        //递归调用方法 把node 的右子树传入进去
        invertTree(root.right);
        //交换元素
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        //返回根节点
        return root;
    }*/

    /**
     * 中序遍历进行翻转
     *
     * @param root
     * @return
     */
    /*public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        //递归调用方法 把node 的左子树传入进去
        invertTree(root.left);
        //交换元素
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        //递归调用方法 把node 的右子树传入进去
        invertTree(root.left);
        //返回根节点
        return root;
    }*/

    /**
     * 使用层序遍历进行翻转
     *
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            //交换元素
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;

            if (node.left != null) {
                queue.offer(node.left);
            }

            if (node.right != null) {
                queue.offer(node.right);
            }
        }

        //返回根节点
        return root;
    }
}
