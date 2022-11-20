package 二叉树;

import com.sun.xml.internal.fastinfoset.util.QualifiedNameArray;

import java.util.ArrayList;
import java.util.List;

/**
 * Create By 王嘉浩
 * Time 2022-11-19 20:26
 */
public class _100_相同的树 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //如果p和q都为空 那么返回true
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {//p和q有一个为空则返回false
            return false;
        } else if (p.val != q.val) {//p的val不等于q的val返回false
            return false;
        } else {//递归调用 分别改动q和p的left节点 和right的节点
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }

}

