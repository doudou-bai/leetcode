package cn.doudou.algorithm.test;

import cn.doudou.algorithm.linear.Queue;
import cn.doudou.algorithm.tree.BinaryTree;

/**
 * Create By 王嘉浩
 * Time 2022-10-24 20:47
 */
public class BinaryTreeTest {
    public static void main(String[] args) {
        BinaryTree<Integer, String> tree = new BinaryTree<Integer, String>();

        tree.put(6, "F");
        tree.put(2, "B");
        tree.put(7, "G");
        tree.put(1, "A");
        tree.put(4, "D");
        tree.put(9, "I");
        tree.put(8, "H");
        tree.put(3, "C");
        tree.put(5, "E");

        Queue queue = tree.midErgodic();

        while (!queue.isEmpty()) {
            System.out.print(queue.dequeue());
        }
    }
}
