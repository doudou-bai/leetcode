package cn.doudou.algorithm.test;

import cn.doudou.algorithm.tree.BinaryTree;

/**
 * Create By 王嘉浩
 * Time 2022-10-24 20:47
 */
public class BinaryTreeTest {
    public static void main(String[] args) {
        BinaryTree<Integer, String> tree = new BinaryTree<Integer, String>();
        tree.put(1, "张三");
        tree.put(2, "李四");
        tree.put(3, "王五");
        tree.put(4, "赵六");
//        System.out.println(tree.size());
//        System.out.println(tree.get(2));
        System.out.println(tree.max());
    }
}
